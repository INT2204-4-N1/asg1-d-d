package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Timer;
import java.util.TimerTask;

public class FlameItem extends Item {

	public FlameItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public void setValues() {
		_active = true;
		Game.addBombRadius(1);
		test ds = new test();
		Timer timer = new Timer();
		timer.schedule(ds,25000);
	}
	class test extends TimerTask {
		@Override
		public void run() {
			Game.addBombRadius(-1);
		}
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
		if(e instanceof Bomber) {
			((Bomber) e).addItem(this);
			remove();
			return true;
		}
		return false;
	}


}
