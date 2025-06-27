package com.gabriel.aviaoempresa.controller;

import com.gabriel.aviaoempresa.dto.AviaoDTO;
import com.gabriel.aviaoempresa.model.Aviao;
import com.gabriel.aviaoempresa.model.Empresa;
import com.gabriel.aviaoempresa.service.AviaoService;
import com.gabriel.aviaoempresa.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avioes")
@Tag(name = "Avião", description = "Endpoints para gerenciamento de aviões")
public class AviaoController {

    @Autowired
    private AviaoService aviaoService;

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Listar todos os aviões")
    @GetMapping
    public List<Aviao> listarTodos() {
        return aviaoService.listarTodos();
    }

    @Operation(summary = "Buscar avião por ID")
    @GetMapping("/{id}")
    public Aviao buscarPorId(@PathVariable Long id) {
        return aviaoService.buscarPorId(id).orElseThrow();
    }

    @Operation(summary = "Cadastrar um novo avião")
    @PostMapping
    public Aviao salvar(@RequestBody AviaoDTO dto) {
        Empresa empresa = empresaService.buscarPorId(dto.getEmpresaId()).orElseThrow();

        Aviao aviao = new Aviao();
        aviao.setModelo(dto.getModelo());
        aviao.setCapacidade(dto.getCapacidade());
        aviao.setPrefixo(dto.getPrefixo());
        aviao.setEmpresa(empresa);

        return aviaoService.salvar(aviao);
    }

    @Operation(summary = "Excluir um avião por ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        aviaoService.deletar(id);
    }
}
