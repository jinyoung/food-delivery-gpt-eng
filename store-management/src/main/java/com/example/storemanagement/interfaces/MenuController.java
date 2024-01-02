package com.example.storemanagement.interfaces;

import com.example.storemanagement.application.MenuService;
import com.example.storemanagement.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/manage")
    public ResponseEntity<Void> manageMenu(
            @RequestParam String menuName,
            @RequestParam Money price,
            @RequestParam String stockStatus,
            @RequestParam String availability) {
        menuService.manageMenu(menuName, price, stockStatus, availability);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/confirm-order")
    public ResponseEntity<Void> confirmOrder(@RequestParam String orderId) {
        menuService.confirmOrder(orderId);
        return ResponseEntity.ok().build();
    }
}