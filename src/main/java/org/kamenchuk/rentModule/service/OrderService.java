package org.kamenchuk.rentModule.service;

import org.kamenchuk.dto.orderDTO.*;
import org.kamenchuk.rentModule.feinClient.FeignOrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final FeignOrderClient feignOrderClient;

    @Autowired
    public OrderService(FeignOrderClient feignOrderClient) {
        this.feignOrderClient = feignOrderClient;
    }

    public OrderCreateResponse create(Long idUser, OrderCreateRequest request) {
        return feignOrderClient.create(idUser, request);
    }

    public void delete(Long id) {
        feignOrderClient.delete(id);
    }

    public OrderResponse updateAdmin(OrderUpdateAdminRequest request, Long idAdmin) {
        return feignOrderClient.updateAdmin(request, idAdmin);
    }

    public OrderResponse updateClient(OrderUpdateClientRequest request, Long idOrder) {
        return feignOrderClient.updateClient(request, idOrder);
    }

    public List<OrderResponse> getByClientsId(Long idClient) {
        return feignOrderClient.getByClientsId(idClient);
    }

    public List<OrderResponse> getAll() {
        return feignOrderClient.getAll();
    }
}
