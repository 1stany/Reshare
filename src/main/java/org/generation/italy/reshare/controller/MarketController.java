package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.dto.ItemDto;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.services.abstractions.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {
    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> searchItems (@RequestParam(required = false) String condition,
                                                      @RequestParam(required = false) Boolean activetrade){
        List<Item> result = marketService.searchItems(condition, activetrade);
        return ResponseEntity.ok().body(result.stream().map(ItemDto::new).toList());
    }
}
