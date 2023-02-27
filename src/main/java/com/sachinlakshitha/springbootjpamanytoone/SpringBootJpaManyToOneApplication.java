package com.sachinlakshitha.springbootjpamanytoone;

import com.sachinlakshitha.springbootjpamanytoone.dto.CustomerDto;
import com.sachinlakshitha.springbootjpamanytoone.dto.OrdersDto;
import com.sachinlakshitha.springbootjpamanytoone.service.CustomerService;
import com.sachinlakshitha.springbootjpamanytoone.service.OrdersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class SpringBootJpaManyToOneApplication implements CommandLineRunner {
	private CustomerService customerService;
	private OrdersService ordersService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("[SAVE]");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(UUID.randomUUID().toString());
		customerDto.setName("Sachin Lakshitha");
		customerDto.setEmail("sachin@email.com");
		customerDto.setCreatedTime(new Date());

		Boolean isCustomerSaved = customerService.save(customerDto);

		if (isCustomerSaved) {
			log.info("Customer [{}] saved successfully", customerDto.getName());
		} else {
			log.info("Customer [{}] saving failed", customerDto.getName());
		}

		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setId(UUID.randomUUID().toString());
		ordersDto.setNumber("ORD-001");
		ordersDto.setAmount(100.00);
		ordersDto.setCreatedTime(new Date());
		ordersDto.setCustomer(customerDto);

		Boolean isOrderSaved = ordersService.save(ordersDto);

		if (isOrderSaved) {
			log.info("Order [{}] saved successfully", ordersDto.getNumber());
		} else {
			log.info("Order [{}] saving failed", ordersDto.getNumber());
		}

		log.info("[FIND_BY_ID] {}", ordersService.findById(ordersDto.getId()));

		log.info("[FIND_ALL] {}", ordersService.findAll());

		// Pagination example with page size 10
		log.info("[FIND_ALL_BY_PAGINATION] {}", ordersService.findAllByPage(PageRequest.of(0,10)));

		// Sort by order number in ascending order
		log.info("[FIND_ALL_BY_SORT] {}", ordersService.findAllBySort(Sort.by(Sort.Direction.fromString("ASC"), "number")));

		// Sort by order number in descending order and pagination with page size 10
		log.info("[FIND_ALL_BY_SORT_AND_PAGINATION] {}", ordersService.findAllBySortAndPage(PageRequest.of(0,10, Sort.by(Sort.Direction.fromString("DESC"), "number"))));

		log.info("[UPDATE]");
		ordersDto.setAmount(200.00);
		Boolean isOrderUpdated = ordersService.update(ordersDto);

		if (isOrderUpdated) {
			log.info("Order [{}] updated successfully", ordersDto.getNumber());
		} else {
			log.info("Order [{}] updating failed", ordersDto.getNumber());
		}

		log.info("[FIND_BY_ID] {}", ordersService.findById(ordersDto.getId()));

		log.info("[DELETE]");
		ordersService.delete(ordersDto.getId());
		log.info("Order [{}] deleted successfully", ordersDto.getNumber());

		log.info("[FIND_ALL] {}", ordersService.findAll());
	}
}
