
package com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.grade.CriarGrade;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.grade.Grade;
import com.pucrs.sistemas.vestibulandos.vestibulandosvisitantes.domain.provas.grade.GradeRepository;

@RestController
@RequestMapping("grade")
public class GradeController {

    @Autowired
    private GradeRepository repository;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid CriarGrade dados) {
        repository.save(new Grade(dados));
    }

}
