package tp1.control.commands;

import tp1.logic.GameModel;
import tp1.view.Messages;

public class ListCommand extends NoParamsCommand {

	@Override
	protected String getName() {
		return Messages.COMMAND_LIST_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_LIST_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_LIST_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_LIST_HELP;
	}

	@Override
	public boolean execute(GameModel game) {
		String list = Messages.alienDescription(Messages.REGULAR_ALIEN_DESCRIPTION, 5, 0, 2) + "\n"
				+ Messages.alienDescription(Messages.DESTROYER_ALIEN_DESCRIPTION, 10, 1, 1) + "\n"
				+ Messages.alienDescription(Messages.EXPLOSIVE_ALIEN_DESCRIPTION, 12, 1, 2) + "\n"
				+ Messages.ucmShipDescription(Messages.UCMSHIP_DESCRIPTION, 1, 3) + "\n"
				+ Messages.alienDescription(Messages.UFO_DESCRIPTION, 25, 0, 1) + "\n";
		System.out.println(list);
		return false;
	}

}
