package com.example.testToJSON;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RegulationController {


    private final RegulationParser regulationParser;

    public RegulationController(RegulationParser regulationParser) {
        this.regulationParser = regulationParser;
    }

    @GetMapping("/convertToJSON")
    public List<Regulation> convertToJSON() {
        String filePath = "path/to/your/text/file.txt";

        try {
            List<Regulation> regulations = regulationParser.parseRegulations(filePath);
            return regulations;
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리를 적절히 수행
            return null;
        }
    }
}
