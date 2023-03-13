package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova;

public record DadosAtualizacaoProva(
        Long id,
        String nome,
        String descricao,
        String localidade,
        String predio,
        String sala,
        String dia,
        String hora) {
}
