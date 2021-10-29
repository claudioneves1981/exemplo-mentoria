package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.tipoCampeao.TipoCampeaoAdapter;
import br.com.mentoria.bd.contratos.RepositorioTipoCampeaoEntity;
import br.com.mentoria.servicos.contratos.TipoCampeaoService;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import br.com.mentoria.servicos.excecoes.TipoCampeaoException;

public class TipoCampeaoServicoImpl implements TipoCampeaoService {

    private RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity;

    private static TipoCampeaoService instance;

    private TipoCampeaoServicoImpl(RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        this.repositorioTipoCampeaoEntity = repositorioTipoCampeaoEntity;
    }

    public static TipoCampeaoService getInstance(RepositorioTipoCampeaoEntity repositorioTipoCampeaoEntity){
        if(instance == null){
            instance = new TipoCampeaoServicoImpl(repositorioTipoCampeaoEntity);
        }
        return instance;
    }


    @Override
    public TipoCampeao buscaTipoCampeaoPorNomeTecnico(String nomeTecnico) throws TipoCampeaoException {
        TipoCampeao tipoCampeao = new TipoCampeaoAdapter(
                repositorioTipoCampeaoEntity.findByNomeTecnico(nomeTecnico)
        ).getTipoCampeao();
        if(tipoCampeao == null
                || tipoCampeao.getNomeTecnico() == null){
            throw new TipoCampeaoException("Tipo de campeão não encontrado");
        }
        return tipoCampeao;
    }
}