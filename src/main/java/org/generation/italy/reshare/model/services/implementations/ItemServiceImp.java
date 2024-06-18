package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Category;
import org.generation.italy.reshare.model.City;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.repositories.abstractions.AppUserRepository;
import org.generation.italy.reshare.model.repositories.abstractions.CategoryRepository;
import org.generation.italy.reshare.model.repositories.abstractions.CityRepository;
import org.generation.italy.reshare.model.repositories.abstractions.ItemRepository;
import org.generation.italy.reshare.model.services.abstractions.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {
    private ItemRepository itemRepo;
    private CategoryRepository catRepo;
    private CityRepository cityRepo;
    private AppUserRepository appUserRepo;

    public ItemServiceImp(ItemRepository itemRepo, CategoryRepository catRepo, CityRepository cityRepo, AppUserRepository appUserRepo) {
        this.itemRepo = itemRepo;
        this.catRepo = catRepo;
        this.cityRepo = cityRepo;
        this.appUserRepo = appUserRepo;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public Category findCategoryByName(String name) {
        return catRepo.findByName(name);
    }

    @Override
    public City findCityByName(String name) {
        return cityRepo.findByName(name);
    }

    @Override
    public AppUser findOwnerByEmail(String ownerEmail) {
        return appUserRepo.findByEmail(ownerEmail);
    }

}
