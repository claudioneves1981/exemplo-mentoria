package br.com.mentoria.adaptadores.tipoCampeao;

import br.com.mentoria.apis.entidades.TipoCampeaoAPI;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import lombok.Data;

@Data
public class TipoCampeaoAPIAdapter {

    private TipoCampeaoAPI campeaoAPI;

    public TipoCampeaoAPIAdapter(TipoCampeao tipoCampeao){

        this.campeaoAPI = converteTipoCampeaoEmTipoCampeaoAPI(tipoCampeao);

    }

    private TipoCampeaoAPI converteTipoCampeaoEmTipoCampeaoAPI(TipoCampeao tipoCampeao){
        return TipoCampeaoAPI.builder()
                .descricao(tipoCampeao.getDescricao())
                .nomeTecnico(tipoCampeao.getNomeTecnico())
                .build();
    }
}
