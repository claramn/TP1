package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {
	private List<GameObject> objects;

	public GameObjectContainer() {
		objects = new ArrayList<>();
	}

	public void add(GameObject object) {
		objects.add(object);
	}

	public void remove(GameObject object) {
		objects.remove(object);
	}

	public void automaticMoves() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			object.automaticMove();
		}
	}

	public void computerActions() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			object.computerAction();
		}
	}

	public String toString(Position position) {
		int i = 0;
		while (i < objects.size()) {
			GameObject object = objects.get(i);
			if (object.isOnPosition(position)) {
				return object.toString();
			}
			i++;
		}
		return "";
	}

	public void removeDead() {
		ListIterator<GameObject> iterator = objects.listIterator();
		while (iterator.hasNext()) {
			GameObject object = iterator.next();
			if (!object.isAlive()) {
				iterator.remove();
			}
		}
	}

	public void performAttacks(GameItem other) {
		int i = 0;
		while (i < objects.size()) {
			GameObject object = objects.get(i);
			other.performAttack(object);
			i++;
		}
	}

	public void checkAttacks(GameItem other) {
		int i = 0;
		while (i < objects.size()) {
			GameObject object = objects.get(i);
			object.performAttack(other);
			i++;
		}
	}
}
