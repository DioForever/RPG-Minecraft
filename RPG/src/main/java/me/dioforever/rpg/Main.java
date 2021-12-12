package me.dioforever.rpg;

import me.dioforever.rpg.Leveling.FarmMineListener;
import me.dioforever.rpg.Leveling.KillEntityListener;
import me.dioforever.rpg.StatWork.DamageListener;
import me.dioforever.rpg.Listeners.JoinListener;
import me.dioforever.rpg.Menu.MenuListener;
import me.dioforever.rpg.StatWork.Regen;
import me.dioforever.rpg.Stats.StatsClickListener;
import me.dioforever.rpg.UniqueAbility.UniqueAbilityListener;
import me.dioforever.rpg.UniqueAbility.UniqueAbilityWork;
import me.dioforever.rpg.commands.Guilds.GuildCMDS;
import me.dioforever.rpg.commands.Races.*;
import me.dioforever.rpg.commands.ReloadCommand;
import me.dioforever.rpg.Menu.menu;
import me.dioforever.rpg.commands.SummonCmd;
import me.dioforever.rpg.commands.Updates;
import me.dioforever.rpg.commands.message;
import me.dioforever.rpg.files.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Logger logger;
    private ArrayList listP = new ArrayList();


    public void what(){
        
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        List test1 = new ArrayList();
        test1.add("testC");

        List test2 = new ArrayList();
        test2.add("testS");

        List test3 = new ArrayList();
        test3.add("testG");
        List test4 = new ArrayList();
        test4.add("Player0");

        logger = getLogger();

        CClists.setup();
        CCStats.setup();
        CCMagic.setup();
        CCSkills.setup();
        CCPlayerInfo.setup();
        CCother.setup();
        CClists.get().options().copyDefaults(true);
        CCStats.get().options().copyDefaults(true);
        CCSkills.get().options().copyDefaults(true);
        CCMagic.get().options().copyDefaults(true);
        CCPlayerInfo.get().options().copyDefaults(true);
        CCother.get().options().copyDefaults(true);
        CClists.get().addDefault("Commander",test1);
        CClists.get().addDefault("Solo",test2);
        CClists.get().addDefault("Guilds",test3);
        CClists.get().addDefault("GuildJoined",test4);
        CClists.save();
        CCother.save();
        CCStats.save();
        CCMagic.save();
        CCSkills.save();
        CCPlayerInfo.save();


        getServer().getPluginManager().registerEvents(new JoinListener(this),this);
        getServer().getPluginManager().registerEvents(new MenuListener(),this);
        getServer().getPluginManager().registerEvents(new StatsClickListener(),this);
        getServer().getPluginManager().registerEvents(new DamageListener(),this);
        getServer().getPluginManager().registerEvents(new Regen(this),this);
        getServer().getPluginManager().registerEvents(new KillEntityListener(this),this);
        getServer().getPluginManager().registerEvents(new UniqueAbilityListener(),this);
        getServer().getPluginManager().registerEvents(new FarmMineListener(this),this);
        getServer().getPluginManager().registerEvents(new UniqueAbilityWork(),this);
        getServer().getPluginManager().registerEvents(new RacesInvListener(),this);

        getCommand("updates").setExecutor(new Updates());
        getCommand("preload").setExecutor(new ReloadCommand());
        getCommand("message").setExecutor(new message());
        getCommand("menu").setExecutor(new menu());
        getCommand("guild").setExecutor(new GuildCMDS());
        //Races
        getCommand("races").setExecutor(new Races());
        //Summon
        getCommand("Seth").setExecutor(new SummonCmd());

        //
        Bar();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        UniqueAbilities();
        CCStats.save();
        CCMagic.save();
        CCSkills.save();
        CCPlayerInfo.save();
    }
    int count = 0;
    int count1 = 0;

    public static Logger getPluginLogger() {
        return logger;
    }
    public void Bar(){
        new BukkitRunnable() {
            @Override

            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){

                    String nick = p.getName();
                    //MP setting
                    int MPRn =  CCother.get().getInt(nick+".MP");
                    int MPStat = CCStats.get().getInt(nick+".Intelligence");
                    int MPRegen = CCStats.get().getInt(nick+".Wisdom");

                    int MAXMPset = (MPStat*5)+30;
                    CCother.get().set(nick+".MAXMP",MAXMPset);
                    CCother.save();

                    if(!(MPRn>=MAXMPset)){
                        if(MPRegen!=1){
                            CCother.get().set(nick+".MP",(MPRn+(MPRegen/2)));
                            CCother.save();
                        }else{
                            CCother.get().set(nick+".MP",(MPRn+(1)));
                            CCother.save();
                        }
                    }
                    if(MAXMPset<MPRn){
                        CCother.get().set(nick+".MP",MAXMPset);
                        CCother.save();
                    }


                    //HP setting
                    int HPRn = (int) p.getHealth();
                    int HPRN = HPRn*5;
                    CCother.get().set(nick+".HP",HPRN);
                    CCother.save();

                    int HPSTAT = CCStats.get().getInt(nick+".Health");
                    if(HPSTAT!=1){
                        CCother.get().set(nick+".MAXHP",(100+(HPSTAT*2)));
                    }else{
                        CCother.get().set(nick+".MAXHP",(100));

                    }
                    int HpMax = CCother.get().getInt(nick+".MAXHP");
                    CCother.save();
                    // 100HP = 20Health
                    //5HP = 1Health

                    p.setMaxHealth(HpMax/5);

                    //Bar
                    CCother.reload();

                    CCother.save();
                    int MP = CCother.get().getInt(nick+".MP");
                    int MAXMP = CCother.get().getInt(nick+".MAXMP");

                    int MAXHP = CCother.get().getInt(nick+".MAXHP");
                    int HPRNN = (int) p.getHealth()*5;
                    CCother.get().set(nick+".HP",HPRNN);
                    CCother.save();
                    int HP = CCother.get().getInt(nick+".HP");
                    if(MAXHP<HPRNN){
                        CCother.get().set(nick+".HP",MAXHP);
                        CCother.save();
                    }
                    int count = CCother.get().getInt(nick+".count");
                        if(p.getHealth()!=0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(("Mana: "+ ChatColor.BLUE + MP+"/"+MAXMP +ChatColor.WHITE+ " HP: "+ ChatColor.RED +(HP)+"/"+MAXHP )));
                        }if(p.getHealth()==0){
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(("Mana: "+ ChatColor.BLUE + MP+"/"+MAXMP +ChatColor.WHITE+ " HP: "+ ChatColor.RED +(HP)+"/"+MAXHP )));

                        }



                   //Agility
                    int Agility = CCStats.get().getInt(nick+".Agility");
                    //                               100/20=5*0,02=0.1*2=0.2 = 100% + 100% = 200% speed
                    p.setWalkSpeed((float) (0.2 + Agility/20*0.02*2));

                    int lvlBar = CCother.get().getInt(nick+".lvlBar");
                    if(lvlBar==1){
                        BossBar bossBar = Bukkit.createBossBar(
                                ChatColor.DARK_PURPLE + "Visit our Website! " + ChatColor.LIGHT_PURPLE + "...", BarColor.PURPLE, BarStyle.SEGMENTED_20);
                    }
                }

            }

        }.runTaskTimerAsynchronously((Plugin) this,0,10);
    }

    public void UniqueAbilities(){
        for(Player p : Bukkit.getOnlinePlayers()){
            String nick = p.getName();
            String UniqueAbility = CCSkills.get().getString(nick+".Skills.Unique");
            listP = UniqueAbilityWork.playersI;
            //if(listP.contains(listP.contains(p))){
              //  listP.remove(p);
                //String nickO = p.getName();
                //5% 10% 15%
                //int Health = CCStats.get().getInt(nickO+".Health");
                //CCStats.get().set(nickO+".Health",((Health/105)*100));
                //int Regen = CCStats.get().getInt(nickO+".Regeneration");
                //CCStats.get().set(nickO+".Regeneration",((Regen/105)*100));
                //int Defense = CCStats.get().getInt(nickO+".Defense");
                //CCStats.get().set(nickO+".Defense",((Defense/105)*100));
                //int Intell = CCStats.get().getInt(nickO+".Intelligence");
                //CCStats.get().set(nickO+".Intelligence",((Intell/105)*100));
                //int Luck = CCStats.get().getInt(nickO+".Luck");
                //CCStats.get().set(nickO+".Luck",((Luck/105)*100));
               // int Agility = CCStats.get().getInt(nickO+".Agility");
              //  CCStats.get().set(nickO+".Agility",((Agility/105)*100));
              //  int Strength = CCStats.get().getInt(nickO+".Strength");
               // CCStats.get().set(nickO+".Strength",((Strength/105)*100));
             //   int Wisdom = CCStats.get().getInt(nickO+".Wisdom");
            //    CCStats.get().set(nickO+".Wisdom",((Wisdom/105)*100));
           // }
            //Power of Giant
            if(UniqueAbility.contains("Power of Giant")){
                if(UniqueAbility.contains("Power of Giant I - Tier II")){
                    int Strength = CCStats.get().getInt(nick+".Strength");
                    CCStats.get().set(nick+".Strength",Strength-5);
                    CCStats.save();
                }else if(UniqueAbility.contains("Power of Giant II - Tier II")){
                    int Strength = CCStats.get().getInt(nick+".Strength");
                    CCStats.get().set(nick+".Strength",Strength-10);
                    CCStats.save();
                }else if(UniqueAbility.contains("Power of Giant III - Tier II")){
                    int Strength = CCStats.get().getInt(nick+".Strength");
                    CCStats.get().set(nick+".Strength",Strength-20);
                    CCStats.save();
                }
            }

            //Lucker
            if(UniqueAbility.contains("Lucker")){
                if(UniqueAbility.contains("Lucker I - Tier I")){
                    int Luck = CCStats.get().getInt(nick+".Luck");
                    CCStats.get().set(nick+".Luck",Luck-5);
                    CCStats.save();
                }else if(UniqueAbility.contains("Lucker II - Tier I")){
                    int Luck = CCStats.get().getInt(nick+".Luck");
                    CCStats.get().set(nick+".Luck",Luck-10);
                    CCStats.save();
                }else if(UniqueAbility.contains("Lucker III - Tier I")){
                    int Luck = CCStats.get().getInt(nick+".Luck");
                    CCStats.get().set(nick+".Luck",Luck-20);
                    CCStats.save();
                }
            }
            //Mana Affinity I- Tier III
            if(UniqueAbility.contains("Mana Affinity")){
                if(UniqueAbility.contains("Mana Affinity I- Tier III")){
                    int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                    int Intel = CCStats.get().getInt(nick+".Intelligence");
                    CCStats.get().set(nick+".Wisdom",Wisdom-3);
                    CCStats.get().set(nick+".Intelligence",Intel-3);
                    CCStats.save();
                }else if(UniqueAbility.contains("Mana Affinity II- Tier III")){
                    int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                    int Intel = CCStats.get().getInt(nick+".Intelligence");
                    CCStats.get().set(nick+".Wisdom",Wisdom-5);
                    CCStats.get().set(nick+".Intelligence",Intel-5);
                    CCStats.save();
                }else if(UniqueAbility.contains("Mana Affinity III- Tier III")){
                    int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                    int Intel = CCStats.get().getInt(nick+".Intelligence");
                    CCStats.get().set(nick+".Wisdom",Wisdom-10);
                    CCStats.get().set(nick+".Intelligence",Intel-5);
                    CCStats.save();
                }
            }
            //Tank
            if(UniqueAbility.contains("Tank")){
                if(UniqueAbility.contains("Tank I - Tier I")){
                    int MAXHP = CCother.get().getInt(nick+".MAXHP");
                    CCother.get().set(nick+".MAXHP",MAXHP-5);
                    CCother.save();
                    CCStats.save();
                }else if(UniqueAbility.contains("Tank II - Tier I")){
                    int MAXHP = CCother.get().getInt(nick+".MAXHP");
                    CCother.get().set(nick+".MAXHP",MAXHP-10);
                    CCother.save();
                    CCStats.save();
                }else if(UniqueAbility.contains("Tank III - Tier I")){
                    int MAXHP = CCother.get().getInt(nick+".MAXHP");
                    CCother.get().set(nick+".MAXHP",MAXHP-20);
                    CCother.save();
                    CCStats.save();
                }
            }
        }

    }
}
