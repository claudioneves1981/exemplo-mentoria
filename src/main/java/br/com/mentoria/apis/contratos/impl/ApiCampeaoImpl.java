package br.com.mentoria.apis.contratos.impl;

import br.com.mentoria.adaptadores.campeao.CampeaoAPIAdapter;
import br.com.mentoria.adaptadores.campeao.CampeaoServiceAdapter;
import br.com.mentoria.apis.contratos.ApiCampeao;
import br.com.mentoria.apis.entidades.CampeaoAPI;
import br.com.mentoria.fabricas.contratos.FabricaInstancias;
import br.com.mentoria.servicos.contratos.CampeaoServico;
import br.com.mentoria.servicos.excecoes.CampeaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/campeoes")
@CrossOrigin(origins = "http://localhost:8080")
public class ApiCampeaoImpl implements ApiCampeao {

    private CampeaoServico campeaoServico;

    @Autowired
    public ApiCampeaoImpl(FabricaInstancias fabricaInstancias){
        this.campeaoServico = fabricaInstancias.getCampeaoServicoImple();
    }

    @PostMapping(value="/salvar")
    @Override
    public ResponseEntity<CampeaoAPI> salvarCampeao(@RequestBody CampeaoAPI campeaoAPI) throws CampeaoException {
        CampeaoServiceAdapter adapter = new CampeaoServiceAdapter(campeaoAPI);
        try {
            campeaoServico.salvarCampeao(adapter.getCampeao());
        }catch(CampeaoException exception){
            return ResponseEntity.status(406).body(CampeaoAPI.builder()
            .erro(exception.getMessage())
            .build());
        }
        return ResponseEntity.ok(campeaoAPI);
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

    @PutMapping(value="/atualizar")
    @Override
    public ResponseEntity<?> atualizarCampeao(@RequestBody CampeaoAPI novoCampeao) throws CampeaoException {
        if(novoCampeao.getId() == null){
            return ResponseEntity.ok("Campeao invalido ou não disponivel para atualização");
        }
        CampeaoServiceAdapter adapter = new CampeaoServiceAdapter(novoCampeao);
        campeaoServico.salvarCampeao(adapter.getCampeao());
        return ResponseEntity.ok(novoCampeao);
    }

    @GetMapping(value = "/encontrar/{email}")
    @Override
    public ResponseEntity<CampeaoAPI> retornaCampeao(@PathVariable String email) throws CampeaoException {
        CampeaoAPI campeaoRetornado =
                new CampeaoAPIAdapter(campeaoServico.encontraCampeao(email)).getCampeaoAPI();
        return ResponseEntity.ok(campeaoRetornado);
    }
}
