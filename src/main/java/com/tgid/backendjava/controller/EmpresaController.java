package com.tgid.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgid.backendjava.model.Empresa;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final Empresa minhaEmpresa;

    @Autowired
    public EmpresaController(Empresa minhaEmpresa) {
        this.minhaEmpresa = minhaEmpresa;
    }

    @GetMapping
    public Empresa getEmpresa() {
        return minhaEmpresa;
    }
}