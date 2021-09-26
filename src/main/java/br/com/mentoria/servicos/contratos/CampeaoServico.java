package br.com.mentoria.servicos.contratos;

import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.excecoes.CampeaoException;

import java.util.List;

public interface CampeaoServico {
    
    Campeao salvarCampeao(Campeao campeao) throws CampeaoException;
    List<Campeao> findAll();
}
