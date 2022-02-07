package com.beca.concessionaria.controllers;

import com.beca.concessionaria.dtos.requests.PostVendaRequest;
import com.beca.concessionaria.dtos.responses.PostVendaResponse;
import com.beca.concessionaria.services.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/venda")
public class VendaController {

    @Autowired
    private final   VendaService vendaService;

    @PostMapping
    public ResponseEntity<PostVendaResponse> adicionar(
            @RequestBody PostVendaRequest postVendaRequest) {

        PostVendaResponse postVendaResponse = vendaService.adicionar(postVendaRequest);

        return ResponseEntity.created(null).body(postVendaResponse);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<PostVendaResponse> atualizar(@RequestBody PostVendaRequest postVendaRequest, @PathVariable Long id) {
        PostVendaResponse atualizar = vendaService.atualizar(postVendaRequest, id);

        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        vendaService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<PostVendaResponse> obter(Long id) {
        PostVendaResponse obter= vendaService.obter(id);

        return ResponseEntity.ok(obter);
    }

    @GetMapping("/{listar}")
    public ResponseEntity<List<PostVendaResponse>> listar() {
        List<PostVendaResponse> mostrar = vendaService.mostrar();

        return ResponseEntity.ok(mostrar);
    }
}