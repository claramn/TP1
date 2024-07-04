package tp1.control.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.NotAllowedMoveException;
import tp1.exceptions.OffWorldException;
import tp1.logic.GameModel;
import tp1.logic.Move;
import tp1.view.Messages;

public class MoveCommand extends Command {

	private Move move;

	public MoveCommand() {
	}

	protected MoveCommand(Move move) {
		this.move = move;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_MOVE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_MOVE_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_MOVE_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_MOVE_HELP;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 2) {
				String secondWord = commandWords[1].toUpperCase();

				try {
					move = Move.valueOf(secondWord);
					return new MoveCommand(move);
				} catch (IllegalArgumentException e) {
					throw new CommandParseException(Messages.DIRECTION_ERROR + commandWords[1]);
				}
			} else
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		}
		return null;

	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException {
		try {
			game.moveUcm(move);
			return true;
		} catch (NotAllowedMoveException nam) {
			throw new CommandExecuteException(Messages.DIRECTION_ERROR + move.name(), nam);
		} catch (OffWorldException owe) {
			throw new CommandExecuteException(Messages.MOVEMENT_ERROR, owe);
		}
	}
}
