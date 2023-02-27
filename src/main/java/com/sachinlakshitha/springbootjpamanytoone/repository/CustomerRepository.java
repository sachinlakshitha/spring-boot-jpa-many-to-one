package com.sachinlakshitha.springbootjpamanytoone.repository;

import com.sachinlakshitha.springbootjpamanytoone.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
