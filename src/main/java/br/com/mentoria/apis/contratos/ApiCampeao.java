package br.com.mentoria.apis.contratos;

import br.com.mentoria.apis.entidades.NovoCampeaoDTO;
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

    ResponseEntity<NovoCampeaoDTO> salvarCampeao(NovoCampeaoDTO novoCampeao) throws CampeaoException;
    ResponseEntity<List<Campeao>> listarCampeoes();

}
