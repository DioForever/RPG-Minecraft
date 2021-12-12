package me.dioforever.rpg.Runnables;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCother;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.function.BinaryOperator;

public class HP_Mana_Bar {

    public HP_Mana_Bar(){
        Bar();
    }
    int count = 0;
    int count1 = 0;
    public void Bar(){
        new BukkitRunnable() {
            @Override

            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    String nick = p.getName();
                    CCother.reload();
                    int MP = CCother.get().getInt(nick+".MP");
                    int HP = CCother.get().getInt(nick+".HP");
                    BossBar bb = Bukkit.createBossBar(("Mana: "+ ChatColor.BLUE + MP +ChatColor.WHITE+ " HP: "+ ChatColor.RED +HP ), BarColor.BLUE, BarStyle.SOLID);
                    bb.setTitle(("Mana: "+ ChatColor.BLUE + MP +ChatColor.WHITE+ " HP: "+ ChatColor.RED +HP ));

                    if(count==0){
                        bb.addPlayer(p);
                        count++;
                    }
                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,10);
    }

}
