package com.ttn.entities.embeds;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Compensation {
    private float basicSalary;
    private float bonusSalary;
    private float specialAllowanceSalary;
}
