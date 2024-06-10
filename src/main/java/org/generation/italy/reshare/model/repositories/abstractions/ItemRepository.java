package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
