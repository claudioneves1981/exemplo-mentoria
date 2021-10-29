package br.com.mentoria.adaptadores.campeao;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoEntidadeAdapter;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

@Data
public class CampeaoEntidadeAdapter {

    private CampeaoEntidade campeaoEntidade;

    public CampeaoEntidadeAdapter(Campeao campeao, RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity) {
        converteCampeaoEmCampeaoEntity(campeao, repositorioTipoCampeaoEntity);
    }

    private void converteCampeaoEmCampeaoEntity(Campeao campeao,
                                                RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity) {
        campeaoEntidade = campeaoEntidade.builder()
                .id(campeao.getId())
                .corSabre(campeao.getCorSabre())
                .email(campeao.getEmail())
                .nome(campeao.getNome())
                .afinidadeForca(campeao.getAfinidadeForca())
                .forcaFisica(campeao.getForcaFisica())
                .hp(campeao.getHp())
                .habilidadeComSabre(campeao.getHabilidadeComSabre())
                .mental(campeao.getMental())
                .previsao(campeao.getPrevisao())
                .tipo(new TipoCampeaoEntidadeAdapter(campeao.getTipo(), repositorioTipoCampeaoEntity)
                        .getTipoCampeaoEntidade()
                )
                .build();
    }
}