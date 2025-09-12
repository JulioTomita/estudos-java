package com.juliofotografias.portfolio_fotografo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juliofotografias.portfolio_fotografo.entity.Portfolio;
import com.juliofotografias.portfolio_fotografo.repository.PortfolioRepository;

@RestController
public class PortfolioController {

    /* 
    @RequestMapping("/home")
    public List<Portfolio> listar() {
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
     */
    @Autowired
    PortfolioRepository repository;

    @PostMapping("/portfolio")
    public ResponseEntity<Portfolio> salvar(@RequestBody Portfolio portfolio) {
        Portfolio portfolioSalva = repository.save(portfolio);
        return new ResponseEntity<>(portfolioSalva, HttpStatus.OK);
    }

    @GetMapping("/portfolio")
    public ResponseEntity<List<Portfolio>> listar() {
        List<Portfolio> portfolios = new ArrayList<>();
        repository.findAll().forEach(portfolios::add);

        return new ResponseEntity<>(portfolios, HttpStatus.OK);

    }

    @PutMapping("/portfolio/{id}")
    public ResponseEntity<Portfolio> atualizar(
            @PathVariable Long id,
            @RequestBody Portfolio portfolio) {

        Optional<Portfolio> portfolioDesatualizado = repository.findById(id);

        if (portfolioDesatualizado.isPresent()) {
            Portfolio portfolioAtualizado = portfolioDesatualizado.get();
            portfolioAtualizado.setNome(portfolio.getNome());
            portfolioAtualizado.setDescricao(portfolio.getDescricao());
            portfolioAtualizado.setLink_imagem(portfolio.getLink_imagem());

            return new ResponseEntity<>(portfolioAtualizado, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/portfolio/{id}")
    public ResponseEntity<Portfolio> deletar(
            @PathVariable Long id) {
        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
