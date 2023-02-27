package com.sachinlakshitha.springbootjpamanytoone.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString(exclude = "orders")
public class CustomerDto {
    private String id;
    private String name;
    private String email;
    private Date createdTime;
    private List<OrdersDto> orders = new ArrayList<>();
}
