package com.pc.pockafkaconsumidor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Input {
    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("conta")
    private String conta;

    @JsonProperty("contrato")
    private String contrato;

    @JsonProperty("optante")
    private Boolean optante;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("dataVigencia")
    private LocalDateTime dataVigencia;

    @JsonProperty("origem")
    private Integer origem;

    public Input() {
    }

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
        return "Input{" +
                "cpf='" + cpf + '\'' +
                ", conta='" + conta + '\'' +
                ", contrato='" + contrato + '\'' +
                ", optante=" + optante +
                ", dataVigencia=" + dataVigencia +
                ", origem=" + origem +
                '}';
    }
}
