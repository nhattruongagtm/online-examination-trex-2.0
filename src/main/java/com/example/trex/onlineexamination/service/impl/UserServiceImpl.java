package com.example.trex.onlineexamination.service.impl;

import com.example.trex.onlineexamination.model.User;
import com.example.trex.onlineexamination.repository.SubjectRepo;
import com.example.trex.onlineexamination.repository.UserRepo;
import com.example.trex.onlineexamination.service.MailService;
import com.example.trex.onlineexamination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SubjectRepo subjectRespository;

    @Autowired
    MailService mailService;

    @Override
    public User getUserByID(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User save(User u) {
        return userRepo.save(u);
    }

    @Override
    public User addStudent(User u) {
        return userRepo.save(u);
    }

    @Override
    public String forgotPassword(String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepo.findByEmail(email));
        if(!userOptional.isPresent()){
            return "Invalid email";
        }
        User user = userOptional.get();
        user.setTokenCreationDate(LocalDateTime.now());
        user.setToken(generateToken());
        userRepo.save(user);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Password Reset Request");
        msg.setText("To reset your password, click the link below: \n"+"http://localhost:3000/dat-lai-mat-khau?token="+user.getToken());

        mailService.sendEmail(msg);
        return "Please check your email to reset password";
    }

    public String generateToken(){
        StringBuilder token = new StringBuilder();
        return token.append(
                UUID.randomUUID().toString().replace("-","")
        ).toString();
    }

    @Override
    public String resetPassword(String token, String password) {
        Optional<User> userOptional= Optional.ofNullable(userRepo.findByToken(token));
        if(!userOptional.isPresent()){
            return "Invalid token";
        }
        User user = userOptional.get();
        if(isTokenExpired(user.getTokenCreationDate())){
            return "Token Expired";
        }
        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);
        userRepo.save(user);
        return "Your password successfull update";
    }

    @Override
    public List<User> getUsers() {
        List<User> u = new ArrayList<>();
        List<User> u1 = userRepo.findAll();
//        for (int i = 0; i < u1.size(); i++) {
//            if (u1.get(i).getType() == 0 && u1.get(i).getType() == null) {
//                u.add(u1.get(i));
//            }
//        }
        return u;
    }

    @Override
    public boolean isTokenExpired(LocalDateTime tokenCreationDate) {
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate,now);
        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }

    @Override
    public User changePassword(Long id, String password) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            User u = user.get();
            u.setPassword(passwordEncoder.encode(password));
            return userRepo.save(u);
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.get();
    }

    @Override
    public List<User> getUserByType() {
        return userRepo.findByType();
    }

    @Override
    public List<User> getAllStundentBySubjectId(Long id) {
        User u = new User();
        List<User> user = (List<User>) subjectRespository.findById(id).get().getUser();
        return user;
    }

    @Override
    public List<User> getUserByClassID(long classID) {
        return null;
    }


}
