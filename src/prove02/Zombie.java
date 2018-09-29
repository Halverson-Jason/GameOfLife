package prove02;

import java.awt.*;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {
    Random _rand;

    public Zombie(){
        _rand = new Random();
        _health = 1;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 255);
    }

    /**
     * If the creature we've encountered is a plant, we'll eat it. Otherwise, we ignore it.
     * @param target The {@link Creature} we've encountered.
     */
    public void attack(Creature target) {
        // Animals only eat plants. Give the plant 1 damage
        // and increase our health by one.
        if(!(target instanceof Plant) && (target != null)) {
            target.takeDamage(10);
        }
    }

    /**
     * Move the animal in a random direction. //TODO: Change for Zombie
     */
    public void move() {

        _location.x++;

    }

    public Boolean isAlive() {
        return _health > 0;
    }
}
