package me.dioforever.rpg.Leveling;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCother;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class FarmMineListener implements Listener {

    static Main plugin;




    public FarmMineListener(Main main){
        plugin = main;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        List<Item> crops = new ArrayList<>();
        Block block = event.getBlock();

        //Corpses
        if (block.getBlockData() instanceof Ageable) {
            Ageable age = (Ageable) block.getBlockData();
            if (block.getType() == Material.WHEAT) {
                if (age.getAge() == age.getMaximumAge()) {
                    CCPlayerInfo.reload();
                    Player player = event.getPlayer();
                    String nick = player.getName();
                    double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                    CCPlayerInfo.get().set(nick+".XP", (XPRN+0.2));
                    CCPlayerInfo.save();
                    double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                    int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                        player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        player.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }
            }else if(block.getType() == Material.POTATOES){
                if (age.getAge() == age.getMaximumAge()) {
                    CCPlayerInfo.reload();
                    Player player = event.getPlayer();
                    String nick = player.getName();
                    double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                    CCPlayerInfo.get().set(nick+".XP", (XPRN+0.25));
                    CCPlayerInfo.save();
                    double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                    int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                        player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        player.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }

                }
            }else if(block.getType() == Material.CARROTS){
                if (age.getAge() == age.getMaximumAge()) {
                    CCPlayerInfo.reload();
                    Player player = event.getPlayer();
                    String nick = player.getName();
                    double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                    CCPlayerInfo.get().set(nick+".XP", (XPRN+0.25));
                    CCPlayerInfo.save();
                    double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                    int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    if(XPN==XP+5){
                        int Level = CCPlayerInfo.get().getInt(nick+".Level");
                        CCPlayerInfo.get().set(nick+".Level",Level+1);
                        CCPlayerInfo.get().set(nick+".XP",0);
                        CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                        int Points = CCother.get().getInt(nick+".POINTS");
                        CCother.get().set(nick+".POINTS",Points+2);
                        CCPlayerInfo.save();
                        CCother.save();
                        player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                        player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                        player.sendMessage(color("&l&6You have acquired 2 Points!"));
                    }
                }
            }
            Player player = event.getPlayer();
            String nick = player.getName();
            CCPlayerInfo.reload();
            CCother.reload();
            int lvlbar = CCother.get().getInt(nick+".lvlbar");
            int XPRN1 = CCPlayerInfo.get().getInt(nick+".XP");
            CCother.get().set(nick+".lvlbar",0);
            if(lvlbar==0) {
                int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                CCother.get().set(nick+".lvlbar",1);
                int Level = CCPlayerInfo.get().getInt(nick+".Level");
                BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN1)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                bar.addPlayer(player);
                Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

            }
        }
        if(block.getType()==Material.MELON){
            CCPlayerInfo.reload();
            Player player = event.getPlayer();
            String nick = player.getName();
            double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
            CCPlayerInfo.get().set(nick+".XP", (XPRN+0.3));
            CCPlayerInfo.save();
            double XP = CCPlayerInfo.get().getDouble(nick+".XP");
            int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
            //BAR
            CCPlayerInfo.reload();
            CCother.reload();
            if(XPN==XP+5){
                int Level = CCPlayerInfo.get().getInt(nick+".Level");
                CCPlayerInfo.get().set(nick+".Level",Level+1);
                CCPlayerInfo.get().set(nick+".XP",0);
                CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                int Points = CCother.get().getInt(nick+".POINTS");
                CCother.get().set(nick+".POINTS",Points+2);
                CCPlayerInfo.save();
                CCother.save();
                player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                player.sendMessage(color("&l&6You have acquired 2 Points!"));
            }

            int lvlbar = CCother.get().getInt(nick+".lvlbar");
            CCother.get().set(nick+".lvlbar",0);
            if(lvlbar==0) {
                int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                CCother.get().set(nick+".lvlbar",1);
                int Level = CCPlayerInfo.get().getInt(nick+".Level");
                BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                bar.addPlayer(player);
                Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

            }

        }


        //Ores
        Player player = event.getPlayer();
        if(!(player.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH))){
            if(block.getType()==Material.DIAMOND_ORE||block.getType()==Material.DEEPSLATE_DIAMOND_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+20));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }
            }else if(block.getType()==Material.IRON_ORE||block.getType()==Material.DEEPSLATE_IRON_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+2));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }
            }else if(block.getType()==Material.REDSTONE_ORE||block.getType()==Material.DEEPSLATE_REDSTONE_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+3));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            }else if(block.getType()==Material.EMERALD_ORE||block.getType()==Material.DEEPSLATE_EMERALD_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+15));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            }else if(block.getType()==Material.GOLD_ORE||block.getType()==Material.DEEPSLATE_GOLD_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+3));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            }else if(block.getType()==Material.LAPIS_ORE||block.getType()==Material.DEEPSLATE_LAPIS_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+5));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            }else if(block.getType()==Material.COAL_ORE||block.getType()==Material.DEEPSLATE_COAL_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+1));
                CCPlayerInfo.save();
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            } else if(block.getType()==Material.NETHER_QUARTZ_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+5));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            } else if(block.getType()==Material.NETHER_GOLD_ORE){
                CCPlayerInfo.reload();
                String nick = player.getName();
                double XPRN = CCPlayerInfo.get().getDouble(nick+".XP");
                CCPlayerInfo.get().set(nick+".XP", (XPRN+5));
                CCPlayerInfo.save();
                double XP = CCPlayerInfo.get().getDouble(nick+".XP");
                int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                if(XPN==XP+5){
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    CCPlayerInfo.get().set(nick+".Level",Level+1);
                    CCPlayerInfo.get().set(nick+".XP",0);
                    CCPlayerInfo.get().set(nick+".XPNeeded",Level*50+100);
                    int Points = CCother.get().getInt(nick+".POINTS");
                    CCother.get().set(nick+".POINTS",Points+2);
                    CCPlayerInfo.save();
                    CCother.save();
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
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
                    player.sendMessage(color("&l&6LEVEL UP "+(Level+1)));
                    player.sendMessage(color("&l&6You have acquired 2 Points!"));
                }
                int lvlbar = CCother.get().getInt(nick+".lvlbar");
                CCother.get().set(nick+".lvlbar",0);
                if(lvlbar==0) {
                    int XPN1 = CCPlayerInfo.get().getInt(nick+".XPNeeded");
                    CCother.get().set(nick+".lvlbar",1);
                    int Level = CCPlayerInfo.get().getInt(nick+".Level");
                    BossBar bar = Bukkit.createBossBar(color("&6&lLEVEL "+Level+" "+(XPRN)+"&6&lXP"+"&6&l/"+XPN1+"&6&lXP"), BarColor.YELLOW, BarStyle.SOLID);
                    bar.addPlayer(player);
                    Bukkit.getScheduler ().runTaskLater (plugin, () ->bar.removePlayer(player), 40);
                    Bukkit.getScheduler ().runTaskLater (plugin, () -> CCother.get().set(nick+".lvlbar",0), 40);

                }

            }
        }

    }

}

