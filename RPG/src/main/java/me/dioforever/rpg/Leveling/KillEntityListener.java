package me.dioforever.rpg.Leveling;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCStats;
import me.dioforever.rpg.files.CCother;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

import static me.dioforever.rpg.Utils.color;

public class KillEntityListener implements Listener {

    static Main plugin;




    public KillEntityListener(Main main){
        plugin = main;
    }

    @EventHandler
    public void onKillMob(EntityDeathEvent event){
        LivingEntity victim = event.getEntity();
        Entity killer = victim.getKiller();
        if(killer instanceof Player){
            Player killerP = event.getEntity().getKiller().getPlayer();
            String nick = killerP.getName();
            double XP = CCPlayerInfo.get().getDouble(nick+".XP");
            int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");


            if(victim instanceof Monster){
                if(victim.getType()== EntityType.ZOMBIE){
                    //5XP
                    CCPlayerInfo.get().set(nick+".XP",XP+5);
                    CCPlayerInfo.save();

                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else if(XPN<XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }else
                if(victim.getType()== EntityType.SKELETON){
                    //5XP
                    CCPlayerInfo.get().set(nick+".XP",XP+5);
                    CCPlayerInfo.save();
                    if(XPN==XP){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }else
                if(victim.getType()== EntityType.SPIDER){
                    //5XP
                    CCPlayerInfo.get().set(nick+".XP",XP+5);
                    CCPlayerInfo.save();
                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }else
                if(victim.getType()== EntityType.CAVE_SPIDER){
                    //5XP
                    CCPlayerInfo.get().set(nick+".XP",XP+5);
                    CCPlayerInfo.save();
                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }else
                if(victim.getType()== EntityType.PHANTOM){
                    //15XP
                    CCPlayerInfo.get().set(nick+".XP",XP+15);
                    CCPlayerInfo.save();
                    if(XPN==XP+15){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+15){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }else
                if(victim.getType()== EntityType.BLAZE){
                    //15XP
                    CCPlayerInfo.get().set(nick+".XP",XP+15);
                    CCPlayerInfo.save();
                    if(XPN==XP+15){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+15){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }else if(victim.getType()==EntityType.WITHER){
                    //200XP
                    CCPlayerInfo.get().set(nick+".XP",XP+200);
                    CCPlayerInfo.save();
                    if(XPN==XP+200){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+200){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }


                }else if(victim.getType()==EntityType.ENDER_DRAGON){
                    //2000XP
                    CCPlayerInfo.get().set(nick+".XP",XP+2000);
                    CCPlayerInfo.save();
                    if(XPN==XP+2000){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+2000){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }


                }else{
                    //5XP
                    CCPlayerInfo.get().set(nick+".XP",XP+5);

                    CCPlayerInfo.save();
                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }else
                    if(XPN<XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                        double XP02 = XP01-XPN;
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0+XP02);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }




            }
            if(victim instanceof Animals){
                CCPlayerInfo.get().set(nick+".XP",XP+1);
                CCPlayerInfo.save();
                if(XPN==XP+1){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                }else
                    if(XPN<XP+1){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    double XP01 = CCPlayerInfo.get().getDouble(nick+".XP");
                    double XP02 = XP01;
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0+XP02);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    killerP.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    killerP.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
            }
            CCPlayerInfo.reload();
            CCother.reload();
            int lvlbar = CCother.get().getInt(nick+".lvlbar");
            CCother.get().set(nick+".lvlbar",0);
            if(lvlbar==0) {
                CCother.get().set(nick+".lvlbar",1);
                int Level = CCPlayerInfo.get().getInt(nick+".Level");
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+XPRN+"&6&lXP"+"&6&l/"+XPN+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                bar.addPlayer(killerP);
                Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(killerP), 40);
                Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

            }



            //20 ticks equal 1 second


        }
    }

}
