import java.util.ArrayList;
import java.util.List;

public class GameStore {
    private List<Game> availableGames = new ArrayList<>();
    private List<Game> cart = new ArrayList<>();

    // Add a game to the store
    public void addGameToStore(String name, double price) {
        availableGames.add(new Game(name, price));
    }

    // Browse available games
    public List<Game> browseGames() {
        return availableGames;
    }

    // Add a game to the cart
    public void addToCart(String gameName) {
        for (Game game : availableGames) {
            if (game.getName().equalsIgnoreCase(gameName)) {
                cart.add(game);
                System.out.println(gameName + " added to cart.");
                return;
            }
        }
        System.out.println("Game not found.");
    }

    // View the cart
    public List<Game> viewCart() {
        return cart;
    }

    // Purchase games in the cart
    public void purchase() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("Purchasing the following games:");
        for (Game game : cart) {
            System.out.println(game);
            total += game.getPrice();
        }
        System.out.println("Total: $" + total);
        cart.clear();
    }
}
