package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.CriarProva;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.DadosAtualizacaoProva;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.DadosDetalhamentoProva;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.DadosListagemProva;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.Prova;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.ProvaRepository;

@RestController
@RequestMapping("provas")
public class ProvaController {

    @Autowired
    private ProvaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CriarProva dados) {
        repository.save(new Prova(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProva>> listar(
            @PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemProva::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoProva dados) {
        var prova = repository.getReferenceById(id);
        prova.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProva(prova));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var prova = repository.getReferenceById(id);
        prova.excluir();

        return ResponseEntity.noContent().build();
    }

}
