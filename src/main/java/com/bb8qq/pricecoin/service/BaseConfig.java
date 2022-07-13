package com.bb8qq.pricecoin.service;

import com.bb8qq.pricecoin.model.Coin;
import com.bb8qq.pricecoin.repo.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BaseConfig {

    @Autowired
    private CoinRepository coinRepository;

    @PostConstruct
    public void postInit() {
        Integer total = coinRepository.countAllBy();
        if (total != 0) {
            return;
        }
        int[] ids = {90, 80, 48543};
        String[] symbols = {"BTC", "ETH", "SOL"};
        for (int i = 0; i < ids.length; i++) {
            Coin c = new Coin();
            c.setIdCoin(ids[i]);
            c.setSymbolCoin(symbols[i]);
            coinRepository.save(c);
        }
    }

}
