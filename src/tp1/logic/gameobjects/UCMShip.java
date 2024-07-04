package tp1.logic.gameobjects;

import tp1.exceptions.LaserInFlightException;
import tp1.exceptions.NoShockWaveException;
import tp1.exceptions.NotAllowedMoveException;
import tp1.exceptions.OffWorldException;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMShip extends Ship {
	private boolean canShoot;
	private boolean enableShockwave;

	public UCMShip(Game game) {
		super(game);
		this.life = 3;
		this.pos = new Position(Game.DIM_Y - 1, Game.DIM_X / 2);
		this.canShoot = true;
		this.enableShockwave = false;
	}

	@Override
	protected String getSymbol() {
		String message = null;
		if (life > 0)
			message = Messages.UCMSHIP_SYMBOL;
		else
			message = Messages.UCMSHIP_DEAD_SYMBOL;
		return message;
	}

	public boolean moverUcm(Move m) throws OffWorldException {
		Position nuevaPos = pos.shipMovement(m);
		boolean move = nuevaPos.posCorrecta();

		if (move)
			pos = nuevaPos;
		return move;
	}

	public void enableLaser() throws LaserInFlightException {
		if (canShoot) {
			game.addObject(new UCMLaser(game, pos));
			canShoot = false;
		} else {
			throw new LaserInFlightException(Messages.LASER_ALREADY_SHOT);
		}
	}

	public void canShoot() {
		canShoot = true;
	}

	public void enableSuperLaser() throws LaserInFlightException {
		if (canShoot) {
			game.addObject(new SuperLaser(game, pos));
			game.receivePoints(-5);
			canShoot = false;
		} else {
			throw new LaserInFlightException(Messages.LASER_ALREADY_SHOT);
		}
	}

	public void shootShockwave() throws NoShockWaveException {
		if (enableShockwave) {
			game.addObject(new Shockwave(game));
		}
		else {
			throw new NoShockWaveException(Messages.SHOCKWAVE_ERROR);
		}
	}

	public boolean shockwaveIsOn() {
		return enableShockwave;
	}

	public void shockwaveOn() {
		enableShockwave = true;
	}

	public void shockwaveOff() {
		enableShockwave = false;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		boolean result = weapon.isOnPosition(pos) && isAlive();
		if (result) {
			life -= weapon.getDamage();
			game.getDamage();
		}
		return result;
	}

	@Override
	public boolean isAlive() {
		return life >= 0;
	}
	
	public boolean correctDirection(String dir) throws NotAllowedMoveException {
		boolean direction = Messages.ALLOWED_UCMSHIP_MOVES.contains(dir.toLowerCase());
		if (!direction) {
			throw new NotAllowedMoveException(Messages.ALLOWED_MOVES_MESSAGE);
		}
		return direction;
	}

	public static String allowedMoves(String string) {
		return "left" + string + "lleft" + string + "right" + string + "rright";
	}
}
