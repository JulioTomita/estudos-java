package com.juliofotografias.portfolio_fotografo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.juliofotografias.portfolio_fotografo.entity.Portfolio;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class PortfolioController {

    @RequestMapping("/home")
    public List<Portfolio> listar(){
            Portfolio home1 = new Portfolio(
            1L,
            "Julio Fotografias",
            "Fotografo profissional especializado em casamentos e eventos.",
            "https://example.com/imagem1.jpg");
            
            Portfolio home2 = new Portfolio(
            2L,
            "Portifolio 2",
            "Descricao do portifolio 2",
            "https://example.com/imagem2.jpg");

            Portfolio home3 = new Portfolio(
            3L,
            "Portifolio 3",
            "Descricao do portifolio 3",
            "https://example.com/imagem3.jpg");

            return Arrays.asList(home1, home2, home3);
    }
    
    
}
