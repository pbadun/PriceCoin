package com.bb8qq.pricecoin.controller;

import com.bb8qq.pricecoin.model.Coin;
import com.bb8qq.pricecoin.repo.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coin")
public class CoinRestController {

    @Autowired
    private CoinRepository coinRepository;

    @GetMapping
    public List<Coin> allCoin() {
        return coinRepository.findAll();
    }

    @GetMapping("{symbol}")
    public Double price(@PathVariable String symbol) {
        return coinRepository.findBySymbolCoin(symbol).getPrice();
    }

}
