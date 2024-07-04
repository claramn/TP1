package tp1.logic;

import tp1.exceptions.OffWorldException;
import tp1.view.Messages;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private final int col;
	private final int row;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Comprueba que un objeto este dentro del tablero
	 * 
	 * @return
	 */
	public boolean posCorrecta() {
		return (col >= 0 && col < Game.DIM_X && row < Game.DIM_Y && row >= 0);
	}

	public boolean alienPosCorrecta() throws OffWorldException {
		boolean correct = (col >= 0 && col < Game.DIM_X && row < Game.DIM_Y && row >= 0);
		if (!correct)
			throw new OffWorldException(
					String.format(Messages.OFF_WORLD_POSITION, String.format(Messages.POSITION, col, row)));
		return correct;
	}

	/**
	 * Comprueba que un objeto position sea igual a otro
	 */
	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		boolean condition = obj == null || getClass() != obj.getClass();
		if (condition) {
			return !condition;
		}
		return (this == obj) || (col == other.col && row == other.row);
	}

	public Position sumaPos(Move p) {
		return new Position(row + p.getY(), col + p.getX());
	}

	public Position shipMovement(Move p) throws OffWorldException {
		Position newPos = sumaPos(p);
		boolean movement = newPos.posCorrecta();
		if (movement) {
			return newPos;
		} else {
			throw new OffWorldException(
					String.format(Messages.OFF_WORLD_MESSAGE, p, String.format(Messages.POSITION, col, row)));
		}
	}

	public boolean isBorder() {
		return (col == 0 || col == 8);
	}

	public boolean finTablero() {
		return row == (Game.DIM_Y - 1);
	}

	public boolean isAdyacent(Position other) { // comprueba las posiciones en sus laterales o esquinas
		boolean horizontal = Math.abs(col - other.col) == 1 && row == other.row;
		boolean vertical = Math.abs(row - other.row) == 1 && col == other.col;
		boolean diagonal = Math.abs(col - other.col) == 1 && Math.abs(row - other.row) == 1;
		return horizontal || vertical || diagonal;
	}
}
