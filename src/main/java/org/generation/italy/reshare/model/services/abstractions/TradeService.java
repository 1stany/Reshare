package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemTrade;

import java.time.LocalDate;
import java.util.List;

public interface TradeService {
    List<ItemTrade> getAll();
    List<ItemTrade> getAllById(long id);
    List<ItemTrade> getAllByRequestDate(LocalDate requestDate);
    List<ItemTrade> getAllByExchangeDate(LocalDate exchangeDate); //servono due date????
    List<ItemTrade> getAllByItem(String itemName);
    AppUser getUserById(long id);

    void exchangeItem(long userId1, long userId2);
    void exchangeOfferedItem(long userId1);




}
