package tp1.logic.gameobjects;

import tp1.logic.Game;

public abstract class Weapon extends GameObject {
	
	protected int damage;

	public Weapon(Game game) {
		super(game);
	}

	@Override
	public void onDelete() {
		if (isOut()) {
			die();
		}
	}
	
	@Override
	public void automaticMove() {
		performMovement(dir);
		if (isAlive()) {
			game.gameCheckAttacks(this);
			if (isAlive())
			game.gameAttacks(this);
		}
		onDelete();
	}

	@Override
	protected int getDamage() {
		return damage;
	}
}
