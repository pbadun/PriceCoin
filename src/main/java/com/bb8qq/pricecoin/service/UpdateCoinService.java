package com.bb8qq.pricecoin.service;

import com.bb8qq.pricecoin.dto.TickerDto;
import com.bb8qq.pricecoin.model.Coin;
import com.bb8qq.pricecoin.model.Notify;
import com.bb8qq.pricecoin.repo.CoinRepository;
import com.bb8qq.pricecoin.repo.NotifyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UpdateCoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private NotifyRepository notifyRepository;

    @Scheduled(fixedRate = 60000)
    public void updateRate() {
        List<Coin> coins = coinRepository.findAll();
        for (Coin c : coins) {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.coinlore.net/api/ticker/?id=" + c.getIdCoin();
            try {
                TickerDto[] result = restTemplate.getForObject(url, TickerDto[].class);
                c.setPrice(Double.parseDouble(result[0].getPrice_usd()));
                coinRepository.save(c);
            } catch (Exception e) {
                log.error(url);
            }
            sendNotify(c);
        }
    }

    private void sendNotify(Coin c) {
        log.info(c.getSymbolCoin() + " [" + c.getPrice() + "]");
        Double pp = c.getPrice();
        List<Notify> notifies = new ArrayList<>();
        notifies.addAll(notifyRepository.getNotifyListPP(c, pp));
        notifies.addAll(notifyRepository.getNotifyListMM(c, pp));
        for (Notify n : notifies) {
            StringBuffer sb = new StringBuffer();
            sb.append(c.getSymbolCoin());
            sb.append(" ");
            sb.append(n.getUserNotify().getUsername());
            sb.append(" [");
            sb.append(pp);
            sb.append(" : ");
            sb.append(n.getPrice());
            sb.append("] ");
            Double p = pp - n.getPrice();
            Double pr = 100 * p / pp;
            sb.append(pr);
            log.warn(sb.toString());
        }
    }

}
