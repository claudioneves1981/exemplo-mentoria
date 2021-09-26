package br.com.mentoria.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Campeao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;
    private String corSabre;
    private String tipo;
    private Long hp;
    private Long forcaFisica;
    private Long mental;
    private Long previsao;
    private Long habilidadeComSabre;
    private Long afinidadeForca;

}
