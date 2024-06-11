package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    boolean addItemTypeById(int userId, int itemTypeId);
    boolean removeItemTypeById(int userId, int itemTypeId);
    boolean clearWishlist(int userId);
    AppUser getUserById(int id);
    Optional<ItemType> getItemTypeById(int id);
    List<ItemType> getAllItemType();
    List<ItemType> getAllItemTypeByCategory(int id);
    List<ItemType> getAllItemTypeByCity(int id);


}
