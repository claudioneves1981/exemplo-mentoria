package br.com.mentoria.servicos;

import br.com.mentoria.entidades.Campeao;
import br.com.mentoria.excecoes.CampeaoException;

import java.util.List;

public interface CampeaoServico {
    
    Campeao salvarCampeao(Campeao campeao) throws CampeaoException;
    List<Campeao> findAll();
}
