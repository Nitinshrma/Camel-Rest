package com.tls.camel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Mono;

public class GlobalErrorHandler {
	  /**
     * Translation key for i18n
     */
    public final static String I18N_KEY_ERROR_TECHNICAL_EXCEPTION = "error.technical.exception";

    public static Mono<Object> manageError(ClientResponse clientResponse) {

        if (clientResponse.statusCode().is4xxClientError()) {
            // re-throw original status and message or they will be lost
            return clientResponse.bodyToMono(TaasheeException.class).flatMap(response -> {
                return Mono.error(new ResponseStatusException(500, response.getMessage(), response));
            });
        } else { // Case when it's 5xx ClientError
            // User doesn't have to know which technical exception has happened
            return clientResponse.bodyToMono(TaasheeException.class).flatMap(response -> {
                return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        I18N_KEY_ERROR_TECHNICAL_EXCEPTION));
            });
        }

    }
}
