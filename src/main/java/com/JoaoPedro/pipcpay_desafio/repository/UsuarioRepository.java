package com.JoaoPedro.pipcpay_desafio.repository;

import com.JoaoPedro.pipcpay_desafio.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
