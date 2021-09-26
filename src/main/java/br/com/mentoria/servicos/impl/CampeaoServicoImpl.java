package br.com.mentoria.servicos.impl;

import br.com.mentoria.repositorio.CampeaoRepositorio;
import br.com.mentoria.servicos.CampeaoServico;
import br.com.mentoria.entidades.Campeao;
import br.com.mentoria.excecoes.CampeaoException;
import br.com.mentoria.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampeaoServicoImpl implements CampeaoServico {

    private CampeaoRepositorio campeaoRepositorio;

    @Autowired
    public CampeaoServicoImpl(CampeaoRepositorio campeaoRepositorio){
        this.campeaoRepositorio = campeaoRepositorio;
    }

    @Override
    public Campeao salvarCampeao(Campeao campeao) throws CampeaoException {
            validaCampeao(campeao);
            if (campeao.getTipo().equals("jedi")) {
                campeao = criarJedi(campeao);
            } else {
                campeao = criarSith(campeao);
            }

       //return campeao.getHp() != null;
        return campeaoRepositorio.save(campeao);
    }

    @Override
    public List<Campeao> findAll() {
        return campeaoRepositorio.findAll();
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
