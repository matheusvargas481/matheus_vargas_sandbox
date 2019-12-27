package com.matheusvargas481.spring_bootpostgresqldocker.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {
    private Long id;
    private String name;
    private String cpf;
}
