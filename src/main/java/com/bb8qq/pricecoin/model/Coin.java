package com.bb8qq.pricecoin.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "_coin")
@Data
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer idCoin;

    @Column
    private String symbolCoin;

    @Column
    private Double price;

}
