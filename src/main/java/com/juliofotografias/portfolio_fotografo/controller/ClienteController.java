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

import com.juliofotografias.portfolio_fotografo.entity.Cliente;
import com.juliofotografias.portfolio_fotografo.repository.ClienteRepository;

@RestController
public class ClienteController {

    /* 
    @RequestMapping("/home")
    public List<Clientes> listar() {
        Clientes home1 = new Clientes(
                1L,
                "Julio Fotografias",
                "Fotografo profissional especializado em casamentos e eventos.",
                "https://example.com/imagem1.jpg");

        Clientes home2 = new Clientes(
                2L,
                "Portifolio 2",
                "Email do portifolio 2",
                "https://example.com/imagem2.jpg");

        Clientes home3 = new Clientes(
                3L,
                "Portifolio 3",
                "Email do portifolio 3",
                "https://example.com/imagem3.jpg");

        return Arrays.asList(home1, home2, home3);
    }
     */
    @Autowired
    ClienteRepository repository;

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente Cliente) {
        Cliente clienteSalva = repository.save(Cliente);
        return new ResponseEntity<>(clienteSalva, HttpStatus.OK);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> Clientes = new ArrayList<>();
        repository.findAll().forEach(Clientes::add);

        return new ResponseEntity<>(Clientes, HttpStatus.OK);

    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {

        Optional<Cliente> clienteDesatualizado = repository.findById(id);

        if (clienteDesatualizado.isPresent()) {
                Cliente clienteAtualizado = clienteDesatualizado.get();
                clienteAtualizado.setNome(cliente.getNome());
                clienteAtualizado.setEmail(cliente.getEmail());
                clienteAtualizado.setTelefone(cliente.getTelefone());

            return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Cliente> deletar(
            @PathVariable Long id) {
        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
