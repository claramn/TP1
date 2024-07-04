package tp1.control.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import tp1.control.InitialConfiguration;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ResetCommand extends Command {
	private InitialConfiguration conf;

	public ResetCommand() {
	}

	protected ResetCommand(InitialConfiguration conf) {
		this.conf = conf;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_RESET_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 2) {
				String secondWord = commandWords[1];
				try {
					InitialConfiguration conf = InitialConfiguration.readFromFile(secondWord);
					return new ResetCommand(conf);
				} catch (FileNotFoundException e) {
					throw new CommandParseException(String.format(Messages.FILE_NOT_FOUND, secondWord));
				} catch (IOException e) {
					throw new CommandParseException(String.format(Messages.READ_ERROR, secondWord));
				}
			} else if (commandWords.length == 1) {
				return new ResetCommand(InitialConfiguration.NONE);
			} else
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		}
		return null;
	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException {
		try {
			game.reset(conf);
			return true;
		} catch (GameModelException gme) {
			throw new CommandExecuteException(Messages.INITIAL_CONFIGURATION_ERROR, gme);
		}
	}
}
