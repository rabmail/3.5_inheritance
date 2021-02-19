package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode

public class Smartphone extends Product{
    private String producer;

    public Smartphone(String producer) {
        this.producer = producer;
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }
}