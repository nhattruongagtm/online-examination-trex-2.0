package com.example.trex.onlineexamination.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddListStudent {
    long idClass;
    List<Long> listIdStudent;
}
