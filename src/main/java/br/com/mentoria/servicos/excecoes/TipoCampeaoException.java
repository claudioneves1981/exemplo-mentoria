package br.com.mentoria.servicos.excecoes;

public class TipoCampeaoException extends Exception{
    private String msg;

    public TipoCampeaoException(String msg){
        super(msg);
        this.msg = msg;
    }
}
