package com.github.gavioesdoforro.universirides.servico;

import com.github.gavioesdoforro.universirides.modelo.Carona;
import com.github.gavioesdoforro.universirides.repositorio.IRepositorioCarona;
import com.github.gavioesdoforro.universirides.repositorio.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoCarona {

    @Autowired
    private IRepositorioCarona repositorioCarona;

    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    public List<Carona> encontrarTodas () {
        return repositorioCarona.findAll();
    }

    public Carona inserir (Carona carona) {
         return repositorioCarona.save(carona);
    }

    public Carona encontrarPorId (Long id) {
        return repositorioCarona.getOne(id);
    }

    public void excluirPorId (Long id) {
        repositorioCarona.deleteById(id);
    }

    public List<Carona> buscarPorBairroOuDescricao (String parametroBusca) {
        return repositorioCarona.
                findByBairroContainingIgnoreCaseOrDescricaoContainingIgnoreCase(parametroBusca, parametroBusca);
    }
}
