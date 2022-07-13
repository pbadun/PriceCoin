package com.bb8qq.pricecoin.repo;

import com.bb8qq.pricecoin.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Long> {

    Integer countAllBy();

    Coin findBySymbolCoin(String symbol);

}
