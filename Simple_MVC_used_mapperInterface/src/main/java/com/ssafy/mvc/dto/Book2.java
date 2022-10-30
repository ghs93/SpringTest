package com.ssafy.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

//@Getter
//@Setter
//@ToString
//@Slf4j //logger 변수 추가
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode

@Data //Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor
public class Book2 {
    private String isbn;
    private String title;
    private String author;
    private int price;
    private String description;
    private String img;
    
}
