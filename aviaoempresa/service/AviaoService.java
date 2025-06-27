package com.gabriel.aviaoempresa.service;

import com.gabriel.aviaoempresa.model.Aviao;
import com.gabriel.aviaoempresa.repository.AviaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AviaoService {

    @Autowired
    private AviaoRepository aviaoRepository;

    public List<Aviao> listarTodos() {
        return aviaoRepository.findAll();
    }

    public Optional<Aviao> buscarPorId(Long id) {
        return aviaoRepository.findById(id);
    }

    public Aviao salvar(Aviao aviao) {
        return aviaoRepository.save(aviao);
    }

    public void deletar(Long id) {
        aviaoRepository.deleteById(id);
    }
}
