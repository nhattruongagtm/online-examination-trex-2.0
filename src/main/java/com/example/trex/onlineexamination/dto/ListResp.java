package com.example.trex.onlineexamination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ListResp<T> {
    private int totalPages;
    private Long totalItems;
    private int currentPage;
    private List<T> list;
}
