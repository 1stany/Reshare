package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.ItemTrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ItemTradeRepository extends JpaRepository<ItemTrade, Integer> {
    List<ItemTrade> findAllById(int id);

    List<ItemTrade> findByRequestDate(LocalDate requestDate);

    List<ItemTrade> findByExchangeDate(LocalDate exchangeDate);
}
