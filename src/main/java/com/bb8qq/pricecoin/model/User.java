package com.bb8qq.pricecoin.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

}
