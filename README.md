# GameOfLife

This is an adaptation to the cellular automation program called The Game of Life.
This is specifically built to use Java interfaces to implement a modified version of this simulator.
<ul>
  <li>The green circles are "Plants" a subclass of Creature that does nothing but provide food for other creatures. Instances of the Plant class are represented in the game by green circles. Plants start with one health point.</li>
  <li>The purple squares are "Animals" a subclass of Creature that implements the Movable and Aggressor interfaces. Instances of the Animal class are represented in the game by red squares. They move in random directions and if they land on a plant, they will eat it. Animal instances start with one health point and gain a health point for every plant they eat. Animals inflict one point of damage when they attack.</li>
  <li>The blue squares are "Zombies" a subclass of Creature and implements the Movable and Aggressor interfaces.
Instances of the Zombie class always move from left to right. Zombies attack any creature they land on, if it isn't an instance of the Plant class. They inflict 10 points of damage when they attack. Ten zombie instances are created at the beginning of the game.</li>
  <li>The grey squares are "Wolves" a subclass of Creature and implements the Movable, Spawnable and Aggressor interfaces. Wolves start out by moving in a random direction, searching for something to eat. If a wolf senses an animal nearby, it will decide to move in that direction as soon as possible. If it lands on an animal, it will eat it. Wolves will not eat or purposefully move towards zombies or plants. After eating an Animal the wolf will spawn a new wolf to the left of it.</li>
</ul>


