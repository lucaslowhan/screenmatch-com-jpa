package br.com.alura.screenmatch.service;


import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {
    private static final String GEMINI_API_KEY = System.getenv("GEMINI_API_KEY");

    public static String obterTraducao(String texto){
        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(GEMINI_API_KEY)
                .modelName("gemini-1.5-flash")
                .maxOutputTokens(1000)
                .temperature(0.7)
                .build();

        var response = gemini.generate("Traduza para português o texto: " + texto);
        return response;
    }

}
