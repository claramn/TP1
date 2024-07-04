package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ufo extends EnemyShip {
	private boolean exists;

	public Ufo(Game game) {
		super(game);
		this.pos = new Position(0, Game.DIM_X);
		this.points = 25;
		this.life = 1;
		this.exists = false;
	}

	@Override
	protected String getSymbol() {
		return Messages.status(Messages.UFO_SYMBOL, life);
	}

	@Override
	public void automaticMove() {
		if (exists) {
			performMovement(dir);
			if (isOut())
				onDelete();
		}
	}

	private void addUfo() {
		game.addObject(new Ufo(game));
	}

	@Override
	public void computerAction() {
		if (!exists && canGenerateRandomUfo()) {
			exists = true;
		}
	}

	private boolean canGenerateRandomUfo() {
		return game.canGenerateRandomObject(game.getLevel().getUfoFrequency());
	}

	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		boolean result = weapon.isOnPosition(pos) && isAlive();
		if (result) {
			onDelete();
			game.receivePoints(points);
			game.shockwaveOn();
		}
		return result;
	}

	@Override
	public void onDelete() {
		exists = false;
		die();
		addUfo();
	}
}
