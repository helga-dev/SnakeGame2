import java.awt.*;
import java.util.LinkedList;

public class Snake {

    private LinkedList<Point> body;
    private int direction = 2;

    public Snake(){
        body = new LinkedList<>();
        body.add(new Point(10, 10));
        body.add(new Point(9,10));
        body.add(new Point(8,10));
        direction = 2;
    }

    public void move() {
        Point head = new Point(body.getFirst());
        switch (direction) {
            case 0:
                head.x--;
                break;
            case 1:
                head.y--;
                break;
            case 2:
                head.x++;
                break;
            case 3:
                head.y++;
                break;
        }
        body.addFirst(head);
        body.removeLast();
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public LinkedList<Point> getBody() {
        return body;
    }
    public boolean checkCollisions(){
        Point head = body.getFirst();
        for(Point p: body.subList(1, body.size())){
            if(head.equals(p)){
                return true;
            }
        }
        return false;
    }

    public boolean checkFoodCollision (Food food){
        return body.getFirst().equals(food.getLocation());
    }

    public void grow(){
        Point tail = body.getLast();
        Point newTail = new Point(tail.x, tail.y);
        body.addLast(newTail);
    }
}
