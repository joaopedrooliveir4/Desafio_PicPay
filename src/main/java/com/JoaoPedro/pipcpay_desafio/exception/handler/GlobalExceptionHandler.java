package com.JoaoPedro.pipcpay_desafio.exception.handler;

import com.JoaoPedro.pipcpay_desafio.exception.*;
import com.JoaoPedro.pipcpay_desafio.exception.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TransferException.class)
    public ResponseEntity<ApiError> handlerSaldoInsulficiente(TransferException exception) {
        ApiError apiError = new ApiError(
                "Transferência mal sucedida. Saldo Insuficiente",
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ApiError> handlerUsuarioNotFound(UsuarioNotFoundException exception) {
        ApiError apiError = new ApiError(
                "Usuário não encontrado",
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidateUserTypeException.class)
    public ResponseEntity<ApiError> handlerUserType(ValidateUserTypeException exception) {
        ApiError apiError = new ApiError(
                "LOJISTAS não podem transferir valores",
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handlerEntityNotFound(EntityNotFoundException exception) {
        ApiError apiError = new ApiError(
                "Usuário não encontrado",
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex) {
        ApiError apiError = new ApiError(
                "Erro interno",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocorreu um erro inesperado"
        );
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
