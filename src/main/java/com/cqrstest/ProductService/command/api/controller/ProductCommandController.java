package com.cqrstest.ProductService.command.api.controller;

import java.util.UUID;

import com.cqrstest.ProductService.command.api.commands.CreateProductCommand;
import com.cqrstest.ProductService.command.api.model.ProductModel;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private CommandGateway commandgateway;

    public ProductCommandController(CommandGateway cg) {
        commandgateway = cg;
    }

    @PostMapping
    public String addProduct(@RequestBody ProductModel pm) {
        
        CreateProductCommand createproductcommand = CreateProductCommand.builder()
        .productId(UUID.randomUUID().toString())
        .name(pm.getName())
        .price(pm.getPrice())
        .quantity(pm.getQuantity())
        .build();

        String result = commandgateway.sendAndWait(createproductcommand);

        return result;
    }
    
}
