import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {
    private GameStore store;

    @BeforeEach
    void setUp() {
        store = new GameStore();
        store.addGameToStore("Elden Ring", 79.99);
        store.addGameToStore("Balatro", 19.99);
        store.addGameToStore("Spider Man 2", 69.99);
        store.addGameToStore("Red Dead Redemption 2", 79.99);
        store.addGameToStore("Civilization 7", 89.99);
    }

    @Test
    void testBrowseGames() {
        List<Game> games = store.browseGames();
        assertEquals(5, games.size());
        assertEquals("Elden Ring", games.get(0).getName());
        assertEquals(79.99, games.get(0).getPrice());
    }

    @Test
    void testAddToCart() {
        store.addToCart("Spider Man 2");
        List<Game> cart = store.viewCart();
        assertEquals(1, cart.size());
        assertEquals("Spider Man 2", cart.get(0).getName());
        assertEquals(69.99, cart.get(0).getPrice());
    }

    @Test
    void testPurchase() {
        store.addToCart("Elden Ring");
        store.addToCart("Civilization 7");
        store.purchase();
        assertTrue(store.viewCart().isEmpty());
    }

    @Test
    void testAddToCartInvalidGame() {
        store.addToCart("Nonexistent Game");
        assertTrue(store.viewCart().isEmpty());
    }

    @Test
    void testViewCart() {
        store.addToCart("Red Dead Redemption 2");
        List<Game> cart = store.viewCart();
        assertEquals(1, cart.size());
        assertEquals("Red Dead Redemption 2", cart.get(0).getName());
    }
}
