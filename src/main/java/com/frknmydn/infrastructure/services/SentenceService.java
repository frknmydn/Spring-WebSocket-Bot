package com.frknmydn.infrastructure.services;

import com.frknmydn.infrastructure.abstractions.repositories.ISentenceRepository;
import com.frknmydn.infrastructure.abstractions.services.ISentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SentenceService implements ISentenceService {

    @Autowired
    private ISentenceRepository _sentenceRepository;


    @Override
    public ArrayList<String> getAllSentences() {
        return this._sentenceRepository.getAllSentences();
    }
}
