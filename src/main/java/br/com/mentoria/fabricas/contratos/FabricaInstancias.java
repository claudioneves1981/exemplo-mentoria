package br.com.mentoria.fabricas.contratos;

import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.contratos.TipoCampeaoService;
import br.com.mentoria.servicos.entidades.TipoCampeao;

public interface FabricaInstancias {

    public CampeaoServico getCampeaoServicoImple();

    public TipoCampeaoService getTipoCampeaoImple();
}
