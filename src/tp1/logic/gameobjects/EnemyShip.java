package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;

public abstract class EnemyShip extends Ship {
	protected int points;

	public EnemyShip(GameWorld game) {
		super(game);
		this.dir = Move.LEFT;
	}

	protected EnemyShip() {
	}

	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		boolean result = isAlive();
		if (result) {
			life -= weapon.getDamage();
			if (!isAlive())
				onDelete();
		}
		return result;
	}

	@Override
	public boolean receiveAttack(ExplosiveAlien explosiveAlien) {
		boolean result = !explosiveAlien.isAlive() && explosiveAlien.isAdyacent(pos) && isAlive();
		if (result) {
			life -= explosiveAlien.getDamage();
			if (!isAlive())
				onDelete();
		}
		return result;
	}

}
