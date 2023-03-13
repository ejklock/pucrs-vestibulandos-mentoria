package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.prova;

import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.especialidade.Especialidade;

import jakarta.validation.constraints.NotBlank;

public record CriarProva(
        @NotBlank String nome,
        @NotBlank String descricao,
        Especialidade especialidade,
        @NotBlank String localidade,
        @NotBlank String predio,
        @NotBlank String sala,
        @NotBlank String dia,
        @NotBlank String hora,
        @NotBlank String nota) {
}
