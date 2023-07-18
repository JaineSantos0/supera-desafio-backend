package br.com.banco.client;

import br.com.banco.model.Transferencia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "transferenciaClient", url = "http://localhost:8080")
public interface TransferenciaClient {

    @GetMapping("/transferencias")
    public ResponseEntity<List<Transferencia>> getTransferenciasByInicioFimOperador(
            @RequestParam("dataInicio") String dataInicio,
            @RequestParam("dataFim") String dataFim,
            @RequestParam("nomeOperador") String nomeOperador
    );
}