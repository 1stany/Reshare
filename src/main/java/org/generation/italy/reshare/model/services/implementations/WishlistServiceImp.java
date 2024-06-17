package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;
import org.generation.italy.reshare.model.repositories.abstractions.*;
import org.generation.italy.reshare.model.services.abstractions.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImp implements WishlistService {
    private AppUserRepository appUserRepo;
    private ItemTypeRepository itemTypeRepo;


    public WishlistServiceImp(AppUserRepository appUserRepo, ItemTypeRepository itemTypeRepo){
        this.appUserRepo = appUserRepo;
        this.itemTypeRepo = itemTypeRepo;
    }

    @Override
    public AppUser getUserById(long id) {
        Optional<AppUser> u = appUserRepo.findById(id);
        if(u.isEmpty()){
            throw new IllegalArgumentException("Utente non trovato");
        }
        return u.get();
    }

    @Override
    public Optional<ItemType> getItemTypeById(long id) {
        return itemTypeRepo.findById(id);
    }

    @Override
    public boolean addItemTypeById(long userId, long itemTypeId) {
        List<ItemType> wishlist = getUserById(userId).getWishlist();
        Optional<ItemType> otpItem = getItemTypeById(itemTypeId);
        if (otpItem.isPresent() && wishlist.stream().filter(i->i.getId()==itemTypeId).findFirst().isEmpty()){
            wishlist.add(otpItem.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeItemTypeById(long userId, long itemTypeId) {
        List<ItemType> wishlist = getUserById(userId).getWishlist();
        Optional<ItemType> otpItem = getItemTypeById(itemTypeId);
        if (otpItem.isPresent() && wishlist.stream().filter(i->i.getId()==itemTypeId).findFirst().isPresent()){
            wishlist.remove(otpItem.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean clearWishlist(long userId) {
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
    public List<ItemType> getAllItemTypeByCategory(long categoryId) {
        return itemTypeRepo.findAllById(categoryId);
    }

    @Override
    public List<ItemType> getAllItemTypeByCity(long cityId) {
        return itemTypeRepo.findAllById(cityId);
    }
}
