package br.com.mentoria.apis;

import br.com.mentoria.entidades.Campeao;
import br.com.mentoria.excecoes.CampeaoException;
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

    ResponseEntity<Campeao> salvarCampeao(Campeao novoCampeao) throws CampeaoException;
    ResponseEntity<List<Campeao>> listarCampeoes();

}
