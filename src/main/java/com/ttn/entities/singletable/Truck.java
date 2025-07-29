package com.ttn.entities.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("TRUCK")
public class Truck extends Vehicle{

    private int loadingCapacity;
}
