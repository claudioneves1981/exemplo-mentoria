package br.com.mentoria.apis.contratos.impl;

import br.com.mentoria.adaptadores.CampeaoAPIAdapter;
import br.com.mentoria.adaptadores.CampeaoServiceAdapter;
import br.com.mentoria.apis.contratos.ApiCampeao;
import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.excecoes.CampeaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/campeao")
@CrossOrigin(origins = "http://localhost:8080")
public class ApiCampeaoImpl implements ApiCampeao {

    private CampeaoServico campeaoServico;

    @Autowired
    public ApiCampeaoImpl(CampeaoServico campeaoServico){
        this.campeaoServico = campeaoServico;
    }

    @PostMapping(value="/salvar")
    @Override
    public ResponseEntity<CampeaoAPI> salvarCampeao(@RequestBody CampeaoAPI novoCampeao) throws CampeaoException {
        CampeaoServiceAdapter adapter = new CampeaoServiceAdapter(novoCampeao);
        campeaoServico.salvarCampeao(adapter.getCampeao());
        return ResponseEntity.ok(novoCampeao);
    }

    @GetMapping(value="/listar")
    @Override
    public ResponseEntity<List<CampeaoAPI>> listarCampeoes() throws CampeaoException {
        return ResponseEntity.ok(new CampeaoAPIAdapter(campeaoServico.listarTodos()).getCampeoesAPI());
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<CampeaoAPI> campeaoPorId(@PathVariable Long id) throws CampeaoException{
        return ResponseEntity.ok(new CampeaoAPIAdapter(campeaoServico.buscaPorId(id)).getCampeaoAPI());
    }
}
