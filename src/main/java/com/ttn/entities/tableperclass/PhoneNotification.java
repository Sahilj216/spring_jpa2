package com.ttn.entities.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PhoneNotification extends  Notification {

    private String phoneNumber;
}
