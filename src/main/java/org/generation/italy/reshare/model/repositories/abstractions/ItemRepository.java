package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByActivetrade(boolean activetrade);
    List<Item> findByCondition(String condition);
    List<Item> findByConditionAndActivetrade(String condition, boolean activetrade);

    List<Item> findByOwnerId(int userId);

    List<Item> findByCategoryId(int categoryId);
}
