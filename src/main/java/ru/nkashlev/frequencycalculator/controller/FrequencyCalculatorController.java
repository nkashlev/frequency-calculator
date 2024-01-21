package ru.nkashlev.frequencycalculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nkashlev.frequencycalculator.service.FrequencyService;

import java.util.Map;

@RestController
@Tag(name = "FrequencyCalculatorController", description = "Frequency Calculator API")
public class FrequencyCalculatorController {
    private final FrequencyService frequencyService;

    public FrequencyCalculatorController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @GetMapping("/api/v1/frequency")
    @Operation(summary = "get result map")
    public Map<Character, Integer> getResultMap(@Schema(example = "aaaaabcccc")
                                                    @RequestParam String requestString) {
        return frequencyService.calculateFrequency(requestString);
    }

}
