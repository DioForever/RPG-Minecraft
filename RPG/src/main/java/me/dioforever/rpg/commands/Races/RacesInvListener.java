package me.dioforever.rpg.commands.Races;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static me.dioforever.rpg.Utils.color;

public class RacesInvListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&5&lChoose a race"))){

            //Player doesn´t have Menu opened
            return;

        }else{
            //Cancel all item  moving
            event.setCancelled(true);
            if(!event.getClickedInventory().equals(inv)){
                return;
            }

            Player player = (Player) event.getWhoClicked();
            ClickType click = event.getClick();
            int slot = event.getSlot();
            String nick = player.getName();
            if(click != ClickType.LEFT && click != ClickType.RIGHT){

                return;
            }
            if(click!=null){
                String race = CCPlayerInfo.get().getString(nick+".Race");
                if(race=="none"){
                    int Health = CCStats.get().getInt(nick+".Health");
                    int Defense = CCStats.get().getInt(nick+".Defense");
                    int Intelligence = CCStats.get().getInt(nick+".Intelligence");
                    int Luck = CCStats.get().getInt(nick+".Luck");
                    int Agility = CCStats.get().getInt(nick+".Agility");
                    int Strength = CCStats.get().getInt(nick+".Strength");
                    int Wisdom = CCStats.get().getInt(nick+".Wisdom");
                    switch (slot) {
                        case 11:
                            //
                            if(click == ClickType.LEFT){
                                CCPlayerInfo.get().set(nick+".Race","Human");
                                CCStats.get().set(nick+".Agility",Agility+2);
                                CCStats.get().set(nick+".Strength",Strength+2);
                                CCStats.get().set(nick+"Defense",Defense+2);
                                CCStats.get().set(nick+".Health",Health+2);
                                CCStats.get().set(nick+".Intelligence",Intelligence+2);
                                CCStats.save();
                                player.sendMessage(color("&aYou have selected &l&aHuman!"));
                            }
                            break;
                        case 12:
                            //
                            if(click == ClickType.LEFT){
                                CCPlayerInfo.get().set(nick+".Race","Elf");
                                CCStats.get().set(nick+".Agility",Agility+5);
                                CCStats.get().set(nick+".Strength",Strength+5);
                                CCStats.save();
                                player.sendMessage(color("&aYou have selected &l&4Elf!"));
                            }
                            break;
                        case 13:
                            //
                            if(click == ClickType.LEFT){
                                CCPlayerInfo.get().set(nick+".Race","Dwarf");
                                CCStats.get().set(nick+".Strength",Strength+3);
                                CCStats.get().set(nick+"Defense",Defense+4);
                                CCStats.get().set(nick+".Health",Health+3);
                                CCStats.save();
                                player.sendMessage(color("&aYou have selected &l&aDwarf!"));
                            }
                            break;
                        case 14:
                            //
                            if(click == ClickType.LEFT){
                                CCPlayerInfo.get().set(nick+".Race","Dragonborn");
                                CCStats.get().set(nick+".Strength",Strength+5);
                                CCStats.get().set(nick+".Intelligence",Intelligence+5);
                                CCStats.save();
                                player.sendMessage(color("&aYou have selected &l&4Dragonborn"));
                            }
                            break;
                        case 15:
                            //
                            if(click == ClickType.LEFT){
                                CCPlayerInfo.get().set(nick+".Race","Undead");
                                CCStats.get().set(nick+".Health",Health-2);
                                CCStats.get().set(nick+".Intelligence",Intelligence+6);
                                CCStats.get().set(nick+".Wisdom",Wisdom+6);
                                CCStats.save();
                                player.sendMessage(color("&aYou have selected &l&6Undead!"));
                            }
                            break;
                    }
                }else{
                    player.sendMessage(color("&4&l(!) You already chose a race"));
                }
        }


        }
    }
}
