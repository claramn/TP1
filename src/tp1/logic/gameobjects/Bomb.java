package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Bomb extends EnemyWeapon {
	private DestroyerAlien destroyer;

	public Bomb(Game game, Position p, DestroyerAlien d) {
		super(game);
		this.destroyer = d;
		this.life = 1;
		this.damage = 1;
		this.dir = Move.DOWN;
		this.pos = p;
	}

	@Override
	public String getSymbol() {
		return Messages.BOMB_SYMBOL;
	}

	@Override
	public void onDelete() {
		super.onDelete();
		if(!isAlive()) destroyer.bombEnable();
	}

	@Override
	public void automaticMove() {
		if (!destroyer.isAlive()) {
			die();
			onDelete();
		}
		super.automaticMove();
	}
}
