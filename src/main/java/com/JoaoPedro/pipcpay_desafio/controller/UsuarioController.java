package com.JoaoPedro.pipcpay_desafio.controller;

import com.JoaoPedro.pipcpay_desafio.model.UsuarioModel;
import com.JoaoPedro.pipcpay_desafio.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@Tag(name = "Usuários", description = "Gerenciamento de usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Envia um novo usuário")
    @PostMapping
    public ResponseEntity<UsuarioModel> enviarUsuario(@Valid @RequestBody UsuarioModel user) {
        UsuarioModel novoUsuario = usuarioService.salvarUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @Operation(summary = "Busca um usuário por id")
    @GetMapping("{id}")
    public ResponseEntity<UsuarioModel> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuarioPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualiza um usuário")
    @PutMapping("{id}")
    public UsuarioModel atualizarUsuarioPorId(@PathVariable Long id,@RequestBody UsuarioModel usuarioModel) {
        usuarioModel.setId(id);
        return usuarioService.atualizarUsuario(usuarioModel);
    }

    @Operation(summary = "Deleta um usuário")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setId(id);

        usuarioService.deletarUsuario(usuario);
        return ResponseEntity.ok("Usuário deletado com sucesso");
    }
}
