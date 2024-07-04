package tp1.logic.gameobjects;

import tp1.logic.Game;

public abstract class EnemyWeapon extends Weapon {

	public EnemyWeapon(Game game) {
		super(game);
	}
	
	@Override
	public boolean performAttack(GameItem other) {
		boolean result = other.receiveAttack(this);
		if (result) {
			die();
			onDelete();
		}
		return result;
	}
	
	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		boolean result = weapon.isOnPosition(pos) && isAlive();
		if (result) {
			die();
			onDelete();
		}
		return result;
	}
}
