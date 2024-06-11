package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllById(int categoryId);

    List<Item> findAllByPart(String part);

    List<Item> findAllActive(boolean active);
}
