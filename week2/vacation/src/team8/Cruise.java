package team8;

public class Cruise implements Expense{
    float cost;
    public Cruise(Destination dest){
        switch (dest) {
            case Mexico:
                cost = 1000.0F;
                break;
            case Europe:
                cost = 2000.0F;
                break;
            case Japan:
                cost = 3000.0F;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dest);
        }
    }

    public float getCost(){
        return cost;
    }
}
