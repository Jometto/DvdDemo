import java.awt.*;

public class Game {

     private Display display;
     private Rectangle rectangle;
     private int xDirection = 1;
     private int yDirection = 1;

     public Game(int width, int height) {
         display = new Display(width, height);
         rectangle = new Rectangle(0,0,50,50);
     }

     public Rectangle getRectangle() {
          return rectangle;
     }

     public void update(){
          rectangle.setLocation(
                  (int) rectangle.getX() + 1 * xDirection,
                  (int) rectangle.getY() + 1 * yDirection
          );

          if ((int) rectangle.getX() > display.getWidth() - 50 - 16
          || (int) rectangle.getX() < 0){
               xDirection *= -1;
          }
          if ((int) rectangle.getY() > display.getHeight() - 50 - 39
          || (int) rectangle.getY() < 0){
               yDirection *= -1;
          }
     }

     public void render(){
          display.render(this);
     }
}
