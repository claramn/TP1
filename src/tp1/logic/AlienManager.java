package tp1.logic;

import tp1.control.InitialConfiguration;
import tp1.exceptions.InitializationException;
import tp1.exceptions.OffWorldException;
import tp1.logic.gameobjects.AlienShip;
import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.ShipFactory;
import tp1.logic.gameobjects.Ufo;
import tp1.view.Messages;

public class AlienManager {

	private Game game;
	private Level level;
	private int remainingAliens;
	private int aliensDescend;
	private boolean down;
	private boolean aliensFinalRow;

	public AlienManager(Game game, Level level) {
		this.game = game;
		this.level = level;
		remainingAliens = level.getRegularAliens() + level.getDestroyerAliens();
		aliensDescend = remainingAliens;
		down = false;
		aliensFinalRow = false;
	}

	public GameObjectContainer initialize(InitialConfiguration conf) throws InitializationException {
		GameObjectContainer container = new GameObjectContainer();

		if (conf == InitialConfiguration.NONE) {
			initializeRegularAliens(container);
			initializeDestroyerAliens(container);
		} else {
			costumedInitialization(container, conf);
		}
		initializeOvni(container);
		return container;
	}

	private void initializeOvni(GameObjectContainer container) {
		container.add(new Ufo(game));
	}

	private void initializeRegularAliens(GameObjectContainer container) {
		int numAliens = level.getRegularAliens();
		int i = 0;
		int j = 0;

		while (j < level.getRows()) {
			i = 0;
			while (i < numAliens / level.getRows()) {
				int col = i + 2;
				int row = j + 1;
				Position pos = new Position(row, col);
				container.add(new RegularAlien(game, pos, this));
				i++;
			}
			j++;
		}
	}

	private void initializeDestroyerAliens(GameObjectContainer container) {
		int numDestroyerAliens = level.getDestroyerAliens();
		int numAliens = level.getRegularAliens();
		int i = 0;

		while (i < numDestroyerAliens) {
			int col = ((numAliens / level.getRows()) / 2) + i;
			if (numDestroyerAliens < 4) {
				col++;
			}
			int row = level.getRows() + 1;
			Position pos = new Position(row, col);
			container.add(new DestroyerAlien(game, pos, this));
			i++;
		}
	}

	private void costumedInitialization(GameObjectContainer container, InitialConfiguration conf)
			throws InitializationException {
		int aliens = 0;
		for (String shipDescription : conf.getShipDescription()) {
			String[] words = shipDescription.trim().split("\\s+");
			try {
				Position pos = new Position(Integer.valueOf(words[2]), Integer.valueOf(words[1]));
				pos.alienPosCorrecta();
				AlienShip ship = ShipFactory.spawnAlienShip(words[0], game, pos, this);
				if (ship == null)
					throw new InitializationException(String.format(Messages.UNKNOWN_SHIP, words[0]));
				container.add(ship);
				aliens++;
			} catch (IndexOutOfBoundsException iob) {
				throw new InitializationException(String.format(Messages.INCORRECT_ENTRY, shipDescription));
			} catch (NumberFormatException nfe) {
				throw new InitializationException(String.format(Messages.INVALID_POSITION, words[1], words[2]));
			} catch (OffWorldException ofe) {
				throw new InitializationException(ofe.getMessage());
			}
		}
		remainingAliens = aliens;
		aliensDescend = remainingAliens;
	}

	public int getCiclos() {
		return level.getSpeed();
	}

	public int remainingAliens() {
		return remainingAliens;
	}

	public void removeAlien() {
		remainingAliens--;
	}

	public void shipOnBorder() {
		down = true;
	}

	public boolean canDescend() {
		return down;
	}

	public void aliensToDescend() {
		aliensDescend = remainingAliens;
	}

	public void descending() { // por cada alien que va descendiendo
		if (aliensDescend > remainingAliens) { // se resta 1 a los que quedan por
			aliensDescend = remainingAliens; // bajar hasta que hayan bajado todos
		}
		aliensDescend--;
		if (aliensDescend == 0) {
			down = false;
		}
	}

	public void alienFinal() {
		aliensFinalRow = true;
	}

	public boolean isOnFinal() {
		return aliensFinalRow;
	}
}