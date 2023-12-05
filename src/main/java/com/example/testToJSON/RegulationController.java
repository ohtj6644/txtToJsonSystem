package com.example.testToJSON;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RegulationController {


    private final RegulationParser regulationParser;

    public RegulationController(RegulationParser regulationParser) {
        this.regulationParser = regulationParser;
    }

    @GetMapping("/convertToJSON")
    public List<Regulation> convertToJSON() {
        String filePath = "classpath:file/test.txt";

        try {
            List<Regulation> regulations = regulationParser.parseRegulations();
            return regulations;
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리를 적절히 수행
            return null;
        }
    }
}
