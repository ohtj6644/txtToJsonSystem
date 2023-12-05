package com.example.testToJSON;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Component
public class RegulationParser {

    public List<Regulation> parseRegulations() throws IOException {
        List<Regulation> regulations = new ArrayList<>();

        Resource resource = new ClassPathResource("static/file/test.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");

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

                regulations.add(regul);
            }
        }

        return regulations;
    }
}
