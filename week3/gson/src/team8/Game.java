package team8;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Game {
    Player player;

    public Game(Player newPlayer){
        this.player = newPlayer;
    }

    public Player getPlayer(){
        return player;
    }

    public void saveGame(String file){
        Gson gson = new Gson();
        String playerGson = gson.toJson(getPlayer());

        //testing output
        System.out.println(playerGson);

        try (PrintWriter out = new PrintWriter(file)) {
            out.println(playerGson);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Player LoadGame(String file){
        Gson gson = new Gson();
        Player player = null;

        //testing output
        File fr = new File(file);

        try {
            InputStreamReader isReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);

            JsonReader myReader = new JsonReader(isReader);
            player = gson.fromJson(myReader, Player.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return player;
    }
}
