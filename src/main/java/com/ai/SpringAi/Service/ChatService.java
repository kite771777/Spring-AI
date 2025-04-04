package com.ai.SpringAi.Service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Cacheable(value = "aiResponses", key = "#prompt")
    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }
    public String getResponseOptions(String prompt) {
        ChatResponse response = chatModel.call(
                new Prompt(
                       prompt,
                        OllamaOptions.builder()
                                .model("mistral")
                                .temperature(0.4)
                                .build()
                ));
        return response.getResult().getOutput().getText();
    }
    public String createRecipe(String ingredients, String cuisine, String dietaryRestrictions) {
        // Create the prompt template
        String template = "Please consider the following dietary restrictions: " + dietaryRestrictions + ".\n" +
                "Cuisine: " + cuisine + ".\n" +
                "Ingredients: " + ingredients + ".\n" +
                "Please provide me with a detailed recipe including a title, cooking instructions, and serving suggestions.";

        // Call the AI model with the recipe prompt
        return getResponse(template);
    }
}