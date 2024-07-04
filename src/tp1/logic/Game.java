package tp1.logic;

import java.util.Random;

import tp1.control.InitialConfiguration;
import tp1.exceptions.InitializationException;
import tp1.exceptions.LaserInFlightException;
import tp1.exceptions.NoShockWaveException;
import tp1.exceptions.NotAllowedMoveException;
import tp1.exceptions.NotEnoughtPointsException;
import tp1.exceptions.OffWorldException;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.UCMShip;
import tp1.view.Messages;

public class Game implements GameStatus, GameModel, GameWorld {

	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;

	private GameObjectContainer container;
	private UCMShip player;
	private AlienManager alienManager;
	private int currentCycle;
	private Level level;
	private Random rand;
	private int points;
	private int life;
	private long seed;
	private InitialConfiguration conf;
	private boolean reset;
	private boolean exit;

	public Game(Level level, long seed) {
		this.level = level;
		this.seed = seed;
		this.conf = InitialConfiguration.NONE;
		this.reset = false;
		this.exit = false;
		try {
			initGame();
		} catch (InitializationException e) {
			e.printStackTrace();
		}
	}

	private void initGame() throws InitializationException {
		rand = new Random(seed);
		currentCycle = 0;
		points = 0;
		life = 3;

		alienManager = new AlienManager(this, level);
		player = new UCMShip(this);
		container = alienManager.initialize(conf);
		container.add(player);
	}

	public void update() {
		if (!reset) {
			this.currentCycle++;
			this.container.computerActions();
			this.container.automaticMoves();
			this.container.removeDead();
		} else {
			reset = false;
		}
	}

	public void getDamage() {
		life--;
	}

	@Override
	public String positionToString(int col, int row) {
		Position p = new Position(row, col);
		return container.toString(p);
	}

	@Override
	public String stateToString() {
		String shockwaveName = player.shockwaveIsOn() ? "ON" : "OFF";
		return "Life: " + this.life + "\n" + "Points: " + this.points + "\n" + "ShockWave: " + shockwaveName + "\n";
	}

	@Override
	public boolean playerWin() {
		return getRemainingAliens() == 0;
	}

	@Override
	public boolean aliensWin() {
		return life == 0 || alienManager.isOnFinal();
	}

	@Override
	public int getCycle() {
		return this.currentCycle;
	}

	@Override
	public int getRemainingAliens() {
		return alienManager.remainingAliens();
	}

	@Override
	public Level getLevel() {
		return this.level;
	}

	@Override
	public void moveUcm(Move move) throws NotAllowedMoveException, OffWorldException {
		player.correctDirection(move.name());
		player.moverUcm(move);
	}

	@Override
	public void shootLaser() throws LaserInFlightException {
		player.enableLaser();
	}

	@Override
	public void shootSuperLaser() throws LaserInFlightException, NotEnoughtPointsException {
		boolean pointsEnough = points > 0;

		if (pointsEnough)
			player.enableSuperLaser();
		else
			throw new NotEnoughtPointsException(String.format(Messages.NOT_ENOUGH_POINTS_ERROR, points, 5));
	}

	@Override
	public void reset(InitialConfiguration conf) throws InitializationException {
		this.reset = true;
		this.conf = conf;
		this.initGame();
	}

	@Override
	public void exit() {
		exit = true;
	}

	@Override
	public void shockwave() throws NoShockWaveException {
		player.shootShockwave();
	}

	@Override
	public boolean isFinished() {
		return playerWin() || aliensWin() || exit;
	}

	@Override
	public void addObject(GameObject object) {
		this.container.add(object);
	}

	@Override
	public void removeObject(GameObject object) {
		this.container.remove(object);
	}

	@Override
	public void receivePoints(int points) {
		this.points += points;
	}

	@Override
	public boolean canGenerateRandomObject(double frecuencia) {
		return rand.nextDouble() < frecuencia;
	}

	@Override
	public void gameAttacks(GameItem item) {
		container.performAttacks(item);
	}

	@Override
	public void gameCheckAttacks(GameItem item) {
		container.checkAttacks(item);
	}

	public boolean shockwaveState() {
		return player.shockwaveIsOn();
	}

	public void shockwaveOff() {
		player.shockwaveOff();
	}

	public void shockwaveOn() {
		player.shockwaveOn();
	}

	public void shootLaserAgain() {
		player.canShoot();
	}
}
