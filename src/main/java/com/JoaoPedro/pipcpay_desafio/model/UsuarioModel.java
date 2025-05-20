package com.JoaoPedro.pipcpay_desafio.model;

import com.JoaoPedro.pipcpay_desafio.enums.TipoDeUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "CPF/CNPJ é obrigatório")
    @Size(max = 20, message = "CPF/CNPJ deve ter no máximo 20 caracteres")
    private String cpfCnpj;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    @NotNull(message = "Tipo de usuário é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoUsuario;

    @NotNull(message = "Saldo é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "Saldo não pode ser negativo")
    private Double saldo;
}