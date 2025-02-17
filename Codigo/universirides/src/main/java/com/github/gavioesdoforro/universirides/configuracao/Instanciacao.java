package com.github.gavioesdoforro.universirides.configuracao;

import com.github.gavioesdoforro.universirides.modelo.*;
import com.github.gavioesdoforro.universirides.modelo.enums.*;
import com.github.gavioesdoforro.universirides.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//Classe de configuração para popular o banco com dados iniciais
@Configuration
public class Instanciacao implements CommandLineRunner {
    @Autowired
    RepositorioCarona RepositorioCarona;

    @Autowired
    RepositorioUsuario RepositorioUsuario;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Joao");
        usuario.setWhatsApp("62111111111");
        usuario.setVinculo(Vinculo.Discente);

        Carona carona = new Carona();
        carona.setTipo(Tipo.Ida);
        carona.setTurno(Turno.Verspertino);
        carona.setBairro("Sao Judas");
        carona.setUsuario(usuario);
        carona.setDescricao("Indo para a UFG as 12:00");
        carona.setStatus(Status.Aberto);

        System.out.println(RepositorioUsuario.save(usuario));
        System.out.println(RepositorioCarona.save(carona));
    }
}
