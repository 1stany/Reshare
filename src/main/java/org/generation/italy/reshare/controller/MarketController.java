package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.dto.ItemDto;
import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.services.abstractions.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
@CrossOrigin(origins = "http://localhost:4200")
public class MarketController {
    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> searchItems (@RequestParam(required = false) String condition,
                                                      @RequestParam(required = false) Boolean activetrade,
                                                      @RequestParam(required = false) Integer lastN){
        List<Item> result = marketService.searchItems(condition, activetrade, lastN);
        return ResponseEntity.ok().body(result.stream().map(ItemDto::new).toList());
    }

    @GetMapping ("/user/{id}/item")
    public ResponseEntity<?> getItemsByUser (@PathVariable int id) {
        try {
            List<Item> result = marketService.searchItemsByUser(id);
            return ResponseEntity.ok().body(result.stream().map(ItemDto::new).toList());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping ("/category/{id}/item")
    public ResponseEntity<?> getItemByCategory (@PathVariable int id){
        try{
            List<Item> result = marketService.searchItemsByCategory(id);
            return ResponseEntity.ok().body(result.stream().map(ItemDto::new).toList());
        }catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
