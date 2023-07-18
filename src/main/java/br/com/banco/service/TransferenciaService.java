package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    private final EntityManager entityManager;

    public TransferenciaService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Transferencia> getTransferenciasByInicioFimOperador(String dataInicio, String dataFim, String nomeOperador) {

        List<Transferencia> resultados = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transferencia> cq = cb.createQuery(Transferencia.class);
        Root<Transferencia> root = cq.from(Transferencia.class);
        List<Predicate> predicates = new ArrayList<>();

        if (dataInicio != null && !dataInicio.equals("")) {
            String dataInicioClean = dataInicio.substring(0, 10);
            predicates.add(cb.greaterThanOrEqualTo(root.get("dataTransferencia").as(Date.class), Date.valueOf(dataInicioClean)));
        }
        if (dataFim != null && !dataFim.equals("")) {
            String dataFimClean = dataFim.substring(0, 10);
            predicates.add(cb.lessThanOrEqualTo(root.get("dataTransferencia").as(Date.class), Date.valueOf(dataFimClean)));
        }
        if (nomeOperador != null && !nomeOperador.isEmpty()) {
            predicates.add(cb.equal(root.get("nomeOperadorTransacao"), nomeOperador));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        resultados = entityManager.createQuery(cq).getResultList();

        return resultados;
    }

}