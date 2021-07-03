import java.awt.*;

public class Game {

     private Display display;
     private Rectangle rectangle;
     private int xDirection = 1;
     private int yDirection = 1;

     public Game(int width, int height) {
         display = new Display(width, height);
         rectangle = new Rectangle(0,0,100,80);
     }

     public Rectangle getRectangle() {
          return rectangle;
     }

     public void update(){
          rectangle.setLocation(
                  (int) rectangle.getX() + 3 * xDirection,
                  (int) rectangle.getY() + 3 * yDirection
          );

          if ((int) rectangle.getX() > display.getWidth() - (int) rectangle.getWidth() - 16
          || (int) rectangle.getX() < 0){
               xDirection *= -1;
          }
          if ((int) rectangle.getY() > display.getHeight() - (int) rectangle.getHeight() - 39
          || (int) rectangle.getY() < 0){
               yDirection *= -1;
          }
     }

     public void render(){
          display.render(this);
     }
}
