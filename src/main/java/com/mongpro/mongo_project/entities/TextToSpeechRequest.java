package com.mongpro.mongo_project.entities;

import lombok.Data;

@Data
public class TextToSpeechRequest {
    private String text;
    private String model_id;
}
