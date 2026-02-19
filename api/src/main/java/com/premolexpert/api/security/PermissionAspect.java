package com.premolexpert.api.security;

import com.premolexpert.api.entity.Usuario;
import com.premolexpert.api.repository.PermissaoAcessoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class PermissionAspect {

    @Autowired
    private PermissaoAcessoRepository permissaoAcessoRepository;

    @Around("@annotation(requiresPermission)")
    public Object checkPermission(ProceedingJoinPoint joinPoint, RequiresPermission requiresPermission) throws Throwable {
        // Obter autenticação do usuário
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof Usuario)) {
            throw new SecurityException("Usuário não autenticado");
        }

        Usuario usuario = (Usuario) authentication.getPrincipal();

        // Se usuário não tem perfil, negar acesso
        if (usuario.getPerfil() == null) {
            throw new SecurityException("Usuário sem perfil associado");
        }

        // Validar se usuário tem permissão para acessar Tela + Ação
        String telaNom = requiresPermission.telaNom();
        String acaoNom = requiresPermission.acaoNom();

        boolean temPermissao = permissaoAcessoRepository.existsByPerfilAndTelaAndAcao(
            usuario.getPerfil(),
            telaNom,
            acaoNom
        );

        if (!temPermissao) {
            throw new SecurityException(
                "Acesso negado. Permissão necessária: Tela=" + telaNom + ", Ação=" + acaoNom
            );
        }

        // Se tem permissão, prosseguir com o método
        return joinPoint.proceed();
    }
}

