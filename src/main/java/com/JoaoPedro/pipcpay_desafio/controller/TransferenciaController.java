package com.JoaoPedro.pipcpay_desafio.controller;

import com.JoaoPedro.pipcpay_desafio.exception.TransferException;
import com.JoaoPedro.pipcpay_desafio.exception.UsuarioNotFoundException;
import com.JoaoPedro.pipcpay_desafio.model.TransferenciaModel;
import com.JoaoPedro.pipcpay_desafio.model.UsuarioModel;
import com.JoaoPedro.pipcpay_desafio.repository.TransferenciaRepository;
import com.JoaoPedro.pipcpay_desafio.repository.UsuarioRepository;
import com.JoaoPedro.pipcpay_desafio.service.TransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transfer")
@Tag(name = "Transferências", description = "Gerenciamento de transferências")
public class TransferenciaController {

    @Autowired
    private TransferenciaRepository transferenciaRepository;
    @Autowired
    private TransferenciaService transferenciaService;

    @Operation(summary = "Envia uma transferência")
    @PostMapping
    @Transactional
    public TransferenciaModel enviarTransferencia(@RequestBody TransferenciaModel transfer) {
        return transferenciaService.realizarTransferencia(transfer);
    }

    @Operation(summary = "Lista todas as transferências")
    @GetMapping
    public List<TransferenciaModel> listarTransferencias() {
        return transferenciaRepository.findAll();
    }

    @Operation(summary = "Busca uma transferência por id")
    @GetMapping("{id}")
    public TransferenciaModel buscarTransferPorId(@PathVariable Long id) { return transferenciaRepository.findById(id).orElse(null); }
}
