package br.com.banco.funcional;

import br.com.banco.client.TransferenciaClient;
import br.com.banco.model.Transferencia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestesFuncionais {

    @Autowired
    private TransferenciaClient transferenciaClient;

    @Test
    public void deveRetornarUmRegistro() {

        //cenario
        String dataInicio = "";
        String dataFim = "";
        String nomeOperador = "Beltrano";

        //acao
        ResponseEntity<List<Transferencia>> resposta = transferenciaClient.getTransferenciasByInicioFimOperador(dataInicio, dataFim, nomeOperador);

        //verificacao
        assertThat(resposta.getStatusCodeValue(), is(200));
        assertThat(resposta.getBody(), is(notNullValue()));
        assertThat(resposta.getBody().size(), is(1));
        assertThat(resposta.getBody().get(0).getNomeOperadorTransacao(), is(nomeOperador));
    }
}