import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject{

    private int xDirection = 1;
    private int yDirection = 1;
    private int displayWidth;
    private int displayHeight;
    private Obstacle obstacle;

    public Square(int displayWidth, int displayHeight,Position position ,Obstacle obstacle){
        this.displayWidth = displayWidth;
        this.displayHeight = displayHeight;
        this.position = position;
        this.obstacle = obstacle;
    }


    @Override
    public void update() {
        position = new Position(position.getX()+3 * xDirection, position.getY()+3 * yDirection);

        if (position.getX() > displayWidth - size.getWidth() || position.getX() < 0){
            xDirection *= -1;
        }
        if (position.getY() > displayHeight - size.getHeight() || position.getY() < 0){
            yDirection *= -1;
        }

        // Collision with the obstacles

        if (position.getX() + size.getWidth() > obstacle.getPosition().getX()
                && position.getX() < obstacle.getPosition().getX()
           || position.getX() < obstacle.getPosition().getX() + obstacle.getSize().getWidth()
                && position.getX() + size.getWidth() > obstacle.getPosition().getX() + obstacle.size.getWidth())
        {
            xDirection *= -1;
        }
    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.RED);
        graphics.fillRect(0,0,size.getWidth(), size.getHeight());

        graphics.dispose();

        return image;
    }
}
