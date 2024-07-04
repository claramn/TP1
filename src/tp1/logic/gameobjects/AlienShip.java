package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class AlienShip extends EnemyShip {
	private int ciclos;
	private int velocidad;
	private AlienManager manager;

	protected AlienShip() {
	}

	public AlienShip(GameWorld game, AlienManager manager) {
		super(game);
		this.manager = manager;
		this.ciclos = manager.getCiclos();
		this.velocidad = manager.getCiclos();
	}

	protected abstract AlienShip copy(GameWorld game, Position pos, AlienManager am);

	@Override
	public void automaticMove() {
		if (ciclos == 0) {
			performMovement(dir);
			manager.aliensToDescend();
			if (isOnBorder()) {
				manager.shipOnBorder();
			}
			ciclos = velocidad;
		} else if (manager.canDescend()) {
			manager.descending();
			aliensDown();
			game.gameCheckAttacks(this);
			if (isOnFinal()) {
				manager.alienFinal();
			}
		} else
			ciclos--;
	}

	private void aliensDown() {
		performMovement(Move.DOWN);
		dir = dir.oppositeDir();
	}

	private boolean isOnBorder() {
		return pos.isBorder();
	}

	private boolean isOnFinal() {
		return pos.finTablero();
	}

	protected void removeAlien() {
		manager.removeAlien();
	}

	@Override
	public void onDelete() {
		removeAlien();
		game.receivePoints(points);
	}
}