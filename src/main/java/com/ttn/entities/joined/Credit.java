package com.ttn.entities.joined;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Credit extends Payment{

    private String creditNumber;
}
