package tp1.logic.gameobjects;

import tp1.logic.Game;

public abstract class UCMWeapon extends Weapon {
	
	public UCMWeapon(Game game) {
		super(game);
		this.life = 1;
	}

	@Override
	public boolean performAttack(GameItem other) {
		boolean result = other.isOnPosition(pos) && other.receiveAttack(this);
		if (result) {
			die();
			onDelete();
		}
		return result;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		boolean result = weapon.isOnPosition(pos) && isAlive() && weapon.isAlive();
		if (result) {
			die();
			onDelete();
		}
		return result;
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		if (!isAlive()) game.shootLaserAgain();
	}
}
