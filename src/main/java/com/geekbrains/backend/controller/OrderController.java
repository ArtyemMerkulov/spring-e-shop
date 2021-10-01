package com.geekbrains.backend.controller;

import com.geekbrains.backend.dto.OrderDto;
import com.geekbrains.backend.dto.OrderItemDto;
import com.geekbrains.backend.facade.OrderFacade;
import com.geekbrains.backend.facade.OrderItemFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderFacade orderFacade;
    private final OrderItemFacade orderItemFacade;

    @Autowired
    public OrderController(OrderFacade orderFacade,
                           OrderItemFacade orderItemFacade) {
        this.orderFacade = orderFacade;
        this.orderItemFacade = orderItemFacade;
    }

    @GetMapping("/")
    public List<OrderDto> getAll() {
        List<OrderDto> orderDtos = orderFacade.findAll();
        return orderDtos != null && !orderDtos.isEmpty() ? orderDtos : new ArrayList<>(0);
    }

    @PostMapping("/")
    public String create(@Valid OrderDto orderDto) {
        orderFacade.save(orderDto);
        orderItemFacade.saveItems(orderDto.getOrderItems());
        return "redirect:/orders/";
    }

    @DeleteMapping("/{uuid}")
    public String remove(@PathVariable("uuid") UUID uuid) {
        orderFacade.deleteByUuid(uuid);
        return "redirect:/orders/";
    }

    @GetMapping("/edit/{uuid}")
    public OrderDto getEditPage(@PathVariable("uuid") UUID uuid) {
        return orderFacade.findByUuid(uuid);
    }

    @PutMapping("/update")
    public String update(@Valid OrderDto orderDto) {
        orderFacade.save(orderDto);
        return "redirect:/orders/";
    }

    @DeleteMapping("/{order_uuid}/{order_item_uuid}")
    public String deleteOrderItems(@PathVariable("order_uuid") String order_uuid,
                                   @PathVariable("order_item_uuid") UUID orderItemUuid) {
        orderItemFacade.deleteByUuid(orderItemUuid);
        return "redirect:/orders/";
    }

    @PutMapping("/update/{order_uuid}/{order_item_uuid}")
    public String updateOrderItems(@PathVariable("order_uuid") String order_uuid,
                                   @PathVariable("order_item_uuid") UUID orderItemUuid,
                                   @Valid OrderItemDto orderItemDto) {
        orderItemFacade.save(orderItemDto);
        return "redirect:/orders/";
    }

}
