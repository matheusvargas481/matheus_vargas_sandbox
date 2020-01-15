package com.pc.pockafkaconsumidor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Optante {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
//    private Long id;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "conta")
    private String conta;
    @Column(name = "contrato")
    private String contrato;
    @Column(name = "optante")
    private Boolean optante;
    @Column(name = "data_vigencia")
    private LocalDateTime dataVigencia;
    @Column(name = "origem")
    private Integer origem;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Boolean getOptante() {
        return optante;
    }

    public void setOptante(Boolean optante) {
        this.optante = optante;
    }

    public LocalDateTime getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(LocalDateTime dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
        return "Optante{" +
                "cpf='" + cpf + '\'' +
                ", conta='" + conta + '\'' +
                ", contrato='" + contrato + '\'' +
                ", optante=" + optante +
                ", dataVigencia=" + dataVigencia +
                ", origem=" + origem +
                '}';
    }
}
