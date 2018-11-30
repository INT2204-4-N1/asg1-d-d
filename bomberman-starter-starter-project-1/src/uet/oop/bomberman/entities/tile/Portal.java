package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Portal extends Tile {
    protected Board board;
	public Portal(int x, int y,Board ds, Sprite sprite) {
		super(x, y, sprite);
		board =ds;
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		if(e instanceof Bomber) {

			if (board.detectNoEnemies() == false)
				return false;

			if (e.getXTile() == getX() && e.getYTile() == getY()) {
				if (board.detectNoEnemies())
					board.endGame();
			}

			return true;
		}
		return false;
	}

}
