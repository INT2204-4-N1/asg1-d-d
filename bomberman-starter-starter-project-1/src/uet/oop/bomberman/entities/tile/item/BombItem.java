package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.GameSound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Timer;
import java.util.TimerTask;

public class BombItem extends Item {

	public BombItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
		if(e instanceof Bomber) {
			((Bomber) e).addItem(this);
			remove();
			GameSound.getIstance().getAudio(GameSound.ITEM).play();
			return true;
		}
		return false;
	}

	@Override
	public void setValues() {
		_active = true;
		Game.addBombRate(1);
		test ds = new test();
		Timer timer = new Timer();
		timer.schedule(ds,15000);
	}
	class test extends TimerTask{
		@Override
		public void run() {
			Game.addBombRate(-1);
			_active = false;
		}
	}
}
