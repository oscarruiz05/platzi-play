package com.example.platzi_play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("""
       Genera un saludo de bienvenida para un nuevo usuario de Platzi Play.
       El saludo debe ser amigable y motivador.
    """)
    String generateGreeting();

    @SystemMessage("""
        Eres un experto en cine que recomienda películas personalizadas según los gustos del ususario.
        Debes recomendar máximo 3 películas.
        No incluyas películas que estén por fuera de la plataforma PlatziPlay
    """)
    String generateMovieRecommendation(@UserMessage String userPreferences);
}
