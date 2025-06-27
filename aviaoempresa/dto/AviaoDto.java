package com.gabriel.aviaoempresa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AviaoDTO {

    private Long id;
    private String modelo;
    private int capacidade;
    private String prefixo;
    private Long empresaId; // Só ID da empresa associada
}
