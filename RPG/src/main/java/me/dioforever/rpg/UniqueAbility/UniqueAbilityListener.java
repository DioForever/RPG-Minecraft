package me.dioforever.rpg.UniqueAbility;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import me.dioforever.rpg.files.CCother;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static me.dioforever.rpg.Utils.color;

public class UniqueAbilityListener implements Listener {
    private ItemStack Glass;
    private ItemStack WhiteGlass;
    private ItemStack Points;

    //Menu
    private ItemStack Profile;
    private ItemStack Skills;
    private ItemStack UniqueSkill;
    private ItemStack Magic;
    private ItemStack GuildI;
    private ItemStack Stats;





    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&6&lUnique Skill"))){

            //Player doesn´t have Menu opened
            return;

        }
        //Cancel all item  moving, editing, droping etc., and player inv too
        event.setCancelled(true);
        if(!event.getClickedInventory().equals(inv)){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int slot = event.getSlot();
        ClickType click = event.getClick();
        String nick = player.getName();
        int PointsInt = CCother.get().getInt(nick+".POINTS");

        //Glass
        Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta GlassMeta = Glass.getItemMeta();
        GlassMeta.setDisplayName(color("&0-----"));
        GlassMeta.setLore(Arrays.asList(color("")));
        Glass.setItemMeta(GlassMeta);

        //WhiteGlass
        WhiteGlass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta WhiteGlassMeta = WhiteGlass.getItemMeta();
        WhiteGlassMeta.setDisplayName(color("&f-----"));
        WhiteGlassMeta.setLore(Arrays.asList(color("")));
        WhiteGlass.setItemMeta(WhiteGlassMeta);

        //Points
        Points = new ItemStack(Material.ENDER_PEARL,PointsInt);
        ItemMeta PointsMeta = Points.getItemMeta();
        PointsMeta.setDisplayName(color("&5Stat Points: "+PointsInt));
        PointsMeta.setLore(Arrays.asList(color("")));
        Points.setItemMeta(PointsMeta);

        //Menu

        String UniqueAbility0 = CCSkills.get().getString(nick+".Skills.Unique");
        String Guild0 = CCPlayerInfo.get().getString(nick+".Guild");
        int Money0 = CCPlayerInfo.get().getInt(nick+".Money");
        int Health0 = CCStats.get().getInt(nick+".Health");
        int Defense0 = CCStats.get().getInt(nick+".Defense");
        int Intelligence0 = CCStats.get().getInt(nick+".Intelligence");
        int Luck0 = CCStats.get().getInt(nick+".Luck");
        int Agility0 = CCStats.get().getInt(nick+".Agility");
        int Strength0 = CCStats.get().getInt(nick+".Strength");
        int Wisdom0 = CCStats.get().getInt(nick+".Wisdom");
        int Regeneration0 = CCStats.get().getInt(nick+".Regeneration");
        int XP = CCPlayerInfo.get().getInt(nick+".XP");
        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
        int Level = CCPlayerInfo.get().getInt(nick+".Level");

        //ManaCapabilityItem
        Profile = new ItemStack(Material.NETHER_STAR,1);
        ItemMeta ProfileMeta = Profile.getItemMeta();
        ProfileMeta.setDisplayName(color("&b&lProfile of "+ player.getName()));
        ProfileMeta.setLore(Arrays.asList
                (color("&l&eGuild: "+Guild0),
                        color("&6Money: "+ Money0),
                        color("&6Level: "+Level),
                        color( "&6"+XP+"&6XP"+"&6/"+XPN+"&6XP"),
                        color("&l&aUnique Ability: "+ UniqueAbility0),
                        color("&4Health "+Health0),
                        color("&6Regeneration "+Regeneration0),
                        color("&cStrength "+Strength0),
                        color("&5Defense "+ Defense0),
                        color("&9Intelligence "+ Intelligence0),
                        color("&bWisdom "+ Wisdom0),
                        color("&eAgility "+ Agility0),
                        color("&2Luck "+Luck0)));
        Profile.setItemMeta(ProfileMeta);
        //Skills
        Skills = new ItemStack(Material.RED_CONCRETE,1);
        ItemMeta SkillsMeta = Skills.getItemMeta();
        SkillsMeta.setDisplayName(color("&4&lSkills"));
        SkillsMeta.setLore(Arrays.asList(color("&7Click to open Skills")));
        Skills.setItemMeta(SkillsMeta);
        //Magic
        Magic = new ItemStack(Material.PURPLE_CONCRETE,1);
        ItemMeta MagicMeta = Magic.getItemMeta();
        MagicMeta.setDisplayName(color("&5&lMagic"));
        MagicMeta.setLore(Arrays.asList(color("&7Click to open Magic")));
        Magic.setItemMeta(MagicMeta);
        //Guild
        GuildI = new ItemStack(Material.YELLOW_CONCRETE,1);
        ItemMeta GuildMeta = GuildI.getItemMeta();
        GuildMeta.setDisplayName(color("&e&lGuild"));
        GuildMeta.setLore(Arrays.asList(color("&7Click to open Guild")));
        GuildI.setItemMeta(GuildMeta);
        //UniqueSkill
        UniqueSkill = new ItemStack(Material.YELLOW_CONCRETE,1);
        ItemMeta UniqueSkillMeta = GuildI.getItemMeta();
        UniqueSkillMeta.setDisplayName(color("&6&lUnique Skill"));
        UniqueSkillMeta.setLore(Arrays.asList(color("&7Click to open Unique Skill")));
        UniqueSkill.setItemMeta(UniqueSkillMeta);
        //Stats
        Stats = new ItemStack(Material.LIGHT_BLUE_CONCRETE,1);
        ItemMeta StatsMeta = GuildI.getItemMeta();
        StatsMeta.setDisplayName(color("&b&lStats"));
        StatsMeta.setLore(Arrays.asList(color("&7Click to open Stats")));
        Stats.setItemMeta(StatsMeta);



        Inventory Menu = Bukkit.createInventory(null, 27, color("&b&lMenu"));
        Menu.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(4,editItem(Profile.clone(),1,Arrays.asList("")));
        Menu.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(10,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(11,editItem(Skills.clone(),1,Arrays.asList("")));
        Menu.setItem(12,editItem(Magic.clone(),1,Arrays.asList("")));
        Menu.setItem(13,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(14,editItem(GuildI.clone(),1,Arrays.asList("")));
        Menu.setItem(15,editItem(UniqueSkill.clone(),1,Arrays.asList("")));
        Menu.setItem(16,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(19,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(20,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(22,editItem(Stats.clone(),1,Arrays.asList("")));
        Menu.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(24,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(25,editItem(Glass.clone(),1,Arrays.asList()));
        Menu.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));





        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        if(click!=null) {
            switch (slot) {
                case 18:
                    //
                    if (click == ClickType.LEFT) {
                        player.openInventory(Menu);
                    }
                    break;
            }
        }


    }
    public ItemStack editItem(ItemStack item, int amount, List<String> lore){
        if(amount == 0) {
            //Can´t have item with amount 0
            amount = 1;
        }
        item.setAmount(amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setLore(lore);
        return item;

    }


}

