package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @Column(name = "data_transferencia")
    @NotNull
    private OffsetDateTime dataTranferencia;

    @NotNull
    @Column(name = "valor", columnDefinition = "NUMERIC(20,2)")
    private BigDecimal valor;

    @NotNull
    @Size(max = 15)
    private String tipo;

    @Column(name = "nome_operador_transacao")
    @Size(max = 50)
    private String nomeOperadorTransacao;

    @ManyToOne
    @JsonIgnoreProperties("transferencia")
    private Conta contaId;

    public Transferencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getDataTranferencia() {
        return dataTranferencia;
    }

    public void setDataTranferencia(OffsetDateTime dataTranferencia) {
        this.dataTranferencia = dataTranferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public Conta getContaId() {
        return contaId;
    }

    public void setContaId(Conta contaId) {
        this.contaId = contaId;
    }
}