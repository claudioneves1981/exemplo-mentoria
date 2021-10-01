package br.com.mentoria.servicos.entidades;

import br.com.mentoria.servicos.entidades.enuns.TipoCampeao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Campeao {

    private Long id;
    private String nome;
    private String email;
    private String corSabre;
    private TipoCampeao tipo;
    private Long hp;
    private Long forcaFisica;
    private Long mental;
    private Long previsao;
    private Long habilidadeComSabre;
    private Long afinidadeForca;

}
