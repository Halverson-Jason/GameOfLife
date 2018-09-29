package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable,Aware,Aggressor,Spawner {

    Random _rand;

    // if wolf is spawnable
    private boolean spawnable;
    public boolean getSpawnable(){return spawnable;}
    public void setSpawnable(boolean isSpawnable){spawnable = isSpawnable;}

    public Creature spawnNewCreature(Point newPoint){

        Wolf w = new Wolf();
        w.setLocation(newPoint);
        w.setSpawnable(false);
        return w;
    }

    private Direction preferredDirection;
    public void setPreferredDirection(Direction direction){
        preferredDirection = direction;
    }
    public Direction getPreferredDirection(){
        return preferredDirection;
    }
    public Wolf(){
        setPreferredDirection(initialDirection());
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
        Direction currentDirection = getPreferredDirection();
        // move according to the preferred direction.
        switch(currentDirection) {
            case Left:
                _location.x--;
                break;
            case Up:
                _location.y--;
                break;
            case Right:
                _location.x++;
                break;
            case Down:
                _location.y++;
                break;
            default:
                break;
        }

    }

    public Boolean isAlive() {
        return _health > 0;
    }
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right){
        // update preferred direction
        //Debugging code
            //System.out.println("Above:" + above +"below:" + below +"left:" + left +"Right:" + right);
        switch (getPreferredDirection()) {


            case Left: {
                if (left instanceof Animal)
                    break;
                else if (above instanceof Animal)
                    setPreferredDirection(Direction.Up);
                else if (right instanceof Animal)
                    setPreferredDirection(Direction.Right);
                else if (below instanceof Animal)
                    setPreferredDirection(Direction.Down);
            }
            break;
            case Up: {
                if (above instanceof Animal)
                    break;
                else if (right instanceof Animal)
                    setPreferredDirection(Direction.Right);
                else if (below instanceof Animal)
                    setPreferredDirection(Direction.Down);
                else if (left instanceof Animal)
                    setPreferredDirection(Direction.Left);
            }
            break;
            case Right: {
                if (right instanceof Animal)
                    break;
                else if (below instanceof Animal)
                    setPreferredDirection(Direction.Down);
                else if (left instanceof Animal)
                    setPreferredDirection(Direction.Left);
                else if (above instanceof Animal)
                    setPreferredDirection(Direction.Up);
            }
            break;
            case Down: {
                if (below instanceof Animal)
                    break;
                else if (left instanceof Animal)
                    setPreferredDirection(Direction.Left);
                else if (above instanceof Animal)
                    setPreferredDirection(Direction.Up);
                else if (right instanceof Animal)
                    setPreferredDirection(Direction.Right);
            }
            break;
            default:
                setPreferredDirection(initialDirection());
                break;
        }
    }
    public void attack(Creature target){
        //Attack only animals
        if(target instanceof Animal) {
            target.takeDamage(5);
            setSpawnable(true);
        }
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }
}
