package com.gabriel.aviaoempresa.controller;

import com.gabriel.aviaoempresa.dto.EmpresaDTO;
import com.gabriel.aviaoempresa.model.Empresa;
import com.gabriel.aviaoempresa.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@Tag(name = "Empresa", description = "Endpoints para gerenciamento de empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Listar todas as empresas")
    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }

    @Operation(summary = "Buscar empresa por ID")
    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id) {
        return empresaService.buscarPorId(id).orElseThrow();
    }

    @Operation(summary = "Cadastrar uma nova empresa")
    @PostMapping
    public Empresa salvar(@RequestBody EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());
        return empresaService.salvar(empresa);
    }

    @Operation(summary = "Excluir uma empresa por ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresaService.deletar(id);
    }
}
