package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable,Aware,Aggressor {

    Random _rand;

    private Direction preferredDirection;

    public Wolf(){
        preferredDirection = initialDirection();
        _health = 1;
    }

    public Direction initialDirection(){
        _rand = new Random();
        Direction initialDirection = Direction.Left;
        // Choose a random direction to start
        switch(_rand.nextInt(4)) {
            case 0:
                initialDirection = Direction.Left;
                break;
            case 1:
                initialDirection = Direction.Up;
                break;
            case 2:
                initialDirection = Direction.Right;
                break;
            case 3:
                initialDirection = Direction.Down;
                break;
            default:
                break;
        }
        return initialDirection;
    }
    // interface implementations
    public void move() {

        // move according to the preferred direction.
        switch(preferredDirection) {
            case Left:
                _location.x--;
                break;
            case Up:
                _location.y++;
                break;
            case Right:
                _location.x++;
                break;
            case Down:
                _location.y--;
                break;
            default:
                break;
        }

    }

    public Boolean isAlive() {
        return _health > 0;
    }
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right){

    }
    public void attack(Creature target){
        //Attack only animals
        if(target instanceof Animal) {
            target.takeDamage(5);
        }
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }
}
