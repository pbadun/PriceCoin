package com.bb8qq.pricecoin.repo;

import com.bb8qq.pricecoin.model.Coin;
import com.bb8qq.pricecoin.model.Notify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotifyRepository extends JpaRepository<Notify, Long> {

    @Query(value = "SELECT n FROM Notify n WHERE n.coin=?1 AND n.pricePP <= ?2")
    List<Notify> getNotifyListPP(Coin coin, Double price);

    @Query(value = "SELECT n FROM Notify n WHERE n.coin=?1 AND n.priceMM >= ?2")
    List<Notify> getNotifyListMM(Coin coin, Double price);

}
