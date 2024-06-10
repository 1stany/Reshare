package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Category;
import org.generation.italy.reshare.model.City;
import org.generation.italy.reshare.model.Item;

import java.util.List;

public interface TradeService {
List<Item> searchItems(Category category);
List<Item> searchItems(City city);
List<Item> searchItems(String itemName);
List<Item> searchItems(boolean activetrade);
List<Item> searchItems(AppUser owner);

}
