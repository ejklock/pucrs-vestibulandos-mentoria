package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.nota;

import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova.Prova;

public record DadosDetalhamentoNota(Long id, String nota) {

    public DadosDetalhamentoNota(Prova prova) {
        this(prova.getId(), prova.getNota());
    }
}
