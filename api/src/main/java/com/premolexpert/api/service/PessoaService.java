package com.premolexpert.api.service;

import org.springframework.data.domain.Page;

public interface PessoaService<T> {
    Page<T> getAll(int page, int size);
    T getById(Integer id);
    T create(T pessoaDTO);
    T update(T pessoaDTO);
    void delete(Integer id);
}
