package com.sachinlakshitha.springbootjpamanytoone.service.impl;

import com.sachinlakshitha.springbootjpamanytoone.dto.OrdersDto;
import com.sachinlakshitha.springbootjpamanytoone.entity.Orders;
import com.sachinlakshitha.springbootjpamanytoone.repository.OrdersRepository;
import com.sachinlakshitha.springbootjpamanytoone.service.OrdersService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private OrdersRepository ordersRepository;
    private ModelMapper modelMapper;

    @Override
    public Boolean save(OrdersDto ordersDto) {
        return ordersRepository.save(convertToEntity(ordersDto)) != null;
    }

    @Override
    public List<OrdersDto> findAll() {
        return ordersRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public List<OrdersDto> findAllByPage(Pageable page) {
        return ordersRepository.findAll(page).stream().map(this::convertToDto).toList();
    }

    @Override
    public List<OrdersDto> findAllBySort(Sort sort) {
        return ordersRepository.findAll(sort).stream().map(this::convertToDto).toList();
    }

    @Override
    public List<OrdersDto> findAllBySortAndPage(Pageable page) {
        return ordersRepository.findAll(page).stream().map(this::convertToDto).toList();
    }

    @Override
    public OrdersDto findById(String id) {
        return ordersRepository.findById(id).map(this::convertToDto).orElse(null);
    }

    @Override
    public Boolean update(OrdersDto ordersDto) {
        return ordersRepository.save(convertToEntity(ordersDto)) != null;
    }

    @Override
    public void delete(String id) {
        ordersRepository.deleteById(id);
    }

    public OrdersDto convertToDto(Orders orders) {
        return modelMapper.map(orders, OrdersDto.class);
    }

    public Orders convertToEntity(OrdersDto ordersDto) {
        return modelMapper.map(ordersDto, Orders.class);
    }
}
