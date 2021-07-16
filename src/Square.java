import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject{

    private int xDirection = 1;
    private int yDirection = 1;
    private int displayWidth;
    private int displayHeight;
    private Obstacle obstacle;
    private boolean colHor = false;
    private boolean colVer = false;

    public Square(int displayWidth, int displayHeight,Position position ,Obstacle obstacle){
        this.displayWidth = displayWidth;
        this.displayHeight = displayHeight;
        this.position = position;
        this.obstacle = obstacle;
    }

    public boolean checkCollisionsHor(){
        if (colVer == true){
            xDirection *= -1;
            colHor = false;
            return true;
        }
        return false;
    }
    public boolean isColVer(){
        return(position.getY() + size.getHeight() > obstacle.getPosition().getY()
        && position.getY() < obstacle.getPosition().getY() + obstacle.getSize().getHeight());
    }
    private boolean isColHor() {
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

        // Collision with the obstacles

        /*if (position.getX() + size.getWidth() > obstacle.getPosition().getX()
                && position.getX() < obstacle.getPosition().getX()
                && xDirection == 1
           || position.getX() < obstacle.getPosition().getX() + obstacle.getSize().getWidth()
                && position.getX() + size.getWidth() > obstacle.getPosition().getX() + obstacle.size.getWidth()
                && xDirection == -1)
        {
            colHor = true;
            checkCollisionsHor();
        } else {
            colHor = false;
        }
        if (position.getY() + size.getHeight() > obstacle.getPosition().getY()
                && position.getY() < obstacle.getPosition().getY()
                && yDirection == 1
            || position.getY() < obstacle.getPosition().getY() + obstacle.getSize().getHeight()
                && position.getY() + size.getHeight() > obstacle.getPosition().getY() + obstacle.size.getHeight()
                && yDirection == -1)
        {
            colVer = true;
            checkCollisionsVer();
        } else {
            colVer = false;
        }
        */

        if (isColHor()){
            if(position.getY() + size.getHeight() > obstacle.getPosition().getY()
                    && position.getY() + size.getHeight() - 4 < obstacle.getPosition().getY() && yDirection == 1){
                yDirection *= -1;
            } else if(position.getY() < obstacle.getPosition().getY() + obstacle.getSize().getHeight()
                    && position.getY() + 4 > obstacle.getPosition().getY() + obstacle.getSize().getHeight() && yDirection == -1){
                yDirection *= -1;
            }
        }
        if (isColVer()) {
            if(position.getX() + size.getWidth() > obstacle.getPosition().getX() && isColVer()
                    && position.getX() + size.getWidth() - 4 < obstacle.getPosition().getX() && xDirection == 1){
                xDirection *= -1;
            }else if(position.getX() < obstacle.getPosition().getX() + obstacle.getSize().getWidth() && isColVer()
                    && position.getX() + 4 > obstacle.getPosition().getX() + obstacle.getSize().getWidth() && xDirection == -1){
                xDirection *= -1;
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
