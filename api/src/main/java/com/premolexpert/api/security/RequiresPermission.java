package com.premolexpert.api.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação para proteger endpoints com validação de permissão por Ação e Tela
 * Uso: @RequiresPermission(telaNom = "Clientes", acaoNom = "Consultar")
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermission {
    String telaNom() default "";
    String acaoNom() default "";
}

