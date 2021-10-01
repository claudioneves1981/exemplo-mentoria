package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.adaptadores.CampeaoRepositorioAdapter;
import br.com.mentoria.adaptadores.CampeaoServiceAdapter;
import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.excecoes.CampeaoException;
import br.com.mentoria.servicos.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampeaoServicoImpl implements CampeaoServico {

    private RepositorioCampeaoEntity campeaoRepositorio;

    @Autowired
    public CampeaoServicoImpl(RepositorioCampeaoEntity campeaoRepositorio){
        this.campeaoRepositorio = campeaoRepositorio;
    }

    @Override
    public boolean salvarCampeao(Campeao campeao) throws CampeaoException {
            validaCampeao(campeao);
            if (campeao.getTipo().equals("jedi")) {
                campeao = criarJedi(campeao);
            } else {
                campeao = criarSith(campeao);
            }

            campeaoRepositorio.save(new CampeaoRepositorioAdapter(campeao).getCampeaoEntity());

       return campeao.getHp() != null;
    }

    @Override
    public List<Campeao> listarTodos() {
        return new CampeaoServiceAdapter(campeaoRepositorio.findAll()).getCampeoes();
    }

    @Override
    public Campeao buscaPorId(Long id) {
        return new CampeaoServiceAdapter(campeaoRepositorio.findById(id).get()).getCampeao();
    }

    private Campeao criarJedi(Campeao campeao){
        System.out.print("Criou um JEDI");
        return Campeao.builder()
                .id(campeao.getId())
                .nome(campeao.getNome())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .tipo(campeao.getTipo())
                .afinidadeForca(5L)
                .forcaFisica(5L)
                .hp(150L)
                .habilidadeComSabre(5L)
                .mental(10L)
                .previsao(5L)
                .build();
    }

    private Campeao criarSith(Campeao campeao){
        System.out.print("Criou um SITH");
        return Campeao.builder()
                .id(campeao.getId())
                .nome(campeao.getNome())
                .email(campeao.getEmail())
                .corSabre(campeao.getCorSabre())
                .tipo(campeao.getTipo())
                .afinidadeForca(5L)
                .forcaFisica(10L)
                .hp(150L)
                .habilidadeComSabre(5L)
                .mental(5L)
                .previsao(5L)
                .build();
    }

    private void validaCampeao(Campeao campeao) throws CampeaoException {
        if(!EmailUtil.verificaEmailValido(campeao.getEmail())){
            throw new CampeaoException("O Email digitado é invalido");
        }

        if(campeao.getNome() == null
            || campeao.getNome().isEmpty()){
            throw new CampeaoException("O nome é invalido");
        }

        if(campeao.getCorSabre() == null
                || campeao.getCorSabre().isEmpty()){
            throw new CampeaoException("A cor do sabre é invalida");
        }
    }

}
