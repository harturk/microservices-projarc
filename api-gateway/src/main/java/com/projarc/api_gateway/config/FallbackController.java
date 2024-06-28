package com.projarc.api_gateway.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    // TODO falta configurar o redirecionamento de fallback no application.yaml
    @GetMapping("/assinvalida/{id}")
    public ResponseEntity<String> cacheFallback() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Serviços temporariamente indisponíveis. Tente novamente.");
        // Implementação mais adequada seria retornar dados em cache de
        // uma requisição anterior com sucesso
    }
}
