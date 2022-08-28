import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;

    private int totalBricks = 21;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

//    allows us to call mapGenerator
    private MapGenerator map;

    public GamePlay(){
        //generates/displays map
        map = new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){

        //bg?
        g.setColor(Color.white);
        g.fillRect(1,1,692,592);

        map.draw((Graphics2D) g);

        //container?
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);

        //pedal
        g.setColor(Color.blue);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.green);
        g.fillOval(ballposX, ballposY, 20, 20);
        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        timer.start();

        if(play){

        //Ball - Pedal interaction
            if(new Rectangle(ballposX, ballposY, 20, 30).intersects(new Rectangle(playerX, 550, 100, 8))){
                ballYdir = -ballYdir;
            };

            //makes ball bounce back
            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX < 0){
                ballXdir = -ballXdir;
            }
            if(ballposY < 0){
                ballYdir = -ballYdir;
            }
            if(ballposX > 670){
                ballXdir = -ballXdir;
            }
        }
        //will repaint window
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //will move pedal right or left based on event listener
        //checks if key event is clicking right arrow?
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){
                //if player tries tomove past 600
                //it will set position to 600 to avoid pedal going out fo bounds.
                playerX = 600;
            }else{
                //method we create to move pedal to right
                moveRight();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX < 10 ){
                playerX = 10;
            }else{
                moveLeft();
            }
        }
    }

    public void moveRight(){

        play = true;
        playerX += 20;
    }

    public void moveLeft(){

        play = true;
        playerX -= 20;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
