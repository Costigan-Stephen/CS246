package team8;

public class Player {
    String name;
    int health;
    int mana;
    int gold;

    public Player(){
        this.health = 100;
        this.gold = 0;
        this.mana = 100;
        setName("nothing");
    }

    // Player player = new Player("a",1,2,3);
    public Player(String name, int health, int mana, int gold)
    {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
    }

    public Player(String name)
    {
        this.name = name;
        this.health = 100;
        this.gold = 0;
        this.mana = 100;
    }

    public Player(Player foreignPlayer)
    {
        this.name = foreignPlayer.getName();
        this.health = foreignPlayer.getHealth();
        this.mana = foreignPlayer.getMana();
        this.gold = foreignPlayer.getGold();
    }

    public Player(Game game)
    {
        this.name = game.getPlayer().getName();
        this.health = game.getPlayer().getHealth();
        this.mana = game.getPlayer().getMana();
        this.gold = game.getPlayer().getGold();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}