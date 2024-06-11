package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.*;
import org.generation.italy.reshare.model.repositories.abstractions.*;
import org.generation.italy.reshare.model.services.abstractions.MarketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaMarketService implements MarketService {
    private AppUserRepository appUserRepo;
    private CategoryRepository categoryRepo;
    private CityRepository cityRepo;
    private ItemRepository itemRepo;
    private ItemTypeRepository itemTypeRepo;
    private OfferRepository offerRepo;

    public JpaMarketService(AppUserRepository appUserRepo, CategoryRepository categoryRepo, CityRepository cityRepo, ItemRepository itemRepo, ItemTypeRepository itemTypeRepo, OfferRepository offerRepo){
        this.appUserRepo = appUserRepo;
        this.categoryRepo = categoryRepo;
        this.cityRepo = cityRepo;
        this.itemRepo = itemRepo;
        this.itemTypeRepo = itemTypeRepo;
        this.offerRepo = offerRepo;
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
    public List<Item> searchOfferedItems(boolean active) {
        return itemRepo.findAllActive(active);
    }

    @Override
    public Optional<AppUser> findUserById(int id) {
        return appUserRepo.findById(id);
    }
}
