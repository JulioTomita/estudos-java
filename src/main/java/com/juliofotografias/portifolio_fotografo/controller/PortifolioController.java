package com.juliofotografias.portifolio_fotografo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.juliofotografias.portifolio_fotografo.entity.Portifolio;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class PortifolioController {

    @RequestMapping("/home")
    public List<Portifolio> listar(){
            Portifolio home1 = new Portifolio(
            1L,
            "Julio Fotografias",
            "Fotografo profissional especializado em casamentos e eventos.",
            "https://example.com/imagem1.jpg");
            
            Portifolio home2 = new Portifolio(
            2L,
            "Portifolio 2",
            "Descricao do portifolio 2",
            "https://example.com/imagem2.jpg");

            Portifolio home3 = new Portifolio(
            3L,
            "Portifolio 3",
            "Descricao do portifolio 3",
            "https://example.com/imagem3.jpg");

            return Arrays.asList(home1, home2, home3);
    }
    
    
}
