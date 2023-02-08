import java.awt.*;
import java.awt.image.BufferedImage;
import Cars.Car;

public class Actor {
    private BufferedImage image;
    final Car car;

    private final Point point;

    public Actor(Car car, Point point) {
        this.car = car;
        this.point = point;
    }
    public Actor(Car car){
        this.car = car;
        this.point = new Point();
    }
    public BufferedImage getImage(){
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Point getPoint(){
        return point;
    }

    public void moveit(int x, int y){
        point.x = x;
        point.y = y;
    }
}
