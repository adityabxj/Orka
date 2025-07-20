package net.orka.orderservice.controller;

import net.orka.basedomains.dto.OrderDTO;
import net.orka.basedomains.dto.OrderEventDTO;
import net.orka.orderservice.kafka.OrderProducer;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orka")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/order")
    public String placeOrder(@RequestBody OrderDTO orderDTO) {
        orderDTO.setOrderId(UUID.randomUUID().toString());

        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setStatus("PENDING");
        orderEventDTO.setMessaage("order status is in pending state");
        orderEventDTO.setOrderDTO(orderDTO);

        orderProducer.sendMessage(orderEventDTO);

        return "Order placed successfully";
    }
}
