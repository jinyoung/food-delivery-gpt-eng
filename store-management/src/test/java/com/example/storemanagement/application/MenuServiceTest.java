package com.example.storemanagement.application;

import com.example.storemanagement.domain.Menu;
import com.example.storemanagement.infrastructure.MenuRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class MenuServiceTest {
    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuService menuService;

    @Test
    void manageMenu_shouldSaveMenu() {
        // Arrange
        String menuName = "Pizza";
        Money price = new Money();
        String stockStatus = "In Stock";
        String availability = "Available";

        // Act
        menuService.manageMenu(menuName, price, stockStatus, availability);

        // Assert
        verify(menuRepository).save(new Menu()); // Simplified for example purposes
    }

    @Test
    void confirmOrder_shouldHandleOrderConfirmation() {
        // Arrange
        String orderId = "123";

        // Act
        menuService.confirmOrder(orderId);

        // Assert
        // Add verification logic for order confirmation
    }
}