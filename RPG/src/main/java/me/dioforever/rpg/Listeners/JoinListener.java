package me.dioforever.rpg.Listeners;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.*;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static me.dioforever.rpg.Utils.color;

public class JoinListener implements Listener {

    static Main plugin;


    public JoinListener(Main main){
        plugin = main;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        String nick = player.getName();

        System.out.println(ChatColor.AQUA + player.getName() + " has joined the server!");
        String PC = CCPlayerInfo.get().getString(nick+".PC");
        if (PC == null) {
            CCPlayerInfo.get().addDefault(nick+".PC", "Player Created");
            CCPlayerInfo.get().addDefault(nick+".Race","none");
            CCPlayerInfo.save();
            Random randomCh = new Random();
            int min = 1;
            int max = 84;

            int UniqueSkill = randomCh.nextInt((max - min)) + min;
            if (!(CCStats.get().contains(nick + ".Health"))) {
                //Stats
                CCStats.get().addDefault(nick + ".Health", 1);
                CCStats.get().addDefault(nick + ".Regeneration", 1);
                CCStats.get().addDefault(nick + ".Defense", 1);
                CCStats.get().addDefault(nick + ".Intelligence", 1);
                CCStats.get().addDefault(nick + ".Luck", 1);
                CCStats.get().addDefault(nick + ".Agility", 1);
                CCStats.get().addDefault(nick + ".Strength", 1);
                CCStats.get().addDefault(nick + ".Wisdom", 1);
                CCStats.save();
            }

            if (!(CCMagic.get().contains(nick + ".Magic"))) {
                //Magic
                CCMagic.get().addDefault(nick + ".Magic", "");
                CCMagic.save();
            }

            if (!(CCStats.get().contains(nick + ".Level"))) {
                //PlayerInfo

                CCPlayerInfo.get().addDefault(nick + ".Level", 1);
                CCPlayerInfo.get().addDefault(nick + ".XP", 0);
                CCPlayerInfo.get().addDefault(nick + ".XPNeeded", 100);
                CCPlayerInfo.get().addDefault(nick + ".Guild", "");
                CCPlayerInfo.save();
            }
            //Skills
            if (UniqueSkill == 1 || UniqueSkill == 2 || UniqueSkill == 3 || UniqueSkill == 4 || UniqueSkill == 5 || UniqueSkill == 6) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Reinforcement - I Tier I");
                System.out.println("Reinforcement I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Strong so you get &5&lReinforcement &a&lTier I"));
                CCSkills.save();
            }
            if (UniqueSkill == 7 || UniqueSkill == 8 || UniqueSkill == 9 || UniqueSkill == 10 || UniqueSkill == 11 || UniqueSkill == 12) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Lucker I - Tier I");
                System.out.println("Lucker I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Lucky so you get &a&lLucker &a&lT&b&li&c&le&d&lr &e&lI"));
                CCSkills.save();
            }
            if (UniqueSkill == 13 || UniqueSkill == 14 || UniqueSkill == 15 || UniqueSkill == 16 || UniqueSkill == 17 || UniqueSkill == 18) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Runner I - Tier I");
                System.out.println("Runner I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Fast so you get &e&lRunner &a&lTier I"));
                CCSkills.save();
            }
            if (UniqueSkill == 19 || UniqueSkill == 20 || UniqueSkill == 21 || UniqueSkill == 22 || UniqueSkill == 23 || UniqueSkill == 24) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Tank I - Tier I");
                System.out.println("Tank I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as a Healthy guy so you get &4&lTank &a&lTier I"));
                CCSkills.save();
            }
            if (UniqueSkill == 25 || UniqueSkill == 26 || UniqueSkill == 27 || UniqueSkill == 28 || UniqueSkill == 29 || UniqueSkill == 30) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Jumper I - Tier I");
                System.out.println("Jumper I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Good Jumper so you get &3&lJumper &a&lTier I"));
                CCSkills.save();
            }
            if (UniqueSkill == 31 || UniqueSkill == 32 || UniqueSkill == 33 || UniqueSkill == 34 || UniqueSkill == 35 || UniqueSkill == 36) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Night Watcher I - Tier I");
                System.out.println("Night Watcher I");
                player.sendMessage(color("&2The &lGaia &2has recognized your"));
                player.sendMessage(color("&2talent of seeing rare things so you get &1&lNight Watcher &a&lTier I"));
                CCSkills.save();
            }

            // Tier II
            if (UniqueSkill==37 || UniqueSkill==38|| UniqueSkill==39|| UniqueSkill==40 ||UniqueSkill==41 ||UniqueSkill==42) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Regenerate I - Tier II");
                System.out.println("Regenerate I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Healthy so you get &4&lRegenerate &5&lTier II"));
                CCSkills.save();
            }
            if (UniqueSkill==43 || UniqueSkill==44|| UniqueSkill==45|| UniqueSkill==46 ||UniqueSkill==47 ||UniqueSkill==48) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Third Eye I - Tier II");
                System.out.println("Third Eye I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Smart so you get &5&lThird Eye &5&lTier II"));
                CCSkills.save();
            }
            if (UniqueSkill==49 || UniqueSkill==50|| UniqueSkill==51|| UniqueSkill==52 ||UniqueSkill==53 ||UniqueSkill==54) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Blood Thief I - Tier II");
                System.out.println("Blood Thief I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as persevering so you get &c&lBlood Thief &5&lTier II"));
                CCSkills.save();
            }
            if(UniqueSkill==79 || UniqueSkill==80|| UniqueSkill==81|| UniqueSkill==82 ||UniqueSkill==83 ||UniqueSkill==84){
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Power of Giant I - Tier II");
                System.out.println("Power of Giant I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as Strong so you get &4&lPower of Giant &5&lTier II"));
                CCSkills.save();
            }

            if (UniqueSkill==55 || UniqueSkill==56|| UniqueSkill==57|| UniqueSkill==58 ||UniqueSkill==59 ||UniqueSkill==60) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Master Swordsman I Tier - II");
                System.out.println("Master Swordsman I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as good Swordsman so you get &c&lMaster Swordsman &5&lTier II"));
                CCSkills.save();
            }
            if (UniqueSkill==61 || UniqueSkill==62|| UniqueSkill==63|| UniqueSkill==64 ||UniqueSkill==65 ||UniqueSkill==66) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Master Archer II Tier");
                System.out.println("Master Archer I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as good Archer so you get &c&lMaster Archer &5&lTier II"));
                CCSkills.save();
            }
            //Tier III
            if (UniqueSkill==67 || UniqueSkill==68|| UniqueSkill==69|| UniqueSkill==70) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Mana Affinity I- Tier III");
                System.out.println("Mana Affinity I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as one with Mana so you get &b&lMana Affinity &6&lTier III"));
                CCSkills.save();
            }

            if (UniqueSkill==71 || UniqueSkill==72|| UniqueSkill==73|| UniqueSkill==74) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Commander I - Tier III");
                System.out.println("Commander I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as very good Commander so you get &4&lCommander &6&lTier III"));
                CCSkills.save();
            }
            if (UniqueSkill==75 || UniqueSkill==76|| UniqueSkill==77|| UniqueSkill==78) {
                CCSkills.get().addDefault(nick + ".Skills.Unique", "Solo I - Tier III");
                System.out.println("Solo I");
                player.sendMessage(color("&2The &lGaia &2has recognized you"));
                player.sendMessage(color("&2as an individual so you get &6&lSolo &6&lTier III"));
                CCSkills.save();
            }
            player.sendMessage(color("&aUse &l/races &r&acommand to chose a race!"));


            System.out.println(UniqueSkill);
            CCSkills.save();
            //Mana, HP
            CCother.get().addDefault(nick + ".MP", 30);
            CCother.get().addDefault(nick + ".MAXMP", 30);
            CCother.get().addDefault(nick + ".HP", 100);
            CCother.get().addDefault(nick + ".POINTS", 2);
            if (UniqueSkill == 3) {
                CCother.get().addDefault(nick + ".MAXHP", 120);

            } else {
                CCother.get().addDefault(nick + ".MAXHP", 100);
            }
            CCother.get().set(nick + ".count1", 0);
            CCother.get().set(nick + ".lvlbar", 1);




            CCother.save();
            CCPlayerInfo.save();



        }



    }

}
