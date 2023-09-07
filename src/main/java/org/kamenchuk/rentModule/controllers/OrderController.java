package org.kamenchuk.rentModule.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.dto.orderDTO.*;
import org.kamenchuk.rentModule.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent_module/order")
@SecurityRequirement(name = "bearerToken")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/create")
    public OrderCreateResponse create(@RequestParam Long idUser, @RequestBody OrderCreateRequest request) {
        return orderService.create(idUser, request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }

    @PatchMapping(value = "/admin/update")
    public OrderResponse updateAdmin(@RequestBody OrderUpdateAdminRequest request, @RequestParam Long idAdmin) {
        return orderService.updateAdmin(request, idAdmin);
    }

    @PatchMapping(value = "/update")
    public OrderResponse updateClient(@RequestBody OrderUpdateClientRequest request, @RequestParam Long idOrder) {
        return orderService.updateClient(request, idOrder);
    }

    @GetMapping(value = "/getOrderByClientId/{id}")
    public List<OrderResponse> getByClientsId(Long idClient) {
        return orderService.getByClientsId(idClient);
    }

    @GetMapping(value = "/admin/getAll")
    public List<OrderResponse> getAll() {
        return orderService.getAll();
    }
}
