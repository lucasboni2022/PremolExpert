package com.premolexpert.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Serviço de envio de e-mails com fallback para console.
 * Se o JavaMailSender não estiver configurado, loga no console.
 */
@Service
public class MailService {

    @Autowired(required = false)
    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        // Se javaMailSender for null, faz fallback para log
        if (javaMailSender == null) {
            System.out.println("============================================");
            System.out.println("[MailService FALLBACK - SMTP não configurado]");
            System.out.println("Para: " + to);
            System.out.println("Assunto: " + subject);
            System.out.println("Mensagem:");
            System.out.println(text);
            System.out.println("============================================");
            return;
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            javaMailSender.send(message);

            System.out.println("[MailService] E-mail enviado com sucesso para: " + to);

        } catch (Exception e) {
            // Se houver erro, faz fallback para log
            System.out.println("============================================");
            System.out.println("[MailService ERROR ao enviar e-mail]");
            System.out.println("Erro: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            System.out.println("Para: " + to);
            System.out.println("Assunto: " + subject);
            System.out.println("Mensagem:");
            System.out.println(text);
            System.out.println("============================================");
        }
    }
}
