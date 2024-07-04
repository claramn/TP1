package tp1.logic;

import tp1.control.InitialConfiguration;
import tp1.exceptions.InitializationException;
import tp1.exceptions.LaserInFlightException;
import tp1.exceptions.NoShockWaveException;
import tp1.exceptions.NotAllowedMoveException;
import tp1.exceptions.NotEnoughtPointsException;
import tp1.exceptions.OffWorldException;

public interface GameModel {
	public void moveUcm(Move move) throws OffWorldException, NotAllowedMoveException;
	public void shootLaser() throws LaserInFlightException;
	public void shootSuperLaser() throws LaserInFlightException, NotEnoughtPointsException;
	public void reset(InitialConfiguration conf) throws InitializationException;
	public void exit();
	public void shockwave() throws NoShockWaveException;
	public boolean isFinished();
}

