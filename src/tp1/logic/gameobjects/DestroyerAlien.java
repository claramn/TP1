package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {
	private boolean canShoot;

	protected DestroyerAlien() {
	}

	public DestroyerAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, alienManager);
		this.life = 1;
		this.pos = pos;
		this.points = 10;
		this.canShoot = true;
	}
	
	@Override
	protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
		return new DestroyerAlien(game, pos, am);
	}

	@Override
	protected String getSymbol() {
		return Messages.status(Messages.DESTROYER_ALIEN_SYMBOL, life);
	}

	protected void bombEnable() {
		canShoot = true;
	}
	
	@Override
	public void computerAction() {
		if (canShoot && canGenerateRandomBomb()) {
			game.addObject(new Bomb(game, pos, this));
			canShoot = false;
		}
	}

	protected boolean canGenerateRandomBomb() {
		return game.canGenerateRandomObject(game.getLevel().getShootFrecuency());
	}
}
