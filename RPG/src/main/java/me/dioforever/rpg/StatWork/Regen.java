package me.dioforever.rpg.StatWork;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCStats;
import me.dioforever.rpg.files.CCother;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.event.HierarchyBoundsAdapter;

public class Regen implements Listener {

    static Main plugin;

    public Regen(Main main){
        plugin = main;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onJoin(EntityRegainHealthEvent event) {
        Entity ent = event.getEntity();
        if(ent instanceof Player) {
            Player player = (Player) event.getEntity();

            String nick = player.getName();
                event.setCancelled(true);

                //REGEN POTION II
                Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                        double Hunger = player.getFoodLevel();
                        double Health = player.getHealth();
                        int MAXHP = (int) (CCother.get().getDouble(nick+".MAXHP")/5);
                        if(Health!=0){
                            PotionEffect effect = player.getPotionEffect( PotionEffectType.REGENERATION );
                            if ( effect != null && effect.getAmplifier() == 2 )
                            {
                                if(!(Health+1.5>MAXHP)){
                                    player.setHealth(player.getHealth()+1.5);
                                }else{
                                    player.setHealth(MAXHP);
                                }

                            }
                        }
                    }
            }, 50L);
            //REGEN POTION I
            Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    double Hunger = player.getFoodLevel();
                    double Health = player.getHealth();
                    int MAXHP = (int) (CCother.get().getDouble(nick+".MAXHP")/5);
                    if(Health!=0){
                        PotionEffect effect = player.getPotionEffect( PotionEffectType.REGENERATION );
                        if( effect != null && effect.getAmplifier() == 0 ){
                            if(!(Health+1>MAXHP)){
                                player.setHealth(player.getHealth()+1);
                            }else {
                                player.setHealth(MAXHP);
                            }
                        }
                    }
                }
            }, 50L);
                //HUNGER REGEN 20Hunger
            Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    double Hunger = player.getFoodLevel();
                    double Health = player.getHealth();
                    double RegenStat = CCStats.get().getInt(nick+".Regeneration");
                    int MAXHP = (int) (CCother.get().getDouble(nick+".MAXHP")/5);
                    if(Health!=0){
                        if(Hunger == 20){
                            if(!(Health+1+(RegenStat/50)>=MAXHP)){
                                //              10HP 1HP +   2HP
                                //              10HP +1HP + 100/50
                                player.setHealth((Health+1+(RegenStat/50)));

                            }else{
                                player.setHealth(MAXHP);
                            }

                        }
                    }
                }
            }, 60L);
            //HUNGER REGEN 19-18Hunger
            Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
                public void run() {
                    double Hunger = player.getFoodLevel();
                    double Health = player.getHealth();
                    double RegenStat = CCStats.get().getInt(nick+".Regeneration");
                    double MAXHP = CCother.get().getDouble(nick+".MAXHP")/5;
                    if(Health!=0){
                        if(Hunger <20 && Hunger >=18){
                            if(!(Health+1+(RegenStat/50)>MAXHP)) {
                                //              10HP 1HP +   2HP
                                //              10HP +1HP + 100/50
                                player.setHealth(Health + 1 + (RegenStat / 50));

                            }else{
                                player.setHealth(MAXHP);
                            }
                        }
                    }
                }
            }, 80L);
        }
        return;
    }
}
