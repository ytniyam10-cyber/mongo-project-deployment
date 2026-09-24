package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.entities.TextToSpeechRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ElevenLabsService {
    private final String apiKey= "sk_ae18ed240a7f67c1e5184a6de573167b8b4bb28dd7694113";
    private final String VOICE_ID= "hpp4J3VqNfWAUOO0d1Us";
    private final String API= "https://api.elevenlabs.io/v1/text-to-speech/" + VOICE_ID;
    @Autowired
    public RestTemplate restTemplate;

    public byte[] generateSpeech(TextToSpeechRequest request){
        HttpHeaders headers= new HttpHeaders();
        headers.set("xi-api-key", apiKey);
        headers.set("Content-Type","application/json");
        HttpEntity<TextToSpeechRequest> entity= new HttpEntity<>(request,headers);
        ResponseEntity<byte[]> exchange = restTemplate.exchange(API, HttpMethod.POST, entity, byte[].class);
        return exchange.getBody();
    }

}
