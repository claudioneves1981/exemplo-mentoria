package br.com.mentoria.servicos.excecoes;

public class CampeaoException extends Exception{
    private String msg;

    public CampeaoException(String msg){
        super(msg);
        this.msg = msg;
    }
}
