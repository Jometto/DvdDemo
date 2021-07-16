import java.util.ArrayList;
import java.util.List;

public class Game {

     private Display display;
     private List<GameObject> gameObjects;

     public Game(int width, int height) {
          display = new Display(width, height);

          Obstacle obstacle = new Obstacle(new Position(300,200),new Size(200,200));
          Square player = new Square(width,height,new Position(50,50), obstacle);
          Square player2 = new Square(width,height,new Position(700,50), obstacle);

          gameObjects = new ArrayList<>();
          gameObjects.add(player);
          gameObjects.add(player2);
          gameObjects.add(obstacle);
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
