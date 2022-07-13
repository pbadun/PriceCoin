package com.bb8qq.pricecoin.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "_notify")
@Data
public class Notify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userNotify;

    @ManyToOne
    private Coin coin;

    private Double price;

    // Верхний порог
    private Double pricePP;

    // Нижний порог
    private Double priceMM;

}
