package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        String apiKey = "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";
        OpenAiService service = new OpenAiService(apiKey);


        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}