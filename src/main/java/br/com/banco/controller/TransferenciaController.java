package br.com.banco.controller;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
@RequestMapping("/transferencias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @GetMapping
    public ResponseEntity<List<Transferencia>> getTransferenciasByInicioFimOperador(
            @RequestParam(value = "dataInicio", required = false) String dataInicio,
            @RequestParam(value = "dataFim", required = false) String dataFim,
            @RequestParam(value = "nomeOperador", required = false) String nomeOperador) {

        List<Transferencia> transferenciasByInicioFimOperador = service.getTransferenciasByInicioFimOperador(dataInicio, dataFim, nomeOperador);

        return ResponseEntity.status(HttpStatus.OK).body(transferenciasByInicioFimOperador);
    }
}