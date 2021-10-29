package br.com.mentoria.servicos.contratos;

import br.com.mentoria.servicos.entidades.TipoCampeao;
import br.com.mentoria.servicos.excecoes.TipoCampeaoException;
import org.springframework.stereotype.Service;

@Service
public interface TipoCampeaoService {
    public TipoCampeao buscaTipoCampeaoPorNomeTecnico(String nomeTecnico) throws TipoCampeaoException;
}