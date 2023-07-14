package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    public List<Transferencia> getAllTranferencias() {
        List<Transferencia> transferencias = repository.findAll();
        return transferencias;
    }

    public Optional<List<Transferencia>> getTransferenciaByContaId(Integer contaId) {

        Optional<List<Transferencia>> transferencias = repository.findAllByContaId(contaId);

        if (transferencias.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return transferencias;
    }

}
