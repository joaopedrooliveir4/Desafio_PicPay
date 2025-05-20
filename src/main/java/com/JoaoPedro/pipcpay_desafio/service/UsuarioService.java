package com.JoaoPedro.pipcpay_desafio.service;

import com.JoaoPedro.pipcpay_desafio.enums.TipoDeUsuario;
import com.JoaoPedro.pipcpay_desafio.exception.EntityNotFoundException;
import com.JoaoPedro.pipcpay_desafio.exception.ValidateUserTypeException;
import com.JoaoPedro.pipcpay_desafio.model.UsuarioModel;
import com.JoaoPedro.pipcpay_desafio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioModel salvarUsuario(UsuarioModel usuarioModel) {
        String senhaPura = usuarioModel.getSenha();

        String senhaCriptografada = passwordEncoder.encode(senhaPura);

        usuarioModel.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void validarTipoUsuarioParaTransferencia(UsuarioModel usuarioModel) {
        if (usuarioModel.getTipoUsuario() == TipoDeUsuario.LOJISTA) {
            throw new ValidateUserTypeException("LOJISTAS não podem transferir valores");
        }
    }

    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel) {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(usuarioModel.getId());

        if (usuarioExistente.isPresent()) {
            return usuarioRepository.save(usuarioModel);
        } else {
            throw new EntityNotFoundException("Usuário com id " + usuarioModel.getId() + " não encontrado");
        }
    }

    public void deletarUsuario(UsuarioModel usuarioModel) {
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findById(usuarioModel.getId());

        if (usuarioExistente.isPresent()) {
            usuarioRepository.delete(usuarioModel);
        } else {
            throw new EntityNotFoundException("Usuário com id " + usuarioModel.getId() + " não encontrado");
        }
    }
}
