package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.dto.ItemDto;
import org.generation.italy.reshare.dto.ItemTypeDto;
import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;
import org.generation.italy.reshare.model.UserPrincipal;
import org.generation.italy.reshare.model.services.abstractions.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public ResponseEntity<?> getUserById(@PathVariable long id){
        try{
            AppUser user = wishlistService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}/lamiawishlist")
    public ResponseEntity<?> getWishlistByUser(@PathVariable long userId){
        try {
            List<ItemType> wishlist = wishlistService.getWishlistByUserId(userId);
            return ResponseEntity.ok(wishlist.stream().map(ItemTypeDto::new).toList());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/user/itemType")
    public ResponseEntity<Boolean> addItemTypeForLoggedUser(@AuthenticationPrincipal UserPrincipal principal, @RequestBody ItemType itemType){
        try{
            boolean added = wishlistService.addItemType(principal.getUserId(), itemType);
            return ResponseEntity.ok(added);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/user/itemType/{itemTypeId}")
    public ResponseEntity<Boolean> removeItemTypeById(@AuthenticationPrincipal UserPrincipal principal, @PathVariable int itemTypeId){
        try{
            boolean removed = wishlistService.removeItemTypeById(principal.getUserId(), itemTypeId);
            return ResponseEntity.ok(removed);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/user/clearAll")
    public ResponseEntity<Boolean> clearWishlist(@AuthenticationPrincipal UserPrincipal principal){
        boolean cleared = wishlistService.clearWishlist(principal.getUserId());
        return ResponseEntity.ok(cleared);
    }

    @GetMapping("/itemtypes")
    public ResponseEntity<List<ItemType>> getAllItemType(){
        List<ItemType> itemTypes = wishlistService.getAllItemType();
        return ResponseEntity.ok(itemTypes);
    }





}
