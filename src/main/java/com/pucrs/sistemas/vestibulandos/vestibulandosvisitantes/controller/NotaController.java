package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.nota.DadosAtualizacaoNota;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.nota.DadosDetalhamentoNota;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.ProvaRepository;

@RestController
@RequestMapping("notas")
public class NotaController {

    @Autowired
    private ProvaRepository repository;

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarNota(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoNota dados) {
        var prova = repository.getReferenceById(id);
        prova.atualizarInformacoesNota(dados);

        return ResponseEntity.ok(new DadosDetalhamentoNota(prova));
    }
}
