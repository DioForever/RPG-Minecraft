package me.dioforever.rpg.StatWork;

import me.dioforever.rpg.files.CCStats;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {


    @EventHandler
    public void DMGEvent(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player){
            if(event.getDamage()!=0){
                if(event.getEntity() instanceof Player) {
                    //Defense
                    Player player = ((Player) event.getEntity()).getPlayer();
                    String nick = player.getName();
                    double Defense = CCStats.get().getInt(nick + ".Defense");
                    double Strength = 0;
                    if (event.getDamager() instanceof Player) {
                        Strength = CCStats.get().getInt(nick + ".Strength");
                    } else {
                        Strength = 0;
                    }

                    double DMG = event.getDamage();
                    double STR = Strength / 3 + 100;
                    double DMGSTR = DMG / 100 * STR;
                    double HPCurr = player.getHealth();
                    //                 2.5*100=250  100+100/3
                    double DealDMG = (int) ((DMGSTR * 100) / ((100 + Defense / 3)));
                    player.setHealth((HPCurr + DMGSTR) - DealDMG -1);
                }
            }
        }else{
            Entity damager = event.getDamager();
            if(damager instanceof Player) {
                Player player = ((Player) damager).getPlayer();
                Entity victim = event.getEntity();
                double DMG = event.getDamage();
                String nick = damager.getName();
                double Strength = CCStats.get().getInt(nick+".Strength");
                double STR = Strength/2+100;
                double DMGSTR = DMG/100*STR;
                event.setDamage(DMGSTR);
        }
            //int Strength = CCStats.get().getInt(nick+".Strength");

        }
    }

}
