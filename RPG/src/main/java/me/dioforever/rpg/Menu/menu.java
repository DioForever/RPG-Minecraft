package me.dioforever.rpg.Menu;

import me.dioforever.rpg.files.CCPlayerInfo;
import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static me.dioforever.rpg.Utils.color;

public class menu implements CommandExecutor {

    private ItemStack Profile;
    private ItemStack Glass;
    private ItemStack Skills;
    private ItemStack UniqueSkill;
    private ItemStack Magic;
    private ItemStack GuildI;
    private ItemStack Stats;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("This feature is allowed only for players!");
            return true;
        }
        Player player = (Player) sender;
        String nick = player.getName();
        String UniqueAbility = CCSkills.get().getString(nick+".Skills.Unique");
        String Guild = CCPlayerInfo.get().getString(nick+".Guild");
        int Money = CCPlayerInfo.get().getInt(nick+".Money");
        int Health = CCStats.get().getInt(nick+".Health");
        int Defense = CCStats.get().getInt(nick+".Defense");
        int Intelligence = CCStats.get().getInt(nick+".Intelligence");
        int Luck = CCStats.get().getInt(nick+".Luck");
        int Agility = CCStats.get().getInt(nick+".Agility");
        int Strength = CCStats.get().getInt(nick+".Strength");
        int Wisdom = CCStats.get().getInt(nick+".Wisdom");
        int Regeneration = CCStats.get().getInt(nick+".Regeneration");
        int XP = CCPlayerInfo.get().getInt(nick+".XP");
        int XPN = CCPlayerInfo.get().getInt(nick+".XPNeeded");
        int Level = CCPlayerInfo.get().getInt(nick+".Level");
        String race = CCPlayerInfo.get().getString(nick+".Race");


        //ManaCapabilityItem
        Profile = new ItemStack(Material.NETHER_STAR,1);
        ItemMeta ProfileMeta = Profile.getItemMeta();
        ProfileMeta.setDisplayName(color("&b&lProfile of "+ sender.getName()));
        ProfileMeta.setLore(Arrays.asList
                        (color("&l&eGuild: "+Guild),
                        color("&6Level: "+Level),
                        color( "&6"+XP+"&6XP"+"&6/"+XPN+"&6XP"),
                        color("&aRace: &l"+race),
                        color("&6Money: "+ Money),
                        color("&l&aUnique Ability: "+ UniqueAbility),
                        color("&4Health "+Health),
                        color("&6Regeneration "+Regeneration),
                        color("&cStrength "+Strength),
                        color("&5Defense "+ Defense),
                        color("&9Intelligence "+ Intelligence),
                        color("&bWisdom "+ Wisdom),
                        color("&eAgility "+ Agility),
                        color("&2Luck "+Luck)));
        Profile.setItemMeta(ProfileMeta);
        //Glass
        Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta GlassMeta = Glass.getItemMeta();
        GlassMeta.setDisplayName(color("&0-----"));
        GlassMeta.setLore(Arrays.asList(color("")));
        Glass.setItemMeta(GlassMeta);
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
        player.openInventory(Menu);


        return true;
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
