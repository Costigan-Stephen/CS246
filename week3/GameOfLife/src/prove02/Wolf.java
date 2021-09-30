package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {
    Point _location;
    int _health;
    Random _rand;
    int _direction;
    boolean _readyToSpawn;

    public Wolf() {
        _direction = 0;
        _rand = new Random();
        _health = 1;
        _readyToSpawn = false;
    }

    public void attack(Creature target){
        if(target instanceof Animal) {
            target.takeDamage(10);
            _health++;
            _readyToSpawn = true;
        }
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
        return new Color(150, 150, 150); // GRAY
    }

    /**
     * Is the creature alive?
     * @return A boolean indicating if the creature is alive.
     */
    public Boolean isAlive(){
        return _health > 0;
    }

    public Boolean canSpawn(){
        return _readyToSpawn;
    }

    public Creature spawnNewCreature(){
        Wolf babyWolf = null;
        if(canSpawn()){
            babyWolf = new Wolf();
            babyWolf.setLocation(new Point(_location.x, _location.y -1));
            _readyToSpawn = false;
        }
        return babyWolf;
    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right){
        if(above instanceof Animal){
            _direction = 1;
        } else if(left instanceof Animal){
            _direction = 2;
        } else if(below instanceof Animal) {
            _direction = 3;
        } else if(right instanceof Animal){
            _direction = 4;
        } else {
            _direction = 0;
        }
    }

    public void move() {

        // Choose a random direction each time move() is called.
        if(_direction > 0){
            switch(_direction) {
                case 1:
                    _location.x++;
                    break;
                case 2:
                    _location.x--;
                    break;
                case 3:
                    _location.y++;
                    break;
                case 4:
                    _location.y--;
                    break;
                default:
                    break;
            }
        } else {
            switch(_rand.nextInt(4)) {
                case 0:
                    _location.x++;
                    break;
                case 1:
                    _location.x--;
                    break;
                case 2:
                    _location.y++;
                    break;
                case 3:
                    _location.y--;
                    break;
                default:
                    break;
            }
        }
    }
}
