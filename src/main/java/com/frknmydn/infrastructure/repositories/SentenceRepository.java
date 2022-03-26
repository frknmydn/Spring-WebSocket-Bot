package com.frknmydn.infrastructure.repositories;

import com.frknmydn.infrastructure.abstractions.repositories.ISentenceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SentenceRepository implements ISentenceRepository {

    private ArrayList<String> sentences = new ArrayList<>();

    public SentenceRepository(){
        sentences.add("Hi, Welcome to our company, we are here to assist you. Please contact us on: test@test.com");
        sentences.add("Hi, we are here to assist you Please contact us on: test@test.com");
    }

    @Override
    public ArrayList<String> getAllSentences() {
        return this.sentences;
    }
}
