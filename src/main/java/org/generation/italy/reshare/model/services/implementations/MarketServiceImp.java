package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.*;
import org.generation.italy.reshare.model.repositories.abstractions.*;
import org.generation.italy.reshare.model.services.abstractions.MarketService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketServiceImp implements MarketService {
    private AppUserRepository appUserRepo;
    private ItemRepository itemRepo;
    private CategoryRepository categoryRepo;

    public MarketServiceImp(AppUserRepository appUserRepo, ItemRepository itemRepo, CategoryRepository categoryRepo){
        this.appUserRepo = appUserRepo;
        this.itemRepo = itemRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<Item> searchItemsByCategory(int categoryId) throws EntityNotFoundException {
        Optional<Category> oC = categoryRepo.findById(categoryId);
        if(oC.isEmpty()){
            throw new EntityNotFoundException(oC.getClass(), categoryId);
        }
        return itemRepo.findByCategoryId(categoryId);
    }

    @Override
    public List<Item> searchItemsByCity(int cityId) {
        return null;
    }

    //Le condizioni salvate sul db in un check sono: come nuovo, ottimo, buono, accettabile
    //è meglio mettere l'eccezione o gestire un optional di list di item?
    @Override
    public List<Item> searchItemsByCondition(String condition) {
        condition = condition.toLowerCase();
        if(Item.CONDITIONS.contains(condition)){
            return null;
        }
        throw new IllegalArgumentException("Condizione non valida");
    }

    @Override
    public List<Item> searchActiveItems(boolean activetrade) {
        return null;
    }

    @Override
    public List<Item> searchItemsByUser(int userId) throws EntityNotFoundException{
        Optional<AppUser> oU = appUserRepo.findById(userId);
        if(oU.isEmpty()){
            throw new EntityNotFoundException(AppUser.class, userId);
        }
        return itemRepo.findByOwnerId(userId);
    }

    @Override
    public List<Item> searchItemsByName(String itemTypeName) {
        return null;
    }

    @Override
    public List<Item> searchOfferedItems() {
        return null;
    }

    @Override
    public Optional<AppUser> findUserById(int id) {
        return appUserRepo.findById(id);
    }

    @Override
    public List<Item> searchItems(String condition, Boolean activetrade, Integer lastN) {
        if(lastN!=null){
            Pageable pageable = PageRequest.of(0,lastN);
            return itemRepo.findAllByOrderByCreationDateDesc(pageable).getContent();
        }
        if(condition!= null && !Item.CONDITIONS.contains(condition)) {
            throw new IllegalArgumentException("Condizione non valida");
        }
        if(condition==null && activetrade == null){
            return itemRepo.findAll();
        }
        if(condition == null && activetrade != null) {
            return itemRepo.findByActivetrade(activetrade);
        }
        if(condition != null && activetrade == null) {
            return itemRepo.findByCondition(condition);
        }
        return itemRepo.findByConditionAndActivetrade(condition, activetrade);
    }
}
