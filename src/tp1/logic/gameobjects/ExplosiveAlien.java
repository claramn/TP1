package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExplosiveAlien extends AlienShip {
	private int damage;

	public ExplosiveAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, alienManager);
		this.life = 2;
		this.pos = pos;
		this.points = 12;
		this.damage = 1;
	}

	protected ExplosiveAlien() {
	}

	@Override
	protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
		return new ExplosiveAlien(game, pos, am);
	}

	@Override
	protected String getSymbol() {
		return Messages.status(Messages.EXPLOSIVE_ALIEN_SYMBOL, life);
	}
	
	@Override
	public boolean performAttack(GameItem other) {
		return other.receiveAttack(this);
	}
	
	
	private void explode() {
		game.gameAttacks(this);
	}
	
	@Override
	public void onDelete() {
		removeAlien();
		game.receivePoints(points);
		explode();
	}
	
	@Override
	protected int getDamage() {
		return damage;
	}
	
}
