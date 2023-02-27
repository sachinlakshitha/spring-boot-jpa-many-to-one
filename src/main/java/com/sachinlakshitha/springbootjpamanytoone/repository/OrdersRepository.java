package com.sachinlakshitha.springbootjpamanytoone.repository;

import com.sachinlakshitha.springbootjpamanytoone.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, String> {
}
