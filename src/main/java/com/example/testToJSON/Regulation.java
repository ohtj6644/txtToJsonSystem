package com.example.testToJSON;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Regulation {
    private String 사규아이디;
    private String 사규부모아이디;
    private String 카테고리아이디;
    private String 사규코드;
    private String 사규구분;
    private String 사규명;
    private String 제개정구분;
    private String 개정차수;
    private String 문서상태;
    private String 공포일;
    private String 시작일;
    private String 소관부서;
    private String 조문형식여부;
    private String 사규본문아이디;
    private String 카테고리정렬;
    private String 정렬순서;
}
