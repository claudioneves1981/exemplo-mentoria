package br.com.mentoria.adaptadores;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.bd.entidades.CampeaoEntity;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.enuns.TipoCampeao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CampeaoServiceAdapter {

    private Campeao campeao;
    private List<Campeao> campeoes;

   public CampeaoServiceAdapter(CampeaoAPI campeaoAPI){ this.campeao =
        convertCampeaoDTOemCampeao(campeaoAPI);
    }
    public CampeaoServiceAdapter(CampeaoEntity campeaoEntity){this.campeao = convertCampeaoEntityEmCampeao(campeaoEntity);}

    public CampeaoServiceAdapter(List<CampeaoEntity> campeaoEntities){
        campeoes = convertListEntityEmListCampeao(campeaoEntities);
    }

    private List<Campeao> convertListEntityEmListCampeao(List<CampeaoEntity> campeaoEntityList){
        campeoes = new ArrayList<>();
       for(CampeaoEntity campeaoEntity : campeaoEntityList){
           campeoes.add(convertCampeaoEntityEmCampeao(campeaoEntity));
       }
       return campeoes;
    }

    private Campeao convertCampeaoDTOemCampeao(CampeaoAPI campeaoAPI){
        return campeao.builder()
                .id(campeaoAPI.getId())
                .email(campeaoAPI.getEmail())
                .nome(campeaoAPI.getNome())
                .corSabre(campeaoAPI.getCorSabre())
                .tipo(campeaoAPI.isJedi()? TipoCampeao.JEDI:TipoCampeao.SITH)
                .build();
    }

    private Campeao convertCampeaoEntityEmCampeao(CampeaoEntity campeaoEntity){
       return Campeao.builder()
               .id(campeaoEntity.getId())
               .hp(campeaoEntity.getHp())
               .afinidadeForca(campeaoEntity.getAfinidadeForca())
               .previsao(campeaoEntity.getPrevisao())
               .mental(campeaoEntity.getMental())
               .corSabre(campeaoEntity.getCorSabre())
               .nome(campeaoEntity.getNome())
               .forcaFisica(campeaoEntity.getForcaFisca())
               .email(campeaoEntity.getEmail())
               .habilidadeComSabre(campeaoEntity.getHabilidadeComSabre())
               .tipo(TipoCampeao.getTipoCampeao(campeaoEntity.getTipo()!= null?campeaoEntity.getTipo().getId():null))
               .build();
    }
}
