package me.dioforever.rpg.UniqueAbility;

import me.dioforever.rpg.Main;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import me.dioforever.rpg.files.CCother;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class UniqueAbilityWork implements Listener {

    public static ArrayList playersI;
    static Main plugin;

    int taskID;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        String nick = p.getName();
        String UniqueAbility = CCSkills.get().getString(nick+".Skills.Unique");
        //Commander
       // if(UniqueAbility.contains("Commander00")){
          //  if(UniqueAbility.contains("Commander I - Tier III")){
               // taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                 //   double phi = 0;
                   // double t = 0;
                    //public void run() {
                      //  Location loc = p.getLocation();
                        //for(Player pO : Bukkit.getOnlinePlayers()){
                          //  Location pLoc = pO.getLocation();
                            //if(pLoc.distance(loc)<5){
                              //  playersI.add(pO);
                                //String nickO = pO.getName();
                                //5% 10% 15%
                                //int Health = CCStats.get().getInt(nickO+".Health");
                               // CCStats.get().set(nickO+".Health",((Health/100)*105));
                               // int Regen = CCStats.get().getInt(nickO+".Regeneration");
                               // CCStats.get().set(nickO+".Regeneration",((Regen/100)*105));
                              //  int Defense = CCStats.get().getInt(nickO+".Defense");
                              //  CCStats.get().set(nickO+".Defense",((Defense/100)*105));
                              //  int Intell = CCStats.get().getInt(nickO+".Intelligence");
                             //   CCStats.get().set(nickO+".Intelligence",((Intell/100)*105));
                             //   int Luck = CCStats.get().getInt(nickO+".Luck");
                             //   CCStats.get().set(nickO+".Luck",((Luck/100)*105));
                             //   int Agility = CCStats.get().getInt(nickO+".Agility");
                             //   CCStats.get().set(nickO+".Agility",((Agility/100)*105));
                             //   int Strength = CCStats.get().getInt(nickO+".Strength");
                             //   CCStats.get().set(nickO+".Strength",((Strength/100)*105));
                             //   int Wisdom = CCStats.get().getInt(nickO+".Wisdom");
                             //   CCStats.get().set(nickO+".Wisdom",((Wisdom/100)*105));
                            //}
                           //if(pLoc.distance(loc)>5 && playersI.contains(pO)){
                               // playersI.remove(pO);
                                //String nickO = pO.getName();
                                ////5% 10% 15%
                                //int Health = CCStats.get().getInt(nickO+".Health");
                                //CCStats.get().set(nickO+".Health",((Health/105)*100));
                               // int Regen = CCStats.get().getInt(nickO+".Regeneration");
                                //CCStats.get().set(nickO+".Regeneration",((Regen/105)*100));
                                //int Defense = CCStats.get().getInt(nickO+".Defense");
                             //  CCStats.get().set(nickO+".Defense",((Defense/105)*100));
                             //   int Intell = CCStats.get().getInt(nickO+".Intelligence");
                             //   CCStats.get().set(nickO+".Intelligence",((Intell/105)*100));
                              //  int Luck = CCStats.get().getInt(nickO+".Luck");
                             //   CCStats.get().set(nickO+".Luck",((Luck/105)*100));
                              //  int Agility = CCStats.get().getInt(nickO+".Agility");
                              //  CCStats.get().set(nickO+".Agility",((Agility/105)*100));
                              //  int Strength = CCStats.get().getInt(nickO+".Strength");
                              //  CCStats.get().set(nickO+".Strength",((Strength/105)*100));
                              //  int Wisdom = CCStats.get().getInt(nickO+".Wisdom");
                               // CCStats.get().set(nickO+".Wisdom",((Wisdom/105)*100));
                           // }
                       // }
                   // }

               // }, 0, 20);
           // }else if(UniqueAbility.contains("Commander II - Tier III")){

           // }else if(UniqueAbility.contains("Commander III - Tier III")){

            //}
       // }
        //Night Watcher
        if(UniqueAbility.contains("Night Watcher")){
            if(UniqueAbility.contains("Night Watcher I - Tier I")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 60000000, 1));
            }else if(UniqueAbility.contains("Night Watcher II - Tier I")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 60000000, 1));
                List skills = new ArrayList();
                if(CCSkills.get().getList(nick+".Skills.Legendary")!=null){
                    skills = CCSkills.get().getList(nick+".Skills.Mythical");
                }
                skills.add("Night Walking");
                CCSkills.get().set(nick+".Skills.Mythical",skills);
                CCStats.save();
            }else if(UniqueAbility.contains("Night Watcher III - Tier I")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 60000000, 1));
                List skills = new ArrayList();
                if(CCSkills.get().getList(nick+".Skills.Mythical")!=null){
                    skills = CCSkills.get().getList(nick+".Skills.Mythical");
                }
                skills.add("Night Walker");
                CCSkills.get().set(nick+".Skills.Mythical",skills);
                CCStats.save();
            }
        }
        //Reinforcement
        else if(UniqueAbility.contains("Reinforcement")){
            if(UniqueAbility.contains("Reinforcement I - Tier I")){
                int Strength = CCStats.get().getInt(nick+".Defense");
                CCStats.get().set(nick+".Defense",Strength+15);
                CCStats.save();
            }else if(UniqueAbility.contains("Reinforcement II - Tier I")){
                int Strength = CCStats.get().getInt(nick+".Defense");
                CCStats.get().set(nick+".Defense",Strength+30);
                CCStats.save();
            }else if(UniqueAbility.contains("Reinforcement III - Tier I")){
                int Strength = CCStats.get().getInt(nick+".Defense");
                CCStats.get().set(nick+".Defense",Strength+30);
                List skills = new ArrayList();
                if(CCSkills.get().getList(nick+".Skills.Mythical")!=null){
                    skills = CCSkills.get().getList(nick+".Skills.Mythical");
                }
                skills.add("Hard as Rock");
                CCSkills.get().set(nick+".Skills.Mythical",skills);
                CCStats.save();
            }
        }
        //Power of Giant
        else if(UniqueAbility.contains("Power of Giant")){
            if(UniqueAbility.contains("Power of Giant I - Tier II")){
                int Strength = CCStats.get().getInt(nick+".Strength");
                CCStats.get().set(nick+".Strength",Strength+5);
                CCStats.save();
            }else if(UniqueAbility.contains("Power of Giant II - Tier II")){
                int Strength = CCStats.get().getInt(nick+".Strength");
                CCStats.get().set(nick+".Strength",Strength+10);
                CCStats.save();
            }else if(UniqueAbility.contains("Power of Giant III - Tier II")){
                int Strength = CCStats.get().getInt(nick+".Strength");
                CCStats.get().set(nick+".Strength",Strength+20);
                CCStats.save();
            }
        }
        //Jumper
        else if(UniqueAbility.contains("Jumper")){
            if(UniqueAbility.contains("Jumper I - Tier I")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60000000, 1));
            }else if(UniqueAbility.contains("Jumper II - Tier I")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 60000000, 2));
            }else if(UniqueAbility.contains("Jumper III - Tier I")){
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600000000, 3));
            }
        }

        //Runner
        else if(UniqueAbility.contains("Runner")){
            if(UniqueAbility.contains("Runner I - Tier I")){
                double SpeedBefore = p.getWalkSpeed();
                p.setWalkSpeed((float) (SpeedBefore/100*110));
                CCStats.save();
            }else if(UniqueAbility.contains("Runner II - Tier I")){
                double SpeedBefore = p.getWalkSpeed();
                p.setWalkSpeed((float) (SpeedBefore/100*110));
                CCStats.save();
            }else if(UniqueAbility.contains("Runner III - Tier I")){
                double SpeedBefore = p.getWalkSpeed();
                p.setWalkSpeed((float) (SpeedBefore/100*110));
                CCStats.save();
            }
        }
        //Lucker
        else if(UniqueAbility.contains("Lucker")){
            if(UniqueAbility.contains("Lucker I - Tier I")){
                int Luck = CCStats.get().getInt(nick+".Luck");
                CCStats.get().set(nick+".Luck",Luck+5);
                CCStats.save();
            }else if(UniqueAbility.contains("Lucker II - Tier I")){
                int Luck = CCStats.get().getInt(nick+".Luck");
                CCStats.get().set(nick+".Luck",Luck+10);
                CCStats.save();
            }else if(UniqueAbility.contains("Lucker III - Tier I")){
                int Luck = CCStats.get().getInt(nick+".Luck");
                CCStats.get().set(nick+".Luck",Luck+20);
                CCStats.save();
            }
        }
        //Mana Affinity I- Tier III
        else if(UniqueAbility.contains("Mana Affinity")){
            if(UniqueAbility.contains("Mana Affinity I- Tier III")){
                int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                int Intel = CCStats.get().getInt(nick+".Intelligence");
                CCStats.get().set(nick+".Wisdom",Wisdom+3);
                CCStats.get().set(nick+".Intelligence",Intel+3);
                CCStats.save();
            }else if(UniqueAbility.contains("Mana Affinity II- Tier III")){
                int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                int Intel = CCStats.get().getInt(nick+".Intelligence");
                CCStats.get().set(nick+".Wisdom",Wisdom+5);
                CCStats.get().set(nick+".Intelligence",Intel+5);
                CCStats.save();
            }else if(UniqueAbility.contains("Mana Affinity III- Tier III")){
                int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                int Intel = CCStats.get().getInt(nick+".Intelligence");
                CCStats.get().set(nick+".Wisdom",Wisdom+10);
                CCStats.get().set(nick+".Intelligence",Intel+5);
                CCStats.save();
            }
        }
        //Tank
        else if(UniqueAbility.contains("Tank")){
            if(UniqueAbility.contains("Tank I - Tier I")){
                int MAXHP = CCother.get().getInt(nick+".MAXHP");
                CCother.get().set(nick+".MAXHP",MAXHP+5);
                CCother.save();
                CCStats.save();
            }else if(UniqueAbility.contains("Tank II - Tier I")){
                int MAXHP = CCother.get().getInt(nick+".MAXHP");
                CCother.get().set(nick+".MAXHP",MAXHP+10);
                CCother.save();
                CCStats.save();
            }else if(UniqueAbility.contains("Tank III - Tier I")){
                int MAXHP = CCother.get().getInt(nick+".MAXHP");
                CCother.get().set(nick+".MAXHP",MAXHP+20);
                CCother.save();
                CCStats.save();
            }
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player p = event.getPlayer();
        String nick = p.getName();
        String UniqueAbility = CCSkills.get().getString(nick+".Skills.Unique");
        //Reinforcement
        if(UniqueAbility.contains("Reinforcement I -")){
            if(UniqueAbility.contains("Reinforcement I - Tier I")){
                int Strength = CCStats.get().getInt(nick+".Defense");
                CCStats.get().set(nick+".Defense",Strength-15);
                CCStats.save();
            }else if(UniqueAbility.contains("Reinforcement II - Tier I")){
                int Strength = CCStats.get().getInt(nick+".Defense");
                CCStats.get().set(nick+".Defense",Strength-30);
                CCStats.save();
            }else if(UniqueAbility.contains("Reinforcement III - Tier I")){
                int Strength = CCStats.get().getInt(nick+".Defense");
                CCStats.get().set(nick+".Defense",Strength-30);
            }
        }
        //Jumper
        else if(UniqueAbility.contains("Jumper I -")){
            if(UniqueAbility.contains("Jumper I - Tier I")){
                for (PotionEffect effect : p.getActivePotionEffects())
                    if(effect.getType()==PotionEffectType.JUMP){
                        p.removePotionEffect(effect.getType());
                    }
            }else if(UniqueAbility.contains("Jumper II - Tier I")){
                for (PotionEffect effect : p.getActivePotionEffects())
                    if(effect.getType()==PotionEffectType.JUMP){
                        p.removePotionEffect(effect.getType());
                    }
            }else if(UniqueAbility.contains("Jumper III - Tier I")){
                for (PotionEffect effect : p.getActivePotionEffects())
                    if(effect.getType()==PotionEffectType.JUMP){
                        p.removePotionEffect(effect.getType());
                    }
            }
        }
        //Power of Giant
        else if(UniqueAbility.contains("Power of Giant")){
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
        //Runner
        else if(UniqueAbility.contains("Runner I -")){
            if(UniqueAbility.contains("Runner I - Tier I")){
                double SpeedAfter = p.getWalkSpeed();
                p.setWalkSpeed((float) (SpeedAfter/110*100));
                CCStats.save();
            }else if(UniqueAbility.contains("Runner II - Tier I")){
                double SpeedAfter = p.getWalkSpeed();
                p.setWalkSpeed((float) (SpeedAfter/110*100));
                CCStats.save();
            }else if(UniqueAbility.contains("Runner III - Tier I")){
                double SpeedAfter = p.getWalkSpeed();
                p.setWalkSpeed((float) (SpeedAfter/110*100));
                CCStats.save();
            }
        }
        //Lucker
        else if(UniqueAbility.contains("Lucker")){
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
        else if(UniqueAbility.contains("Mana Affinity")){
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
        else if(UniqueAbility.contains("Tank")){
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
