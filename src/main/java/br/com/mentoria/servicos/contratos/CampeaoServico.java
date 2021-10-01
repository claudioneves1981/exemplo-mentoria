package br.com.mentoria.servicos.contratos;

import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.excecoes.CampeaoException;

import java.util.List;

public interface CampeaoServico {
    
    boolean salvarCampeao(Campeao campeao) throws CampeaoException;
    List<Campeao> listarTodos();
}
