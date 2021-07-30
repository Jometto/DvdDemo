import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject{

    private int xDirection = 1;
    private int yDirection = 1;
    private int displayWidth;
    private int displayHeight;
    private Obstacle[] obstacles;
    private boolean colHor = false;
    private boolean colVer = false;

    public Square(int displayWidth, int displayHeight, Position position , Obstacle[] obstacles){
        this.displayWidth = displayWidth;
        this.displayHeight = displayHeight;
        this.position = position;
        this.obstacles = obstacles;
    }

    public boolean isColVer(Obstacle obstacle){
        return(position.getY() + size.getHeight() > obstacle.getPosition().getY()
        && position.getY() < obstacle.getPosition().getY() + obstacle.getSize().getHeight());
    }
    private boolean isColHor(Obstacle obstacle) {
        return(position.getX() + size.getWidth() > obstacle.getPosition().getX()
        && position.getX() < obstacle.getPosition().getX() + obstacle.getSize().getWidth());
    }

    @Override
    public void update() {
        position = new Position(position.getX()+3 * xDirection, position.getY()+3 * yDirection);

        if (position.getX() > displayWidth - size.getWidth() || position.getX() < 0){
            xDirection *= -1;
        }
        if (position.getY() + size.getHeight() > displayHeight|| position.getY() < 0){
            yDirection *= -1;
        }

        for (int i = 0; i < obstacles.length; i++) {
            if (isColHor(obstacles[i])){
                if(position.getY() + size.getHeight() > obstacles[i].getPosition().getY()
                        && position.getY() + size.getHeight() - 4 < obstacles[i].getPosition().getY() && yDirection == 1){
                    yDirection *= -1;
                } else if(position.getY() < obstacles[i].getPosition().getY() + obstacles[i].getSize().getHeight()
                        && position.getY() + 4 > obstacles[i].getPosition().getY() + obstacles[i].getSize().getHeight() && yDirection == -1){
                    yDirection *= -1;
                }
            }
            if (isColVer(obstacles[i])) {
                if(position.getX() + size.getWidth() > obstacles[i].getPosition().getX() && isColVer(obstacles[i])
                        && position.getX() + size.getWidth() - 4 < obstacles[i].getPosition().getX() && xDirection == 1){
                    xDirection *= -1;
                }else if(position.getX() < obstacles[i].getPosition().getX() + obstacles[i].getSize().getWidth() && isColVer(obstacles[i])
                        && position.getX() + 4 > obstacles[i].getPosition().getX() + obstacles[i].getSize().getWidth() && xDirection == -1){
                    xDirection *= -1;
                }
            }
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
