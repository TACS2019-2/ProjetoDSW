package com.github.gavioesdoforro.universirides.servico;

import com.github.gavioesdoforro.universirides.modelo.Usuario;
import com.github.gavioesdoforro.universirides.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario encontrarPorId (Long id) {
        return repositorioUsuario.findById(id).get();
    }
}
