package com.kronosapinosql.handler;

import com.mongodb.MongoException;
import io.lettuce.core.RedisCommandTimeoutException;
import io.lettuce.core.RedisConnectionException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Chave duplicada (MongoDB)
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Erro: chave duplicada no banco NoSQL. " + ex.getMostSpecificCause().getMessage());
    }

    // Erros genéricos do MongoDB
    @ExceptionHandler(MongoException.class)
    public ResponseEntity<String> handleMongoException(MongoException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro no MongoDB: " + ex.getMessage());
    }

    // Erro de conexão Redis
    @ExceptionHandler(RedisConnectionException.class)
    public ResponseEntity<String> handleRedisConnectionException(RedisConnectionException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Erro de conexão com Redis: " + ex.getMessage());
    }

    // Timeout no Redis
    @ExceptionHandler(RedisCommandTimeoutException.class)
    public ResponseEntity<String> handleRedisTimeoutException(RedisCommandTimeoutException ex) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                .body("Timeout ao acessar Redis: " + ex.getMessage());
    }

    // Erros gerais do Redis
    @ExceptionHandler(RedisSystemException.class)
    public ResponseEntity<String> handleRedisSystemException(RedisSystemException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno no Redis: " + ex.getMessage());
    }

    // Erros genéricos de acesso a dados (Mongo ou Redis)
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro de acesso a dados NoSQL: " + ex.getMessage());
    }

    // Genérico (fallback)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro inesperado: " + ex.getMessage());
    }
}
