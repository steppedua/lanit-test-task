package ru.lanit.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.dto.StatisticsDto;
import ru.lanit.services.impl.StatisticsServiceImpl;

@RestController
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsServiceImpl statisticsService;

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsDto> getStatistics() {

        return ResponseEntity.ok(statisticsService.getStatistics());
    }
}
