package team8;

public class Lodging implements Expense{
    int xnights;
    Destination xdest;

    public Lodging(Destination dest, int nights){
        xdest   = dest;
        xnights = nights;
    }

    public float getCost(){
        switch (xdest) {
            case Mexico:
                return (100.0F * xnights);
            case Europe:
                return (200.0F * xnights) * 1.10f;
            case Japan:
                return (300.0F * xnights) * 1.30f;
            default:
                return 0.0f;
        }
    }

}
