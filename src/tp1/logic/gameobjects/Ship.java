package tp1.logic.gameobjects;

import tp1.logic.GameWorld;

public abstract class Ship extends GameObject {

	public Ship(GameWorld game) {
		super(game);
	}

	protected Ship() {
	}

	@Override
	public void automaticMove() {
	}
	
	@Override
	protected int getDamage() {
		return 0;
	}
	
	@Override
	public void onDelete() {	
	}
}
