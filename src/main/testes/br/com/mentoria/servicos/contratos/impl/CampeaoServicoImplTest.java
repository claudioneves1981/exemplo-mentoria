package br.com.mentoria.servicos.contratos.impl;

import br.com.mentoria.bd.contratos.RepositorioCampeaoEntity;
import br.com.mentoria.bd.entidades.CampeaoEntidade;
import br.com.mentoria.servicos.entidades.Campeao;
import br.com.mentoria.servicos.entidades.TipoCampeao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class CampeaoServicoImplTest {
   @Mock
    RepositorioCampeaoEntity campeaoRepositorio;
    @InjectMocks
    CampeaoServicoImpl campeaoServicoImpl;

   @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

   @Test
    public void testSalvarCampeao() throws Exception {
        boolean result = campeaoServicoImpl.salvarCampeao(new Campeao(1L, "nome", "email", "corSabre", new TipoCampeao(1L,"nomeTecnico", "descricao"), 1L, 1L, 1L, 1L, 1L, 1L));
       Assert.assertTrue(result);
    }

   @Test
    public void testListarTodos() {
        List<Campeao> result = campeaoServicoImpl.listarTodos();
        Assert.assertEquals(Collections.singletonList(new Campeao(1L, "nome", "email", "corSabre", new TipoCampeao(1L, "nomeTecnico", "descricao"), 1L, 1L, 1L, 1L, 1L, 1L)), result);
    }

   @Test
    public void testBuscaPorId() {
        Campeao result = campeaoServicoImpl.buscaPorId(1L);
        Assert.assertEquals(new Campeao(1L, "nome", "email", "corSabre", new TipoCampeao(1L,"nomeTecnico", "descricao"), 1L, 1L, 1L, 1L, 1L, 1L), result);
    }

   @Test
    public void testEncontraCampeao() {
        when(campeaoRepositorio.findByEmail(anyString())).thenReturn(new CampeaoEntidade(1L, "nome", "email", "corSabre", 1L, 1L, 1L, 1L, 1L, 1L, null));
        Campeao result = campeaoServicoImpl.encontraCampeao("email");
        Assert.assertEquals(new Campeao(1L, "nome", "email", "corSabre", new TipoCampeao(1L,"nomeTecnico", "descricao"), 1L, 1L, 1L, 1L, 1L, 1L), result);
    }

    @Test
    public void testEncontraCampeaoSucesso() {
        when(campeaoRepositorio.findByEmail(anyString()))
                .thenReturn(CampeaoEntidade.builder().build());
        Assert.assertNotNull(campeaoServicoImpl.encontraCampeao("string@strng.com.br"));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme