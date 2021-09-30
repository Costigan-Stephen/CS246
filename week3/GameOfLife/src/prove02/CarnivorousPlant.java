package prove02;

import java.awt.*;

public class CarnivorousPlant extends Creature implements Growth, Aware, Aggressor{
    Point _location;
    int _health;
    boolean _readyToSpawn;
    Point _growth;

    public CarnivorousPlant() {
        _readyToSpawn = false;
        _health = 1;
        _growth = null;
    }

    /**
     * Gets the location of the creature in game coordinates.
     * @return The current location of the creature.
     */
    public Point getLocation() {
        return this._location;
    }

    /**
     * Sets the location of the creature in game coordinates.
     * @param newValue The new location of the creature.
     */
    public void setLocation(Point newValue) {
        _location = newValue;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 0);
    }

    public Boolean isAlive() {
        return _health > 0;
    }

    public Boolean canSpawn(){
        return _readyToSpawn;
    }

    public Point getDirection(){
        Point p = new Point(_growth);
        if(p == _location)
            p.y++;
       return p;
    }

    public Creature grow(){
        CarnivorousPlant newGrowth = null;

        if(canSpawn()){
            newGrowth = new CarnivorousPlant();
            newGrowth.setLocation(getDirection());
            _readyToSpawn = false;
        }
        return newGrowth;
    }

    public void attack(Creature target){
        if(target instanceof Animal || target instanceof Zombie || target instanceof Wolf){
            target.takeDamage(10);
            _health++;
            _readyToSpawn = true;
            _growth = new Point(target.getLocation());
        }
    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right){
        if(above instanceof Animal || above instanceof Zombie || above instanceof Wolf){
            attack(above);
        }
        if(left instanceof Animal || left instanceof Zombie || left instanceof Wolf){
            attack(left);
        }
        if(below instanceof Animal || below instanceof Zombie || below instanceof Wolf){
            attack(below);
        }
        if(right instanceof Animal || right instanceof Zombie || right instanceof Wolf){
            attack(right);
        }
    }
}
