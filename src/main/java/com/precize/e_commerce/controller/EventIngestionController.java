package com.precize.e_commerce.controller;
import com.precize.e_commerce.services.FileEventIngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventIngestionController {

    private final FileEventIngestionService ingestionService;

    @PostMapping("/ingest")
    public String ingestEvents(@RequestParam String filePath) {
        ingestionService.ingestEventsFromFile(filePath);
        return "json decoding started: " + filePath;
    }
}

