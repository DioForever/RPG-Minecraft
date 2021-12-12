package me.dioforever.rpg.commands;

import me.dioforever.rpg.files.CCother;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class message implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        String nick = player.getName();
        int MP = CCother.get().getInt(nick+".MP");
        int HP = CCother.get().getInt(nick+".HP");
        player.sendMessage("MP: "+MP+" HP: "+HP);
        CCother.get().set(nick+".MP",MP+1);
        CCother.save();
        return true;

    }
}
