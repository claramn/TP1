package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class GameObject implements GameItem {

	protected Position pos;
	protected int life;
	protected Game game;
	protected Move dir;

	protected GameObject() {
	}

	public GameObject(GameWorld game) {
		this.game = (Game) game;
	}

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}

	@Override
	public String toString() {
		return getSymbol();
	}

	protected abstract String getSymbol();

	protected abstract int getDamage();

	public abstract void onDelete();

	public abstract void automaticMove();

	public void computerAction() {
	};

	public void die() {
		life = 0;
	}
	
	@Override
	public void performMovement(Move dir) {
		pos = pos.sumaPos(dir);
	}

	@Override
	public boolean performAttack(GameItem other) {
		return false;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		return false;
	}

	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		return false;
	}

	@Override
	public boolean receiveAttack(ExplosiveAlien alien) {
		return false;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		return isAlive() && this.pos.equals(pos);
	}

	@Override
	public boolean isOut() {
		return !pos.posCorrecta();
	}

	@Override
	public boolean isAdyacent(Position pos) {
		return this.pos.isAdyacent(pos);
	}
}
