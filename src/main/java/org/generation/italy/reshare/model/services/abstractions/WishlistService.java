package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.ItemType;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    boolean addItemTypeById(long userId, long itemTypeId);
    boolean removeItemTypeById(long userId, long itemTypeId);
    boolean clearWishlist(long userId);
    AppUser getUserById(long id);
    Optional<ItemType> getItemTypeById(long id);
    List<ItemType> getAllItemType();
    List<ItemType> getAllItemTypeByCategory(long id);
    List<ItemType> getAllItemTypeByCity(long id);


}
