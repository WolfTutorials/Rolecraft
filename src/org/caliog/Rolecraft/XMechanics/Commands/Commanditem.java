package org.caliog.Rolecraft.XMechanics.Commands;

import java.util.List;

import org.bukkit.entity.Player;
import org.caliog.Rolecraft.Entities.Player.Playerface;
import org.caliog.Rolecraft.Items.ItemUtils;
import org.caliog.Rolecraft.XMechanics.Commands.Utils.Command;
import org.caliog.Rolecraft.XMechanics.Commands.Utils.CommandExecutable;
import org.caliog.Rolecraft.XMechanics.Commands.Utils.CommandField;
import org.caliog.Rolecraft.XMechanics.Commands.Utils.Commands;
import org.caliog.Rolecraft.XMechanics.Commands.Utils.CommandField.FieldProperty;
import org.caliog.Rolecraft.XMechanics.Messages.CmdMessage;

public class Commanditem extends Commands {

	@Override
	public List<Command> getCommands() {
		/*
		 * Name: item
		 * 
		 * Permission: rc.item
		 * 
		 * Usage: /item <name> [level|amount] [tradeable]
		 */
		cmds.add(new Command("item", "rc.item", new CommandExecutable() {

			@Override
			public void execute(String[] args, Player player) {
				String name = args[0];
				int a = 1;
				if (args.length > 1)
					a = Integer.parseInt(args[1]);
				boolean t = true;
				if (args.length > 2) {
					t = Boolean.valueOf(args[2]);
				}
				if (Playerface.giveItem(player, ItemUtils.getItem(name + ":" + a + ":" + t)))
					;
				else
					player.sendMessage(CmdMessage.gaveYouItemNot);
			}
		}, new CommandField("name", FieldProperty.REQUIRED), new CommandField("level|amount", "positive integer", FieldProperty.OPTIONAL),
				new CommandField("tradeable", "true|false", FieldProperty.OPTIONAL)));

		return cmds;
	}
}
