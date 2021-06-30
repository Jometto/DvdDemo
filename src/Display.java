import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    //setting up the display of the app
    private Canvas canvas;

    public Display(int width, int height){
        setTitle("Bounce");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        pack(); //makes so it has the width and height of the children element

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null); //so it opens on the middle of the screen
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        graphics.dispose();
        bufferStrategy.show();
    }
}
