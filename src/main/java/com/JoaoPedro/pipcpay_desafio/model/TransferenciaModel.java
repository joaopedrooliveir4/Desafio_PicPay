package com.JoaoPedro.pipcpay_desafio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
@Getter
@Setter
public class TransferenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", inclusive = true, message = "Valor deve ser maior que zero")
    private Double valor;

    @NotNull(message = "ID do pagador é obrigatório")
    private Long pagadorId;

    @NotNull(message = "ID do recebedor é obrigatório")
    private Long recebedorId;

    private LocalDateTime data;
}
