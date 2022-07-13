package com.bb8qq.pricecoin.service;

import com.bb8qq.pricecoin.model.Coin;
import com.bb8qq.pricecoin.repo.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BaseConfig {

    @Value("${coin.id}")
    private String ids;

    @Value("${coin.symbol}")
    private String symbols;

    @Autowired
    private CoinRepository coinRepository;

    @PostConstruct
    public void postInit() {
        Integer total = coinRepository.countAllBy();
        if (total != 0) {
            return;
        }
        String[] id = ids.split(",");
        String[] symbol = symbols.split(",");
        for (int i = 0; i < id.length; i++) {
            Coin c = new Coin();
            c.setIdCoin(Integer.parseInt(id[i]));
            c.setSymbolCoin(symbol[i]);
            coinRepository.save(c);
        }
    }

}
