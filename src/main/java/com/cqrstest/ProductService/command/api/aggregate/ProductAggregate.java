package com.cqrstest.ProductService.command.api.aggregate;

import java.math.BigDecimal;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.cqrstest.ProductService.command.api.commands.CreateProductCommand;
import com.cqrstest.ProductService.command.api.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;


    public ProductAggregate() {
    }


    public ProductAggregate(CreateProductCommand createprodcmd) {
        ProductCreatedEvent PCE = new ProductCreatedEvent();

        BeanUtils.copyProperties(createprodcmd, PCE);
    }

}
