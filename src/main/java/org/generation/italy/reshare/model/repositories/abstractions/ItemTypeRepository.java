package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    List<ItemType> findAllById(long id);
}
