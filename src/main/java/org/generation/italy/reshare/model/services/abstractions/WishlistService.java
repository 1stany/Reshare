package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;

import java.util.List;

public interface WishlistService {
    void addiItemTypeById(int id);
    void removeItemTypeById(int id);
    boolean clearWishlist(int userId);
    List<ItemType> getAllItemType();
    List<ItemType> getAllItemTypeByCategory(int id);
    List<ItemType> getAllItemTypeByCity(int id);


}
