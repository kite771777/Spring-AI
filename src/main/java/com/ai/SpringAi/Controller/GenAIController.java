package com.ai.SpringAi.Controller;

import com.ai.SpringAi.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenAIController {
    @Autowired
    ChatService chatService;

    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }
    @GetMapping("/options-ai")
    public String getResponseOptions(@RequestParam String prompt) {
        return chatService.getResponseOptions(prompt);
    }
    @GetMapping("/generate-recipe")
    public String generateRecipe(@RequestParam String ingredients,
                                 @RequestParam String cuisine,
                                 @RequestParam String dietaryRestrictions) {
        return chatService.createRecipe(ingredients, cuisine, dietaryRestrictions);
    }
}
