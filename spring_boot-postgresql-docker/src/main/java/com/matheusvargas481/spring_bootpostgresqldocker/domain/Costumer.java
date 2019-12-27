package com.matheusvargas481.spring_bootpostgresqldocker.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Costumer {
    private Long id;
    private String name;
    private String cpf;
}
