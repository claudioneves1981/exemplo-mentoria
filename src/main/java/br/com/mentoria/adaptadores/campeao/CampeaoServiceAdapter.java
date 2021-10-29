package br.com.mentoria.adaptadores.campeao;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoAdapter;
import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CampeaoServiceAdapter {

    private Campeao campeao;
    private List<Campeao> campeoes;

   public CampeaoServiceAdapter(CampeaoAPI campeaoAPI){
       this.campeao = convertCampeaoDTOemCampeao(campeaoAPI);
    }
    public CampeaoServiceAdapter(CampeaoEntidade campeaoEntidade){
       setCampeao(convertCampeaoEntityEmCampeao(campeaoEntidade));
   }

    public CampeaoServiceAdapter(List<CampeaoEntidade> campeaoEntities){
        setCampeoes(convertListEntityEmListCampeao(campeaoEntities));
    }

    private List<Campeao> convertListEntityEmListCampeao(List<CampeaoEntidade> campeaoEntidadeList){
        campeoes = new ArrayList<>();
       for(CampeaoEntidade campeaoEntidade : campeaoEntidadeList){
           campeoes.add(convertCampeaoEntityEmCampeao(campeaoEntidade));
       }
       return campeoes;
    }

    private Campeao convertCampeaoDTOemCampeao(CampeaoAPI campeaoAPI){
        return campeao.builder()
                .id(campeaoAPI.getId())
                .email(campeaoAPI.getEmail())
                .nome(campeaoAPI.getNome())
                .corSabre(campeaoAPI.getCorSabre())
                .tipo(new TipoCampeaoAdapter(campeaoAPI.getTipoCampeao()).getTipoCampeao())
                .build();
    }

    private Campeao convertCampeaoEntityEmCampeao(CampeaoEntidade campeaoEntidade){
       return Campeao.builder()
               .id(campeaoEntidade.getId())
               .hp(campeaoEntidade.getHp())
               .afinidadeForca(campeaoEntidade.getAfinidadeForca())
               .previsao(campeaoEntidade.getPrevisao())
               .mental(campeaoEntidade.getMental())
               .corSabre(campeaoEntidade.getCorSabre())
               .nome(campeaoEntidade.getNome())
               .forcaFisica(campeaoEntidade.getForcaFisica())
               .email(campeaoEntidade.getEmail())
               .habilidadeComSabre(campeaoEntidade.getHabilidadeComSabre())
               .tipo(new TipoCampeaoAdapter(campeaoEntidade.getTipo()).getTipoCampeao())
               .build();


    }
}
