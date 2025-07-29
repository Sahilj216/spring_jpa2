package com.ttn.entities.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cheque extends Payment{

    private String cheqNumber;
}
