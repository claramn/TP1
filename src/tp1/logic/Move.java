package tp1.logic;

/**
 * Represents the allowed movements in the game
 *
 */
public enum Move {
	LEFT(-1, 0), LLEFT(-2, 0), RIGHT(1, 0), RRIGHT(2, 0), DOWN(0, 1), UP(0, -1), NONE(0, 0);

	private int x;
	private int y;

	private Move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Cambia direccion de las naves
	 * 
	 * @return
	 */

	public Move oppositeDir() {
		switch (this) {
		case LEFT:
			return RIGHT;
		case RIGHT:
			return LEFT;
		case UP:
			return DOWN;
		case DOWN:
			return UP;
		case LLEFT:
			return RRIGHT;
		case RRIGHT:
			return LLEFT;
		default:
			break;
		}
		return null;
	}
}