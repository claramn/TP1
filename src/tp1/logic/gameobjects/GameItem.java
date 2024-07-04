package tp1.logic.gameobjects;

import tp1.logic.Move;
import tp1.logic.Position;

public interface GameItem {

	public boolean performAttack(GameItem other);

	public boolean receiveAttack(EnemyWeapon weapon);

	public boolean receiveAttack(UCMWeapon weapon);

	public boolean receiveAttack(ExplosiveAlien explosiveAlien);

	public boolean isAlive();

	public boolean isOnPosition(Position pos);

	public boolean isOut();

	public boolean isAdyacent(Position pos);

	public void performMovement(Move dir);

}
