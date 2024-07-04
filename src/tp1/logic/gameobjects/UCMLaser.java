package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMLaser extends UCMWeapon {
	
	public UCMLaser(Game game, Position pos) {
		super(game);
		this.pos = pos;
		this.dir = Move.UP;
		this.damage = 1;
	}

	@Override
	protected String getSymbol() {
		return Messages.LASER_SYMBOL;
	}
}
