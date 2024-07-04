package tp1.logic;

import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;

public interface GameWorld {
	public void addObject(GameObject object);
	public void removeObject(GameObject object);
	public void receivePoints(int points);
	public boolean canGenerateRandomObject(double frecuencia);
	public void gameAttacks(GameItem item);
	public void gameCheckAttacks(GameItem item);
}
