package com.example.testToJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegulationParser {

    public List<Regulation> parseRegulations(String filePath) throws IOException {
        List<Regulation> regulations = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");

                Regulation regulation = new Regulation();
                regulation.set사규아이디(data[0]);
                regulation.set사규부모아이디(data[1]);
                regulation.set카테고리아이디(data[2]);
                regulation.set사규코드(data[3]);
                regulation.set사규구분(data[4]);
                regulation.set사규명(data[5]);
                regulation.set제개정구분(data[6]);
                regulation.set개정차수(data[7]);
                regulation.set문서상태(data[8]);
                regulation.set공포일(data[9]);
                regulation.set시작일(data[10]);
                regulation.set소관부서(data[11]);
                regulation.set조문형식여부(data[12]);
                regulation.set사규본문아이디(data[13]);
                regulation.set카테고리정렬(data[14]);
                regulation.set정렬순서(data[15]);

                regulations.add(regulation);
            }
        }

        return regulations;
    }
}
