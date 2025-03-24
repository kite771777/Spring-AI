package com.ai.SpringAi.Controller;

import com.ai.SpringAi.Service.ImageGenerationService;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {

    @Autowired
    ImageGenerationService imageService;

    @GetMapping("/image-generate")
    public ImageResponse generateImage(@RequestParam String prompt) {
        return imageService.generateImage(prompt);
    }
}
