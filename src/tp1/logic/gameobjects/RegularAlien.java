package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class RegularAlien extends AlienShip {
	
	public RegularAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, alienManager);
		this.life = 2;
		this.pos = pos;
		this.points = 5;
	}
	
	protected RegularAlien() {
	}

	@Override
	protected String getSymbol() {
		return Messages.status(Messages.REGULAR_ALIEN_SYMBOL, life);
	}

	@Override
	protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
		return new RegularAlien(game, pos, am);
	}
}
