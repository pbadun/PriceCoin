package com.bb8qq.pricecoin.service;

import com.bb8qq.pricecoin.model.Coin;
import com.bb8qq.pricecoin.model.Notify;
import com.bb8qq.pricecoin.model.User;
import com.bb8qq.pricecoin.repo.CoinRepository;
import com.bb8qq.pricecoin.repo.NotifyRepository;
import com.bb8qq.pricecoin.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyUserService {

    @Autowired
    private NotifyRepository notifyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoinRepository coinRepository;

    public void addNotify(String username, String symbol) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            userRepository.save(user);
        }
        Coin coin = coinRepository.findBySymbolCoin(symbol);
        if (coin == null) {
            throw new Exception("Нет такой валюты!");
        }

        Notify notify = new Notify();
        notify.setUserNotify(user);
        notify.setCoin(coin);

        notify.setPrice(coin.getPrice());
        //TODO 1%
        Double pp = coin.getPrice() * 0.01d;

        notify.setPricePP(coin.getPrice() + pp);
        notify.setPriceMM(coin.getPrice() - pp);
        notifyRepository.save(notify);
    }

}
