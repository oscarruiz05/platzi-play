package com.example.platzi_play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("""
       Genera un saludo de bienvenida para un nuevo usuario de Platzi Play.
       El saludo debe ser amigable y motivador.
    """)
    String generateGreeting();
}
