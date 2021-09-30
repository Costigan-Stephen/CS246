package prove02;

import java.awt.*;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {
    Point _location;
    int _health;

    public Zombie() {
        _health = 1;
    }

    public void move() {
        _location.x++;
    }

    public void attack(Creature target){
        if(target instanceof Animal) {
            target.takeDamage(10);
            _health++;
        }
    }
    /**
     * Gets the location of the creature in game coordinates.
     * @return The current location of the creature.
     */
    public Point getLocation() {
        return _location;
    }

    /**
     * Sets the location of the creature in game coordinates.
     * @param newValue The new location of the creature.
     */
    public void setLocation(Point newValue) {
        _location = newValue;
    }

    /**
     * Allows the creature to take damage if something comes by to attack it.
     * @param damage The amount of damage inflicted by the attacker
     */
    public void takeDamage(int damage) {
        _health -= damage;
    }

    // Since the following methods are marked as abstract, subclasses
    // must implement them.

    /**
     * Gets the {@link Shape} used to represent this creature.
     * @return The shape drawn for this creature.
     */
    public Shape getShape(){ return Shape.Square; }

    /**
     * Gets the {@link java.awt.Color} used to represent this creature.
     * @return The color drawn for this creature.
     */
    public Color getColor( ) {
        return new Color(3, 3, 252); // BLUE
    }

    /**
     * Is the creature alive?
     * @return A boolean indicating if the creature is alive.
     */
    public Boolean isAlive(){
        return _health > 0;
    }
}
