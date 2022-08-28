import javax.swing.*;
import java.awt.*;

public class BrickBreakerRunner {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //creates new instance of gameplay
        GamePlay gamePlay = new GamePlay();
        frame.setBounds(10,10,700,600);
        frame.setTitle("Brick Breaker");
        frame.setResizable(false);
//        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds my gameplay method to frame(displays my gameplay and Invokes the class)
        frame.add(gamePlay);
        //had to set visibility to true after frame.add() in order to get graphics to show up
        //instead of calling the setVisibility method prior to the add method
        frame.setVisible(true);

    }

}
