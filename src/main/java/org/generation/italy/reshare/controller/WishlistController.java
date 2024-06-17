package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;
import org.generation.italy.reshare.model.services.abstractions.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {


    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        try{
            AppUser user = wishlistService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/user/{userId}/itemType/{itemTypeId}")
    public ResponseEntity<Boolean> addItemTypeById(@PathVariable long userId, @PathVariable long itemTypeId){
        try{
            boolean added = wishlistService.addItemTypeById(userId, itemTypeId);
            return ResponseEntity.ok(added);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/user/{userId}/itemType/{itemTypeId}")
    public ResponseEntity<Boolean> removeItemTypeById(@PathVariable int userId, @PathVariable int itemTypeId){
        try{
            boolean removed = wishlistService.removeItemTypeById(userId, itemTypeId);
            return ResponseEntity.ok(removed);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/user/{id}/wishlist")
    public ResponseEntity<Boolean> clearWishlist(@PathVariable int id){
        boolean cleared = wishlistService.clearWishlist(id);
        return ResponseEntity.ok(cleared);
    }

    @GetMapping("/itemtypes")
    public ResponseEntity<List<ItemType>> getAllItemType(){
        List<ItemType> itemTypes = wishlistService.getAllItemType();
        return ResponseEntity.ok(itemTypes);
    }





}
