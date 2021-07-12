import java.awt.*;
import java.awt.image.BufferedImage;

public class Obstacle extends GameObject{

    public Obstacle(Position position, Size size){
        this.position = position;
        this.size = size;
    }

    @Override
    public void update() {

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,size.getWidth(), size.getHeight());

        graphics.dispose();

        return image;
    }
}
