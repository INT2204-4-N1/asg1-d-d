package uet.boom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    private final int Offset = 30;
    private final int space = 16;
    private ArrayList<Brick> bricks;
    private ArrayList<Balloon> balloons;
    private ArrayList<Boom> booms;
    private ArrayList<Wall> walls;
    private ArrayList<Oneal> oneals;
    private ArrayList<Grass> grasses;
    private Player player;
    private Flame_item flame_item;
    private int w; // chiều rộng
    private int h; // chiều cao
    private String level
            = "###############################\n"
            + "#p     ** *  1 * 2 *  * * *   #\n"
            + "# # # #*# # #*#*# # # #*#*#*# #\n"
            + "#  x*     ***  *  1   * 2 * * #\n"
            + "# # # # # #*# # #*#*# # # # #*#\n"
            + "#f         x **  *  *   1     #\n"
            + "# # # # # # # # # #*# #*# # # #\n"
            + "#*  *      *  *      *        #\n"
            + "# # # # #*# # # #*#*# # # # # #\n"
            + "#*    **  *       *           #\n"
            + "# #*# # # # # # #*# # # # # # #\n"
            + "#           *   *  *          #\n"
            + "###############################\n";

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public Board(){
        initBoard();
    }
    public void initBoard(){
        setFocusable(true);
        initWorld();
    }
    public void initWorld(){
        bricks = new ArrayList<>();
        walls = new ArrayList<>();
        oneals = new ArrayList<>();
        balloons = new ArrayList<>();
        grasses = new ArrayList<>();

        int x = Offset;
        int y = Offset;
        Wall wall;
        Brick brick;
        Oneal oneal;
        Balloon balloon;
        Grass grass;
        for(int i=0;i<level.length();i++){
            char item = level.charAt(i);
            switch (item){
                case '\n':
                    y += space;
                    if(this.w < x){
                        this.w = x;
                    }
                    x = Offset;
                    break;
                case '#':
                    wall = new Wall(x,y);
                    walls.add(wall);
                    x += space;
                    break;
                case '*':
                    brick = new Brick(x,y);
                    bricks.add(brick);
                    x += space;
                    break;
                case 'p':
                    player = new Player(x,y);
                    x += space;
                    break;
                case '1':
                    balloon = new Balloon(x,y);
                    balloons.add(balloon);
                    x += space;
                    break;
                case '2':
                    oneal = new Oneal(x,y);
                    oneals.add(oneal);
                    x += space;
                    break;
                case 'f':
                    flame_item = new Flame_item(x,y);
                    x += space;
                    break;
                case ' ':
//                    grass = new Grass(x,y);
//                    grasses.add(grass);
                    x += space;
                    break;
                default:
                    break;

            }
            h = y;
        }

    }
    private void buildWorld(Graphics g){
//        g.setColor(new Color(255,0,255));
        g.setColor(new Color(0,128,0));
        g.fillRect(0,0,this.getW(),this.getH());
        ArrayList<Actor> world = new ArrayList<>();
        world.addAll(bricks);
        world.addAll(walls);
        world.addAll(oneals);
        world.addAll(balloons);
        world.addAll(grasses);
        world.add(player);
        world.add(flame_item);
        for(int i=0;i<world.size();i++){
            Actor item = world.get(i);
            if(item instanceof Player || item instanceof Balloon || item instanceof Oneal){
                g.drawImage(item.getImage() , item.x() +2 , item.y()+2,this);
            }
            else {
                g.drawImage(item.getImage() , item.x()  , item.y(),this);
            }
        }

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        buildWorld(g);
    }


}
