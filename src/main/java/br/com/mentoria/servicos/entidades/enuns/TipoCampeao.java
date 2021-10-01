package br.com.mentoria.servicos.entidades.enuns;

public enum TipoCampeao {
    JEDI,SITH;

    public static TipoCampeao getTipoCampeao(Long cod){
        if (cod != null && cod == 1L){
            return TipoCampeao.JEDI;
        }
        return TipoCampeao.SITH;
    }
}
