package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.*;

import java.util.List;
import java.util.Optional;

public interface MarketService {
List<Item> searchItemsByCategory(int categoryId) throws EntityNotFoundException;
List<Item> searchItemsByCity(int cityId);
List<Item> searchItemsByCondition(String condition);
List<Item> searchActiveItems(boolean activetrade);
List<Item> searchItemsByUser(int userId) throws EntityNotFoundException;
List<Item> searchItemsByName(String itemTypeName);
List<Item> searchOfferedItems();
Optional<AppUser> findUserById (int id);
List<Item> searchItems(String condition, Boolean activetrade);
}
