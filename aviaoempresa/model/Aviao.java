package com.gabriel.aviaoempresa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aviao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private int capacidade;

    private String prefixo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
