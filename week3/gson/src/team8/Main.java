package team8;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Steve",100,100,5000);
        Player player4 = new Player("Tester");
        String filename = "test.txt";

        Game game = new Game(player);
        game.saveGame(filename);

        Player player3 = new Player(player4);

//        player3.setName("John");
//        player3.setHealth(50);

        Gson g = new Gson();
        String playerGson = g.toJson(player3);
        System.out.println(playerGson);

        player.setGold(3000);

        Player player2 = new Player(game.LoadGame(filename));
        Game newGame = new Game(player2);
        newGame.LoadGame(filename);

        System.out.println("Gold of imported character");
        System.out.println(newGame.getPlayer().getGold());
    }
}
