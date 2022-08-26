package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.dto.CreateQuestionRequest;
import com.example.trex.onlineexamination.dto.QuestionRequest;
import com.example.trex.onlineexamination.model.*;
import com.example.trex.onlineexamination.repository.AnswerRepo;
import com.example.trex.onlineexamination.repository.ExamRepo;
import com.example.trex.onlineexamination.repository.QuestionRepo;
import com.example.trex.onlineexamination.repository.RefAnswerRepo;
import com.example.trex.onlineexamination.service.MailService;
import com.example.trex.onlineexamination.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepository;
    @Autowired
    private AnswerRepo answerRepository;

    @Autowired
    private ExamRepo examRepository;

    @Autowired
    private RefAnswerRepo refAnswerRepository;

    @Autowired
    private MailService mailService;

//    @Override
//    public ExamHistory getCorrect(AnswerRequest request) {
//        ExamHistory examHistory = new ExamHistory();
//        examHistory.setStudent(new Student(request.getStudentId()));
//        examHistory.setSubject(new Subject(request.getSubjectId()));
//        int correct = 0;
//        int total = request.getAnswers().size();
//
//        for (int i = 0; i < total; i++) {
//            Long questionId = request.getAnswers().get(i).getId();
//            Question question = questionRepository.findById(questionId).orElse(new Question());
//            try {
//                String a = question.getCorrect();
//
//                long b = request.getAnswers().get(i).getAnswer();
//                Answer answer = answerRepository.findById(b).orElse(new Answer());
//
//                if (a.equals(answer.getTitle())) {
//                    correct++;
//                }
//            } catch (Exception e) {
//                System.out.println();
//            }
//        }
//
//        examHistory.setCorrect(correct);
//        examHistory.setTotal(total);
//
//        return examHistory;
//    }

    @Override
    public void saveListQuestion(QuestionRequest questionRequest) {
        List<Question> listQuestionRequest = questionRequest.getListQuestions();
        Subject subject = new Subject();
        subject.setId(questionRequest.getSubjectID());

        Teacher user = new Teacher();
        user.setId(questionRequest.getTeacherID());
        //save Exam.
        Exam exam = new Exam();

        exam.setDuration(questionRequest.getDuration());
        exam.setTime(questionRequest.getTime());
        exam.setDate(questionRequest.getDate());
        exam.setTeacher(user);
        exam.setDateCreated(questionRequest.getCreatedDate());
        exam.setSubject(subject);
        System.err.println(exam.getSubject().getId() + "exam....................");
        examRepository.save(exam);

        //
        for (int i = 0; i < listQuestionRequest.size(); i++) {
            Question question = listQuestionRequest.get(i);
            question.setExam(exam);
            System.err.println(subject.toString());
            questionRepository.save(question);
            for (int k = 0; k < listQuestionRequest.get(i).getAnswers().size(); k++) {
                Answer answer = listQuestionRequest.get(i).getAnswers().get(k);
                answer.setQuestion(question);
                System.err.println(answer);
                answerRepository.save(answer);
            }
        }
    }

    @Override
    public QuestionRequest getListQuestion(Long idExam) {
        Exam exam = examRepository.getById(idExam);
//        return questionRepository.findByExamId(idExam);

        List<Question> questions = questionRepository.findByExamId(idExam);
        QuestionRequest rs = new QuestionRequest();
        rs.setListQuestions(questions);
        rs.setDate(exam.getDate());
        rs.setDuration(exam.getDuration());
        rs.setTime(exam.getTime());
        rs.setSubjectID(exam.getSubject().getId());
        rs.setName(exam.getSubject().getName());

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.setTime(rs.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        calendar.add(Calendar.MINUTE, rs.getDuration());

        Date addMinutes = calendar.getTime();

        System.out.println(calendar.getTime());
        rs.setDateTime(sdf.format(addMinutes));
        return rs;
    }

    @Override
    @Transactional
    public Question createQuestion(CreateQuestionRequest question) {

        Question q = new Question();
        q.setTitle(question.getTitle());
        q.setCorrect(question.getCorrect());
        q.setAnswers(question.getAnswers());
        q.setExam(question.getExam());

        Question qs = questionRepository.save(q);

        if (qs != null) {
            for (Answer ans : qs.getAnswers()) {
                ans.setQuestion(qs);
                answerRepository.save(ans);
            }
            return qs;
        }
        return qs;
    }

    @Override
    @Transactional
    public Question updateQuestion(Long questionID, Question newQuestion) {
        Optional<Question> question = questionRepository.findById(questionID);
        if (question.isPresent()) {
            Question qs = question.get();
            qs.setTitle(newQuestion.getTitle());
            qs.setAnswers(newQuestion.getAnswers());
            qs.setCorrect(newQuestion.getCorrect());

            Exam exam = examRepository.findById(qs.getExam().getId()).orElse(new Exam());
            for (RefAnswer refAnswer : exam.getRefExams()) {
                int lastCorrect = refAnswer.getLastCorrect();
                int correct = refAnswer.correct();
                if (correct != lastCorrect) {
//                       send mail
                    SimpleMailMessage msg = new SimpleMailMessage();
                    msg.setTo(refAnswer.getStudent().getUser().getEmail());

                    msg.setSubject("Your mark was updated");
                    msg.setText("Please check your mark because the teach already updated answers for the question!");
                    mailService.sendEmail(msg);

                    refAnswer.setLastCorrect(correct);
                    refAnswerRepository.save(refAnswer);

                }
            }
            return questionRepository.save(qs);
        }
        return null;
    }

    @Override
    public Question createQuestion(Question question) {
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    @Transactional
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id).orElse(new Question());
        for (Answer ans : question.getAnswers()) {
            answerRepository.deleteById(ans.getId());
        }
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getByExam(Long examID) {
        return null;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Long id, Answer newAnswer) {
        Optional<Answer> answer = answerRepository.findById(id);
        if (answer.isPresent()) {
            Answer as = answer.get();
            as.setTitle(newAnswer.getTitle());
            return answerRepository.save(as);
        }
        return null;
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }


}

