import java.util.Scanner;

public class GameStoreSystem {
    public static void main(String[] args) {
        GameStore store = new GameStore();
        store.addGameToStore("Elden Ring", 79.99);
        store.addGameToStore("Balatro", 19.99);
        store.addGameToStore("Spider Man 2", 69.99);
        store.addGameToStore("Red Dead Redemption 2", 79.99);
        store.addGameToStore("Civilization 7", 89.99);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGame Store Menu:");
            System.out.println("1. Browse Games");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Purchase");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Games:");
                    for (Game game : store.browseGames()) {
                        System.out.println(game);
                    }
                    break;
                case 2:
                    System.out.print("Enter the name of the game to add to cart: ");
                    String gameName = scanner.nextLine();
                    store.addToCart(gameName);
                    break;
                case 3:
                    System.out.println("Games in Cart:");
                    for (Game game : store.viewCart()) {
                        System.out.println(game);
                    }
                    break;
                case 4:
                    store.purchase();
                    break;
                case 5:
                    System.out.println("Thank you for using the Ryan's Game Store for your purchases!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
