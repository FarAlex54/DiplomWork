package com.example.diplomwork.services;

import com.example.diplomwork.models.Order;
import com.example.diplomwork.models.Person;
import com.example.diplomwork.models.Product;
import com.example.diplomwork.repositories.OrderRepository;
import com.example.diplomwork.repositories.PersonRepository;
import com.example.diplomwork.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PersonRepository personRepository;


    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, PersonRepository personRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.personRepository = personRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Transactional
    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }
    @Transactional
    public void editStatusOrder(int id, Order order){
        order.setId(id);
        orderRepository.save(order);
    }

}
