package br.com.mentoria.apis.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampeaoAPI {

    private Long id;
    private String nome;
    private String email;
    private String corSabre;
    private Long hp;
    private Long afinidadeForca;
    private Long habilidadeComSabre;
    private Long previsao;
    private Long mental;
    private Long forcaFisica;
    private TipoCampeaoAPI tipoCampeao;
    private String erro;
}
