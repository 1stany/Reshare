package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.*;
import org.generation.italy.reshare.model.repositories.abstractions.*;
import org.generation.italy.reshare.model.services.abstractions.MarketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketServiceImp implements MarketService {
    private AppUserRepository appUserRepo;
    private ItemRepository itemRepo;

    public MarketServiceImp(AppUserRepository appUserRepo, ItemRepository itemRepo){
        this.appUserRepo = appUserRepo;
        this.itemRepo = itemRepo;
    }


    @Override
    public List<Item> searchItemsByCategory(int categoryId) {
        return itemRepo.findAllById(categoryId);
    }

    @Override
    public List<Item> searchItemsByCity(int cityId) {
        return itemRepo.findAllById(cityId);
    }

    @Override
    public List<Item> searchItemsByCondition(String condition) {
        return itemRepo.findAllByPart(condition);
    }

    @Override
    public List<Item> searchActiveItems(boolean activetrade) {
        return itemRepo.findAllActive(activetrade);
    }

    @Override
    public List<Item> searchItemsByUser(int userId) {
        return itemRepo.findAllById(userId);
    }

    @Override
    public List<Item> searchItemsByName(String itemTypeName) {
        return itemRepo.findAllByPart(itemTypeName);
    }

    @Override
    public List<Item> searchOfferedItems() {
        return itemRepo.findAllOffered();
    }

    @Override
    public Optional<AppUser> findUserById(int id) {
        return appUserRepo.findById(id);
    }
}
