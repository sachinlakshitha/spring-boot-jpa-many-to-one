package com.sachinlakshitha.springbootjpamanytoone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Orders {
    @Id
    private String id;
    private String number;
    private Double amount;
    private Date createdTime;
    @ManyToOne
    private Customer customer;
}
