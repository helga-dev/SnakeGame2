import java.awt.*;

public class Food {
    private Point location;

    public Food(){
        location = new Point();
        respawn();
    }

    public void respawn(){
        location.x = (int) (Math.random()*60)*10;
        location.y = (int) (Math.random()*40)*10;
    }

    public Point getLocation() {
        return location;
    }
}

