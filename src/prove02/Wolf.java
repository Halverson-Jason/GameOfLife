package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable,Aware,Aggressor {

    Random _rand;

    public Wolf(){
        _rand = new Random();
        _health = 1;
    }
    // interface implementations
    public void move() {

        _location.x++;

    }

    public Boolean isAlive() {
        return _health > 0;
    }
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right){

    }
    public void attack(Creature target){

    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }
}
