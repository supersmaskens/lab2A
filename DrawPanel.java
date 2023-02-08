import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    ArrayList<Actor> actors;
    // To keep track of a singel cars position

    // TODO: Make this genereal for all cars
    void moveit(Actor actor, int x, int y){
        actor.getPoint().x = x;
        actor.getPoint().y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

    }
    public void setImages() {
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            actors.get(0).setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            actors.get(1).setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            actors.get(2).setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex)        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Actor actor : actors) {
            g.drawImage(actor.getImage(), actor.getPoint().x, actor.getPoint().y, null); // see javadoc for more info on the parameters
        }
    }
}
