package com.premolexpert.api.controller;

import com.premolexpert.api.dto.ForgotPasswordDTO;
import com.premolexpert.api.dto.LoginDTO;
import com.premolexpert.api.dto.ResetPasswordDTO;
import com.premolexpert.api.dto.TokenDTO;
import com.premolexpert.api.entity.Usuario;
import com.premolexpert.api.repository.UsuarioRepository;
import com.premolexpert.api.security.TokenService;
import com.premolexpert.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    // Endpoint para iniciar fluxo de esqueci minha senha
    // Agora: não altera a senha. Gera token temporário e envia link por e-mail.
    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@RequestBody ForgotPasswordDTO dto) {
        if (dto.getLogin() == null || dto.getLogin().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        var usuarioOpt = usuarioRepository.findByUsuLogin(dto.getLogin());
        if (usuarioOpt.isEmpty()) {
            // Não vaza existência do usuário
            return ResponseEntity.ok().build();
        }

        var usuario = usuarioOpt.get();
        var pessoa = usuario.getPessoa();
        var email = pessoa != null ? pessoa.getPesEmail() : null;

        if (email == null || email.isBlank()) {
            // Não podemos enviar e-mail
            return ResponseEntity.status(422).build();
        }

        // Gera token temporário de 1 hora com subject = login do usuário
        var token = tokenService.generateTokenForSubject(usuario.getUsuLogin(), Duration.ofHours(1));

        // Monta link de reset (ajuste baseUrl conforme ambiente)
        String resetUrl = "http://localhost:8081/reset-password.html?token=" + token;

        String subject = "Recuperação de senha - PreMolExpert";
        String body = "Olá " + (pessoa.getPesNom() != null ? pessoa.getPesNom() : "usuário") + ",\n\n" +
                "Recebemos uma solicitação para redefinir sua senha.\n\n" +
                "Para criar uma nova senha, clique no link abaixo:\n\n" +
                resetUrl + "\n\n" +
                "O link expira em 1 hora. Se você não solicitou essa alteração, ignore esta mensagem.\n\n" +
                "Por segurança, nunca compartilhe este link com outras pessoas.\n\n" +
                "Atenciosamente,\n" +
                "Equipe PreMolExpert";

        mailService.sendSimpleMessage(email, subject, body);

        return ResponseEntity.ok().build();
    }

    // Endpoint para resetar a senha usando o token enviado por e-mail
    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@RequestBody ResetPasswordDTO dto) {
        if (dto.getToken() == null || dto.getToken().isBlank() || dto.getNovaSenha() == null || dto.getNovaSenha().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            var subject = tokenService.getSubject(dto.getToken());
            var usuarioOpt = usuarioRepository.findByUsuLogin(subject);
            if (usuarioOpt.isEmpty()) return ResponseEntity.notFound().build();

            var usuario = usuarioOpt.get();
            usuario.setUsuSenha(passwordEncoder.encode(dto.getNovaSenha()));
            usuarioRepository.save(usuario);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // token inválido ou expirado
            return ResponseEntity.status(401).build();
        }
    }
}
