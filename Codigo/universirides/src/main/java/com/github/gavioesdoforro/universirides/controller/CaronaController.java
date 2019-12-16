package com.github.gavioesdoforro.universirides.controller;

import com.github.gavioesdoforro.universirides.modelo.*;
import com.github.gavioesdoforro.universirides.modelo.enums.*;
import com.github.gavioesdoforro.universirides.servico.ServicoCarona;
import com.github.gavioesdoforro.universirides.servico.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/carona")
public class CaronaController {

    @Autowired
    private ServicoUsuario servicoUsuario;

    @Autowired
    private ServicoCarona servicoCarona;

    private Long idUsuarioPadrao = (long)1;

    @RequestMapping("/")
    public ModelAndView visualizarCaronas() {
        List<Carona> Caronas = servicoCarona.encontrarTodas();
        ModelAndView modelAndView = new ModelAndView("visualizar_caronas");
        modelAndView.addObject("Caronas", Caronas);
        return modelAndView;
    }

    @RequestMapping("/new")
    public String criarCarona(Map<String, Object> model) {
        Carona carona = new Carona();
        model.put("carona", carona);
        model.put("tipos", Tipo.values());
        model.put("turnos", Turno.values());
        return "nova_carona";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String salvarCarona(@ModelAttribute("carona") Carona carona) {
        Usuario usuario = servicoUsuario.encontrarPorId(idUsuarioPadrao);
        carona.setUsuario(usuario);
        carona.setStatus(Status.Aberto);
        servicoCarona.inserir(carona);
        return "redirect:/carona/";
    }


    @RequestMapping("/edit")
    public ModelAndView editarCarona(@RequestParam long id, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("editar_carona");
        Carona carona = servicoCarona.encontrarPorId(id);
        modelAndView.addObject("carona", carona);
        model.put("carona", carona);
        model.put("tipos", Tipo.values());
        model.put("turnos", Turno.values());
        model.put("status", Status.values());
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String atualizarCarona(@ModelAttribute("carona") Carona carona) {
        Usuario usuarioPadrao = servicoUsuario.encontrarPorId(idUsuarioPadrao);
        carona.setUsuario(usuarioPadrao);
        servicoCarona.inserir(carona);
        return "redirect:/carona/";
    }

    @RequestMapping("/delete")
    public String excluirCaronaForm(@RequestParam long id) {
        servicoCarona.excluirPorId(id);
        return "redirect:/carona/";
    }

    @RequestMapping("/search")
    public ModelAndView buscarCarona(@RequestParam String parametroBusca) {
        List<Carona> resultadoBusca = servicoCarona.buscarPorBairroOuDescricao(parametroBusca);
        ModelAndView modelAndView = new ModelAndView("resultado_busca");
        modelAndView.addObject("resultadoBusca", resultadoBusca);
        return modelAndView;
    }
}
