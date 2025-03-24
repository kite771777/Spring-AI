package com.ai.SpringAi.Service;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageGenerationService {

    private final ImageModel stabilityAiImageModel;

    public ImageGenerationService(ImageModel stabilityAiImageModel) {
        this.stabilityAiImageModel = stabilityAiImageModel;
    }

    public ImageResponse generateImage(String prompt) {
        return stabilityAiImageModel.call(
                new ImagePrompt(prompt,
                        StabilityAiImageOptions.builder()
                                .stylePreset("cinematic")
                                .N(1)
                                .height(1024)
                                .width(1024)
                                .build()
                )
        );
    }
}