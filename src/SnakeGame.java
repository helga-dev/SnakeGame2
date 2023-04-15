//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//
//import javax.swing.JFrame;
//
//public class SnakeGame {
//    private JFrame frame;
//    private GamePanel gamePanel;
//    private int direction;
//    private int score;
//
//    private Snake snake;
//    private Food food;
//
//    public SnakeGame() {
//        frame = new JFrame("Snake");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        gamePanel = new GamePanel();
//        frame.add(gamePanel);
//
//
//        frame.setTitle("Snake Game");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setPreferredSize(new Dimension(640, 480));
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                switch (e.getKeyCode()) {
//                    case KeyEvent.VK_UP:
//                        if (direction != 1) {
//                            direction = 3;
//                        }
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        if (direction != 3) {
//                            direction = 1;
//                        }
//                        break;
//                    case KeyEvent.VK_LEFT:
//                        if (direction != 2) {
//                            direction = 0;
//                        }
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        if (direction != 0) {
//                            direction = 2;
//                        }
//                        break;
//                }
//            }
//        });
//
//        // Создаем змейку и еду
//        snake = new Snake();
//        food = new Food();
//
//        // Задаем начальное направление змейки вправо
//        direction = 2;
//
//        gameLoop();
//    }
//
//    private void gameLoop() {
//
//        while (true) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            snake.setDirection(direction);
//            snake.move();
//
//            if (snake.checkCollisions()) {
//                gameOver();
//                break;
//            }
//
//            if (snake.checkFoodCollision(food)) {
//                food.respawn();
//                snake.grow();
//                score += 10;
//                gamePanel.setScore(score);
//            }
//
//            gamePanel.repaint();
//            gamePanel.revalidate();
//        }
//    }
//
//    private void gameOver() {
//
//        System.out.println("Game Over\nScore: " + score);
//    }
//
//    public static void main(String[] args) {
//        new SnakeGame();
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame {
    private JFrame frame;
    private GamePanel gamePanel;
    private int direction;
    private int score;

    private Snake snake;
    private Food food;

    public SnakeGame() {
        frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.setTitle("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640, 480));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != 1) {
                            direction = 3;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 3) {
                            direction = 1;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != 2) {
                            direction = 0;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 0) {
                            direction = 2;
                        }
                        break;
                }
            }
        });

        // Создаем змейку и еду
        snake = new Snake();
        food = new Food();

        // Задаем начальное направление змейки вправо
        direction = 2;

        gameLoop();
    }

    private void gameLoop() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            snake.setDirection(direction);
            snake.move();

            if (snake.checkCollisions()) {
                gameOver();
                break;
            }

            if (snake.checkFoodCollision(food)) {
                food.respawn();
                snake.grow();
                score += 10;
                gamePanel.setScore(score);
            }

            gamePanel.repaint();
            gamePanel.revalidate();
        }
    }

    private void gameOver() {
        System.out.println("Game Over\nScore: " + score);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
