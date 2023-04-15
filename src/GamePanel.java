import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Snake snake;
    private Food food;
    private int score = 0;

    public void setScore(int score) {
        this.score = score;
    }

    public GamePanel(){
        snake = new Snake();
        food = new Food();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Point p:snake.getBody()){
            g.setColor(Color.GREEN);
            g.fillRect(p.x*10,p.y*10, 10, 10);
        }
        g.setColor(Color.RED);
        g.fillRect(food.getLocation().x, food.getLocation().y, 10, 10);
    }

}
