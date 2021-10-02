package br.com.mentoria.adaptadores;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.enuns.TipoCampeao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CampeaoAPIAdapter {
    private CampeaoAPI campeaoAPI;
    private List<CampeaoAPI> campeoesAPI;

    public CampeaoAPIAdapter(Campeao campeao){
        campeaoAPI = convertCampeaoParaCampeaoAPI(campeao);
    }

    public CampeaoAPIAdapter(List<Campeao> campeao){
        campeoesAPI = convertListCampeaoParaListCampeaoAPI(campeao);
    }

    private List<CampeaoAPI> convertListCampeaoParaListCampeaoAPI(List<Campeao> campeoes){
        List<CampeaoAPI> campeoesAPI = new ArrayList<>();
        for(Campeao campeao: campeoes){
            campeoesAPI.add(convertCampeaoParaCampeaoAPI(campeao));
        }
        return campeoesAPI;
    }

    private CampeaoAPI convertCampeaoParaCampeaoAPI(Campeao campeao){
        return CampeaoAPI.builder()
                .id(campeao.getId())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .nome(campeao.getNome())
                .jedi(campeao.getTipo().equals(TipoCampeao.JEDI)?true:false)
                .build();
    }



}
