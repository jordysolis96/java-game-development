import java.awt.*;

public class MapGenerator {

    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col){
//        created our matrix
        map = new int[row][col];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = 1;
            }
        }

        brickWidth = 540/col;
        brickHeight = 150/row;
    }

    public void draw(Graphics2D g){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] > 0){
                    //creates bricks
                    g.setColor(Color.black);
                    //adds space from brick to wall
                    g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
                    //adds lines between brick
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.white);
                    g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);

                }
            }
            }
    }
}
