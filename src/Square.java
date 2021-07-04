import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject{

    private int xDirection = 1;
    private int yDirection = 1;
    private int displayWidth;
    private int displayHeight;

    public Square(int displayWidth, int displayHeight){
        this.displayWidth = displayWidth;
        this.displayHeight = displayHeight;
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
