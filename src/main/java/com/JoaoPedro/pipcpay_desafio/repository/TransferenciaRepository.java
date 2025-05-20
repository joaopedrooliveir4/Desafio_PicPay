package com.JoaoPedro.pipcpay_desafio.repository;

import com.JoaoPedro.pipcpay_desafio.model.TransferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long> {
}
