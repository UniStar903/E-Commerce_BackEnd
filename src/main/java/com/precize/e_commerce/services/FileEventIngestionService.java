package com.precize.e_commerce.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
@RequiredArgsConstructor
public class FileEventIngestionService {

    private final EventRepository eventRepository;
    private final EventProcessor eventProcessor;
    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public void ingestEventsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Event event = objectMapper.readValue(line, Event.class);
                System.out.println("Read");
                eventRepository.save(event);
                System.out.println("Saved");
                eventProcessor.processEvent(event);
                System.out.println("Processed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

