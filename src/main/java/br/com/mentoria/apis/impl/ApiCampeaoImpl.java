package br.com.mentoria.apis.impl;

import br.com.mentoria.apis.ApiCampeao;
import br.com.mentoria.entidades.Campeao;
import br.com.mentoria.excecoes.CampeaoException;
import br.com.mentoria.servicos.CampeaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/campeao")
public class ApiCampeaoImpl implements ApiCampeao {

    private CampeaoServico campeaoServico;

    @Autowired
    public ApiCampeaoImpl(CampeaoServico campeaoServico){
        this.campeaoServico = campeaoServico;
    }

    @PostMapping(value="/salvar")
    @Override
    public ResponseEntity<Campeao> salvarCampeao(@RequestBody Campeao novoCampeao) throws CampeaoException {
        campeaoServico.salvarCampeao(novoCampeao);
        return ResponseEntity.ok(novoCampeao);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Campeao>>listarCampeoes() {
        List<Campeao> campeoes = campeaoServico.findAll();
        return ResponseEntity.ok(campeoes);
    }


}
