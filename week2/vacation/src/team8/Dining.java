package team8;

public class Dining implements Expense{
    int xnights;
    Destination xdest;

    public Dining(Destination dest, int nights){
        xdest   = dest;
        xnights = nights;
    }

    public float getCost(){
        switch (xdest) {
            case Mexico:
                return 10.0F;
            case Europe:
                return 20.0F;
            case Japan:
                return 30.0F;
            default:
                return 0.0f;
        }
    }

}
