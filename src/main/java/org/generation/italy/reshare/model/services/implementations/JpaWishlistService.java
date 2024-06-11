package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;
import org.generation.italy.reshare.model.repositories.abstractions.*;
import org.generation.italy.reshare.model.services.abstractions.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaWishlistService implements WishlistService {
    private AppUserRepository appUserRepo;
    private CategoryRepository categoryRepo;
    private CityRepository cityRepo;
    //private ItemRepository itemRepo;
    private ItemTypeRepository itemTypeRepo;
    //private OfferRepository offerRepo;

    public JpaWishlistService(AppUserRepository appUserRepo, CategoryRepository categoryRepo, CityRepository cityRepo, ItemTypeRepository itemTypeRepo){
        this.appUserRepo = appUserRepo;
        this.categoryRepo = categoryRepo;
        this.cityRepo = cityRepo;
        //this.itemRepo = itemRepo;
        this.itemTypeRepo = itemTypeRepo;
        //this.offerRepo = offerRepo;
    }

    @Override
    public void addiItemTypeById(int id) {

    }

    @Override
    public void removeItemTypeById(int id) {

    }

    @Override
    public boolean clearWishlist(int userId) {
        Optional<AppUser> optUser = appUserRepo.findById(userId);
        if(optUser.isPresent()){
            optUser.get().getWishlist().clear();
            return true;
        } return false;
    }

    @Override
    public List<ItemType> getAllItemType() {
        return itemTypeRepo.findAll();
    }

    @Override
    public List<ItemType> getAllItemTypeByCategory(int categoryId) {
        return itemTypeRepo.findAllByCategoryId(categoryId);
    }

    @Override
    public List<ItemType> getAllItemTypeByCity(int cityId) {
        return itemTypeRepo.findAllByCityId(cityId);
    }
}
