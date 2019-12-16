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
    public ModelAndView home() {
        List<Carona> Caronas = servicoCarona.encontrarTodas();
        ModelAndView mav = new ModelAndView("visualizar_caronas");
        mav.addObject("listCaronas", Caronas);
        return mav;
    }

    @RequestMapping("/new")
    public String newCaronaForm(Map<String, Object> model) {
        Carona carona = new Carona();
        model.put("carona", carona);
        model.put("tipos", Tipo.values());
        model.put("turnos", Turno.values());
        return "nova_carona";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCarona(@ModelAttribute("carona") Carona carona) {
        //
        Usuario usuario = servicoUsuario.encontrarPorId(idUsuarioPadrao);
        carona.setUsuario(usuario);
        carona.setStatus(Status.Aberto);
        servicoCarona.inserir(carona);
        return "redirect:/carona/";
    }


    @RequestMapping("/edit")
    public ModelAndView editCaronaForm(@RequestParam long id, Map<String, Object> model) {
        ModelAndView mav = new ModelAndView("edit_carona");
        Carona carona = servicoCarona.encontrarPorId(id);
        mav.addObject("carona", carona);
        model.put("carona", carona);
        model.put("tipos", Tipo.values());
        model.put("turnos", Turno.values());
        model.put("status", Status.values());
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateCarona(@ModelAttribute("carona") Carona carona) {
        Usuario usuario = servicoUsuario.encontrarPorId(idUsuarioPadrao);
        carona.setUsuario(usuario);
        servicoCarona.inserir(carona);
        return "redirect:/carona/";
    }

    @RequestMapping("/delete")
    public String deleteCaronaForm(@RequestParam long id) {
        servicoCarona.excluirPorId(id);
        return "redirect:/carona/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String parametroBusca) {
        List<Carona> resultadoBusca = servicoCarona.buscarPorBairroOuDescricao(parametroBusca);
        ModelAndView mav = new ModelAndView("resultado_busca");
        mav.addObject("resultadoBusca", resultadoBusca);
        return mav;
    }
}
