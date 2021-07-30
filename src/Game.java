import java.util.ArrayList;
import java.util.List;

public class Game {

     private Display display;
     private List<GameObject> gameObjects;

     public Game(int width, int height) {
          display = new Display(width, height);

          Obstacle[] obstacles;
          obstacles = new Obstacle[3];
          obstacles[0] = new Obstacle(new Position(400,550),new Size(400,50));
          obstacles[1] = new Obstacle(new Position(300,200),new Size(200,200));
          obstacles[2] = new Obstacle(new Position(0,0),new Size(500,50));

          Square player = new Square(width,height,new Position(50,50), obstacles);
          Square player2 = new Square(width,height,new Position(700,50), obstacles);

          gameObjects = new ArrayList<>();
          gameObjects.add(player);
          gameObjects.add(player2);
          gameObjects.add(obstacles[0]);
          gameObjects.add(obstacles[1]);
          gameObjects.add(obstacles[2]);
          //gameObjects.add(obstacle2);
     }

     public void update() {
          gameObjects.forEach(GameObject::update);
     }

     public void render() {
          display.render(this);
     }

     public List<GameObject> getGameObjects() {
          return gameObjects;
     }
}
