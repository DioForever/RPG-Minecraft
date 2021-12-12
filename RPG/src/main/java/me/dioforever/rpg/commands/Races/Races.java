package me.dioforever.rpg.commands.Races;

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
import java.util.Iterator;
import java.util.List;

import static me.dioforever.rpg.Utils.color;


public class Races implements CommandExecutor {

    private ItemStack Human;
    private ItemStack Elf;
    private ItemStack Dwarf;
    private ItemStack Dragonborn;
    private ItemStack Undead;

    private ItemStack Glass;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            //Creating inventory
            Inventory races = Bukkit.createInventory(null, 27,color("&5&lChoose a race"));

            //Glass
            Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
            ItemMeta GlassMeta = Glass.getItemMeta();
            GlassMeta.setDisplayName(color("&0-----"));
            GlassMeta.setLore(Arrays.asList(color("")));
            Glass.setItemMeta(GlassMeta);

            //Human - Race
            Human = new ItemStack(Material.LLAMA_SPAWN_EGG,1);
            ItemMeta HumanMeta = Human.getItemMeta();
            HumanMeta.setDisplayName(color("&l&aThe Human Race "));
            HumanMeta.setLore(Arrays.asList
                    (color("&aThe Human race is race which"),
                            color("&ais not good specifically at anything."),
                            color( "&eAgility +2"),
                            color("&cStrength +2"),
                            color("&5Defense +2"),
                            color("&4Health +2"),
                            color("&3Intelligence +2")));
            Human.setItemMeta(HumanMeta);
            //Elf - Race
            Elf = new ItemStack(Material.CREEPER_SPAWN_EGG,1);
            ItemMeta ElfMeta = Elf.getItemMeta();
            ElfMeta.setDisplayName(color("&l&2The Elf Race "));
            ElfMeta.setLore(Arrays.asList
                    (color("&aThe Elf race is race has good agility,"),
                            color("&aintelligence and strength."),
                            color( "&eAgility +5"),
                            color("&cStrength +5")));
            Elf.setItemMeta(ElfMeta);
            //Dwarf - Race
            Dwarf = new ItemStack(Material.BAT_SPAWN_EGG,1);
            ItemMeta DwarfMeta = Dwarf.getItemMeta();
            DwarfMeta.setDisplayName(color("&l&eThe Dwarf Race "));
            DwarfMeta.setLore(Arrays.asList
                    (color("&aThe Dwarf race is has high defense,"),
                            color("&ahealth, strength."),
                            color( "&5Defense +4"),
                            color("&4Health +3"),
                            color("&cStrength +3")));
            Dwarf.setItemMeta(DwarfMeta);
            //Dragonborn - Race
            Dragonborn = new ItemStack(Material.SPIDER_SPAWN_EGG,1);
            ItemMeta DragonbornMeta = Dragonborn.getItemMeta();
            DragonbornMeta.setDisplayName(color("&l&4The Dragonborn Race "));
            DragonbornMeta.setLore(Arrays.asList
                    (color("&aThe Dragonborn race has high intelligence"),
                            color("&aand strength."),
                            color( "&3Intelligence +5"),
                            color("&cStrength +5")));
            Dragonborn.setItemMeta(DragonbornMeta);
            //Undead - Race
            Undead = new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG,1);
            ItemMeta UndeadMeta = Undead.getItemMeta();
            UndeadMeta.setDisplayName(color("&l&7The Undead"));
            UndeadMeta.setLore(Arrays.asList
                    (color("&aThe Undead race has high intelligence"),
                            color("&aand wisdom"),
                            color( "&3Intelligence +6"),
                            color("&bWisdom + 6"),
                            color("&4Health -2")));
            Undead.setItemMeta(UndeadMeta);

            //Inventory Race - Settings
            races.setItem(0,Glass);
            races.setItem(1,Glass);
            races.setItem(2,Glass);
            races.setItem(3,Glass);
            races.setItem(4,Glass);
            races.setItem(5,Glass);
            races.setItem(6,Glass);
            races.setItem(7,Glass);
            races.setItem(8,Glass);
            races.setItem(9,Glass);
            races.setItem(10,Glass);
            races.setItem(11,editItem(Human.clone(),1,Arrays.asList()));
            races.setItem(12,editItem(Elf.clone(),1,Arrays.asList()));
            races.setItem(13,editItem(Dwarf.clone(),1,Arrays.asList()));
            races.setItem(14,editItem(Dragonborn.clone(),1,Arrays.asList()));
            races.setItem(15,editItem(Undead.clone(),1,Arrays.asList()));
            races.setItem(16,Glass);
            races.setItem(17,Glass);
            races.setItem(18,Glass);
            races.setItem(19,Glass);
            races.setItem(20,Glass);
            races.setItem(21,Glass);
            races.setItem(22,Glass);
            races.setItem(23,Glass);
            races.setItem(24,Glass);
            races.setItem(25,Glass);
            races.setItem(26,Glass);

            player.openInventory(races);
        }

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
