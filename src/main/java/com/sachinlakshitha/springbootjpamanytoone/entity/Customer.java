package com.sachinlakshitha.springbootjpamanytoone.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(exclude = "orders")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private Date createdTime;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> orders;
}
