package uet.boom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {
    private final int Offset = 30;
    private final int space = 17;
    private final int left = 1;
    private final int right = 2;
    private final int top = 3;
    private final int bot = 4;
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
    private Timer timer;
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
        addKeyListener(new TAdapter());
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
       g.setColor(new Color(255,0,255));
       // g.setColor(new Color(0,128,0));
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

    private boolean checkMove(Actor actor , int type){
        switch (type){
            case left:
                for(int i=0;i<walls.size();i++) {
                    Wall wall = walls.get(i);

               for(int j=0;j<bricks.size();j++) {
                    Brick brick = bricks.get(j);
                    if (actor.isLeft(wall) || actor.isLeft(brick))
                    {
                        return true;
                    }
                }

                }

                return false;
            case right:
                for(int i=0;i<walls.size();i++){
                    Wall wall = walls.get(i);

                    for(int j=0;j<bricks.size();j++) {
                        Brick brick = bricks.get(j);
                        if (actor.isRight(wall) || actor.isRight(brick))
                        {
                            return true;
                        }
                    }
                }
                return false;
            case top:
                for(int i=0;i<walls.size();i++){
                    Wall wall = walls.get(i);

                    for(int j=0;j<bricks.size();j++) {
                        Brick brick = bricks.get(j);
                        if (actor.isTop(wall) || actor.isTop(brick))
                        {
                            return true;
                        }
                    }
                }
                return false;
            case bot:
                for(int i=0;i<walls.size();i++){
                    Wall wall = walls.get(i);

                    for(int j=0;j<bricks.size();j++) {
                        Brick brick = bricks.get(j);
                        if (actor.isBot(wall) || actor.isBot(brick))
                        {
                            return true;
                        }
                    }
                }
                return false;
            default:
                break;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    if(checkMove(player , left)){
                        return;
                    }
                    player.move(-space , 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    if(checkMove(player , right)){
                        return;
                    }
                    player.move(space , 0);
                    break;
                case KeyEvent.VK_UP:
                    if(checkMove(player , top)){
                        return;
                    }
                    player.move(0 , -space);
                    break;
                case KeyEvent.VK_DOWN:
                    if(checkMove(player , bot)){
                        return;
                    }
                    player.move(0 , space);
                    break;
                default:
                    break;

            }
        }
    }


}
