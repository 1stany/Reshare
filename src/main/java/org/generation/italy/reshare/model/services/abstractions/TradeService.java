package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemTrade;

import java.time.LocalDate;
import java.util.List;

public interface TradeService {
    List<ItemTrade> getAll();
    List<ItemTrade> getAllById(int id);
    List<ItemTrade> getAllByRequestDate(LocalDate requestDate);
    List<ItemTrade> getAllByExchangeDate(LocalDate exchangeDate); //servono due date????
    List<ItemTrade> getAllByItem(String itemName);
    AppUser getUserById(int id);

    void exchangeItem(int userId1, int userId2);
    void exchangeOfferedItem(int userId1);




}
