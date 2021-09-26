package br.com.mentoria.apis.contratos.impl;

import br.com.mentoria.adaptadores.CampeaoServiceAdapter;
import br.com.mentoria.apis.contratos.ApiCampeao;
import br.com.mentoria.apis.entidades.NovoCampeaoDTO;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.excecoes.CampeaoException;
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
    public ResponseEntity<NovoCampeaoDTO> salvarCampeao(@RequestBody NovoCampeaoDTO novoCampeao) throws CampeaoException {
        CampeaoServiceAdapter adapter = new CampeaoServiceAdapter(novoCampeao);
        campeaoServico.salvarCampeao(adapter.getCampeao());
        return ResponseEntity.ok(novoCampeao);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Campeao>>listarCampeoes() {
        List<Campeao> campeoes = campeaoServico.findAll();
        return ResponseEntity.ok(campeoes);
    }


}
