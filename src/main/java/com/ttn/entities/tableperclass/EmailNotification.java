package com.ttn.entities.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmailNotification extends Notification {

    private String email;
}
