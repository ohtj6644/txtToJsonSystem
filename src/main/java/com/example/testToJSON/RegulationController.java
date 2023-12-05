package com.example.testToJSON;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class RegulationController {


    private final RegulationParser regulationParser;

    public RegulationController(RegulationParser regulationParser) {
        this.regulationParser = regulationParser;
    }

    @PostMapping("/testJson")
    public List<Regulation> convertToJSON(@RequestParam("file") MultipartFile file) {

        try {
            List<Regulation> regulations = regulationParser.parseRegulations(file);
            return regulations;
            //만들어놓은 변환기(regulationParser) 에서  변환받은 리스트 반환.

        } catch (IOException e) {
            e.printStackTrace();
            // 예외처리 , Exception 발생시 null 반환
            return null;
        }
    }
}
