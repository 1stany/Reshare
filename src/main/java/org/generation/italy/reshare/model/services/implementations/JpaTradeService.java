package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.ItemTrade;
import org.generation.italy.reshare.model.Offer;
import org.generation.italy.reshare.model.repositories.abstractions.*;
import org.generation.italy.reshare.model.services.abstractions.TradeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JpaTradeService implements TradeService {
    private AppUserRepository appUserRepo;
    private ItemRepository itemRepo;
    private ItemTradeRepository tradeRepo;
    private ItemTypeRepository itemTypeRepo;
    private OfferRepository offerRepo;

    public JpaTradeService(AppUserRepository appUserRepo, ItemRepository itemRepo, ItemTradeRepository tradeRepo, ItemTypeRepository itemTypeRepo, OfferRepository offerRepo){
        this.appUserRepo = appUserRepo;
        this.itemRepo = itemRepo;
        this.tradeRepo = tradeRepo;
        this.itemTypeRepo = itemTypeRepo;
        this.offerRepo = offerRepo;
    }

    @Override
    public List<ItemTrade> getAll() {
        return tradeRepo.findAll();
    }

    @Override
    public List<ItemTrade> getAllById(int id) {
        return tradeRepo.findAllById(id);
    }

    @Override
    public List<ItemTrade> getAllByRequestDate(LocalDate requestDate) {
        return tradeRepo.findByRequestDate(requestDate);
    }

    @Override
    public List<ItemTrade> getAllByExchangeDate(LocalDate exchangeDate) {
        return tradeRepo.findByExchangeDate(exchangeDate);
    }

    @Override
    public List<ItemTrade> getAllByItem(String itemName) {
        return tradeRepo.findByItemName(itemName);
    }

    @Override
    public AppUser getUserById(int id) {
        Optional<AppUser> u = appUserRepo.findById(id);
        if(u.isEmpty()){
            throw new IllegalArgumentException("Utente non trovato");
        }
        return u.get();
    }

    //item1 è l'oggetto che si desidera
    //item2 è l'oggetto che si scambia
    @Override
    public void exchangeItem(int userId1, int userId2) {
        AppUser user1 = getUserById(userId1);
        AppUser user2 = getUserById(userId2);
        Item u1Item = user1.getRequestingItemTrade().getRequestedItem();
        Item u2Item = user2.getHomeItemTrade().getExchangedItem();
        Optional<Item> exchangedItem = user1.getItems().stream().filter(i->i.getId()==u2Item.getId()).findFirst();
        Optional<Item> requestingItem = user2.getItems().stream().filter(i->i.getId()==u1Item.getId()).findFirst();
        if(exchangedItem.isPresent()&&requestingItem.isPresent()){
            if(exchangedItem.get().isActivetrade()&&requestingItem.get().isActivetrade()){
                exchangedItem.get().setActivetrade(false);
                requestingItem.get().setActivetrade(false);
            } else {
                throw new IllegalStateException("Uno o entrambi gli oggetti non sono attivi per lo scambio");
            }
        } else {
            throw new IllegalStateException("Uno o entrambi gli oggetti non sono stati trovati nella lista degli utenti");
        }
    }


    @Override
    public void exchangeOfferedItem(int userId1) {
        AppUser user1 = getUserById(userId1);
        Item u1Item = user1.getOffer().getOfferedItem();
        Optional<Item> offeredItem = user1.getItems().stream().filter(i->i.getId()==u1Item.getId()).findFirst();
        if(offeredItem.isPresent()){
            if(offeredItem.get().isActivetrade()){
                offeredItem.get().setActivetrade(false);
                user1.setOffer(new Offer());
            } else {
                throw new IllegalStateException("L'oggetto non è attivo per lo scambio");
            }
        } else {
            throw new IllegalStateException("L'oggetto non è stato trovato nella lista dell'utente");
        }
    }
}
