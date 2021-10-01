package br.com.mentoria.apis.contratos;

import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.excecoes.CampeaoException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApiCampeao {

    @ApiOperation(value="Salva um valor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma mensagem se salvou o valor"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    ResponseEntity<CampeaoAPI> salvarCampeao(CampeaoAPI novoCampeao) throws CampeaoException;

    @ApiOperation(value="Lista todos os campeoes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os campeoes"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    ResponseEntity<List<CampeaoAPI>> listarCampeoes() throws CampeaoException;

    @ApiOperation(value="Mostra um Campeao pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna id de campeao"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    ResponseEntity<CampeaoAPI> campeaoPorId (Long id) throws CampeaoException;

}
