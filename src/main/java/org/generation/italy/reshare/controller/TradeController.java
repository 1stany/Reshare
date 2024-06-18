package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.dto.ItemTradeDto;
import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.ItemTrade;
import org.generation.italy.reshare.model.UserPrincipal;
import org.generation.italy.reshare.model.services.abstractions.AppUserService;
import org.generation.italy.reshare.model.services.abstractions.ItemService;
import org.generation.italy.reshare.model.services.abstractions.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TradeController {
    private TradeService tradeService;
    private ItemService itemService;
    private AppUserService userService;

    @Autowired
    public TradeController(TradeService tradeService, ItemService itemService, AppUserService userService) {
        this.tradeService = tradeService;
        this.itemService = itemService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItemTrade(@RequestBody ItemTradeDto itemTradeDto) throws EntityNotFoundException {
        try {
            Item requestedItem = itemService.findItemById(itemTradeDto.getRequestedItemId());
            Item exchangedItem = itemService.findItemById(itemTradeDto.getExchangedItemId());
            AppUser requestingUser = userService.getUserById(itemTradeDto.getRequestingUserId());
            AppUser homeUser = userService.getUserById(itemTradeDto.getHomeUserId());

            ItemTrade itemTrade = itemTradeDto.toItemTrade(requestedItem, requestingUser, exchangedItem, homeUser);
            ItemTrade savedItemTrade = tradeService.saveItemTrade(itemTrade);
            ItemTradeDto tradeDto = new ItemTradeDto(savedItemTrade);
            return ResponseEntity.ok().body(tradeDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
