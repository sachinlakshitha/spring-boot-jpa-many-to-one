package com.sachinlakshitha.springbootjpamanytoone.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrdersDto {
    private String id;
    private String number;
    private Double amount;
    private Date createdTime;
    private CustomerDto customer;
}
