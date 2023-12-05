package com.example.testToJSON;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Component
public class RegulationParser {
    // text > Json 변환기

    public List<Regulation> parseRegulations(MultipartFile file) throws IOException {
        List<Regulation> regulations = new ArrayList<>();

        Resource resource = new ByteArrayResource(file.getBytes());
        // 넘겨받은  MultipartFile을 Resource로 변환


        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            // 버퍼리더 반복 중 예외가 발생할 수 있음으로 try/catch 문 사용


            // 첫 번째 라인을 읽고 버림
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                //탭을 기준으로 데이터를 자름.

                Regulation regul = new Regulation();
                regul.set사규아이디(data[0]);
                regul.set사규부모아이디(data[1]);
                regul.set카테고리아이디(data[2]);
                regul.set사규코드(data[3]);
                regul.set사규구분(data[4]);
                regul.set사규명(data[5]);
                regul.set제개정구분(data[6]);
                regul.set개정차수(data[7]);
                regul.set문서상태(data[8]);
                regul.set공포일(data[9]);
                regul.set시작일(data[10]);
                regul.set소관부서(data[11]);
                regul.set조문형식여부(data[12]);
                regul.set사규본문아이디(data[13]);
                regul.set카테고리정렬(data[14]);
                regul.set정렬순서(data[15]);
                // 자른 데이터를 regul 필드값에 순서대로 넣음.

                regulations.add(regul);
                // 리스트에 저장
            }
        }catch (IOException e) {
            String errorMessage = "에러 발생: " + e.getMessage();
            System.err.println(errorMessage);
            // 에러발생시 에러메세지 로그 프린트

        }

        return regulations;

    }
}
