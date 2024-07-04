package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public class Shockwave extends UCMWeapon {

	public Shockwave(Game game) {
		super(game);
		this.damage = 1;
	}

	@Override
	public boolean performAttack(GameItem other) {
		return game.shockwaveState() && other.receiveAttack(this);
	}

	@Override
	public void automaticMove() {
		game.gameAttacks(this);
		die();
		onDelete();
	}

	@Override
	public boolean isOnPosition(Position pos) {
		return false;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		return false;
	}
	
	@Override
	protected String getSymbol() {
		return null;
	}
	
	@Override
	public void onDelete() {
		game.shockwaveOff();
	}
}
