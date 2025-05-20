package com.JoaoPedro.pipcpay_desafio.service;

import com.JoaoPedro.pipcpay_desafio.exception.TransferException;
import com.JoaoPedro.pipcpay_desafio.exception.UsuarioNotFoundException;
import com.JoaoPedro.pipcpay_desafio.model.TransferenciaModel;
import com.JoaoPedro.pipcpay_desafio.model.UsuarioModel;
import com.JoaoPedro.pipcpay_desafio.repository.TransferenciaRepository;
import com.JoaoPedro.pipcpay_desafio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferenciaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public TransferenciaModel realizarTransferencia(TransferenciaModel transferenciaModel) {
        UsuarioModel pagador = usuarioRepository.findById(transferenciaModel.getPagadorId())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário pagador não encontrado"));

        UsuarioModel recebedor = usuarioRepository.findById(transferenciaModel.getRecebedorId())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário recebedor não encontrado"));

        usuarioService.validarTipoUsuarioParaTransferencia(pagador);

        if (pagador.getSaldo() < transferenciaModel.getValor()) {
            throw new TransferException("Saldo insuficiente");
        }

        pagador.setSaldo(pagador.getSaldo() - transferenciaModel.getValor());
        recebedor.setSaldo(recebedor.getSaldo() + transferenciaModel.getValor());

        usuarioRepository.save(pagador);
        usuarioRepository.save(recebedor);

        transferenciaModel.setData(LocalDateTime.now());

        return transferenciaRepository.save(transferenciaModel);
    }
}