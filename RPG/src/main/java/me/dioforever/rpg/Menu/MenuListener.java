package me.dioforever.rpg.Menu;

import me.dioforever.rpg.files.CCSkills;
import me.dioforever.rpg.files.CCStats;
import me.dioforever.rpg.files.CCother;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Statement;
import java.util.*;

import static me.dioforever.rpg.Utils.color;

public class MenuListener implements Listener {

    private ItemStack Glass;
    private ItemStack WhiteGlass;
    private ItemStack Plus;
    private ItemStack Points;
    private ItemStack Health;
    private ItemStack Defense;
    private ItemStack Strength;
    private ItemStack Agility;
    private ItemStack Intelligence;
    private ItemStack Wisdom;
    private ItemStack Regeneration;
    private ItemStack Luck;
    
    
    //Example
    private ItemStack ExampleI;
    private ItemStack ExampleII;
    private ItemStack ExampleIII;


    //Runner
    private ItemStack RunnerI;
    private ItemStack RunnerII;
    private ItemStack RunnerIII;
    //Tank
    private ItemStack TankI;
    private ItemStack TankII;
    private ItemStack TankIII;
    //Jumper
    private ItemStack JumperI;
    private ItemStack JumperII;
    private ItemStack JumperIII;

    //Lucker
    private ItemStack LuckerI;
    private ItemStack LuckerII;
    private ItemStack LuckerIII;

    //Third Eye
    private ItemStack ThirdEyeI;
    private ItemStack ThirdEyeII;
    private ItemStack ThirdEyeIII;

    //Blood Thief
    private ItemStack BloodThiefI;
    private ItemStack BloodThiefII;
    private ItemStack BloodThiefIII;

    //Mana Affinity
    private ItemStack ManaAffinityI;
    private ItemStack ManaAffinityII;
    private ItemStack ManaAffinityIII;


    //Night Watcher
    private ItemStack NightWatcherI;
    private ItemStack NightWatcherII;
    private ItemStack NightWatcherIII;


    //Power of Giant
    private ItemStack PowerOfGiantI;
    private ItemStack PowerOfGiantII;
    private ItemStack PowerOfGiantIII;


    //Master Swordsman
    private ItemStack MasterSwordsmanI;
    private ItemStack MasterSwordsmanII;
    private ItemStack MasterSwordsmanIII;


    //Master Archer
    private ItemStack MasterArcherI;
    private ItemStack MasterArcherII;
    private ItemStack MasterArcherIII;


    //Commander
    private ItemStack CommanderI;
    private ItemStack CommanderII;
    private ItemStack CommanderIII;

    //Solo
    private ItemStack SoloI;
    private ItemStack SoloII;
    private ItemStack SoloIII;

    //Regenerate
    private ItemStack RegenerateI;
    private ItemStack RegenerateII;
    private ItemStack RegenerateIII;

    //Reinforcements
    private ItemStack ReinforcementsI;
    private ItemStack ReinforcementsII;
    private ItemStack ReinforcementsIII;






    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        if(!event.getView().getTitle().equalsIgnoreCase(color("&b&lMenu"))){

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
        WhiteGlassMeta.setDisplayName(color("&l&bMenu"));
        WhiteGlassMeta.setLore(Arrays.asList(color("&bClick to go back to Menu")));
        WhiteGlass.setItemMeta(WhiteGlassMeta);

        //Points
        Points = new ItemStack(Material.ENDER_PEARL,PointsInt);
        ItemMeta PointsMeta = Points.getItemMeta();
        PointsMeta.setDisplayName(color("&5Stat Points: "+PointsInt));
        PointsMeta.setLore(Arrays.asList(color("")));
        Points.setItemMeta(PointsMeta);

        int HealthStat = CCStats.get().getInt(nick+".Health");
        int MAXHP = CCother.get().getInt(nick+".Health");
        int HPWRITE = MAXHP-100;
        //Health
        Health = new ItemStack(Material.RED_WOOL);
        ItemMeta HealthMeta = Health.getItemMeta();
        HealthMeta.setDisplayName(color("&l&4Health: "+HealthStat));
        HealthMeta.setLore(Arrays.asList(
                color("&4This stat increases the Health you can have"),
                color("&4You get 1HP for every 5 Points invested in Health"),
                color("&4You already acquired: "+(MAXHP-100)+"&4HP")));
        Health.setItemMeta(HealthMeta);

        int DefenseStat = CCStats.get().getInt(nick+".Defense");
        //Defense
        Defense = new ItemStack(Material.PURPLE_WOOL);
        ItemMeta DefenseMeta = Defense.getItemMeta();
        DefenseMeta.setDisplayName(color("&l&5Defense: "+DefenseStat));
        DefenseMeta.setLore(Arrays.asList(
                color("&5This stat increases the Defense you can have"),
                color("&5You get 1% less damage for every 3 Points invested in Defense"),
                color("&5You already acquired: "+(DefenseStat/3)+"&5% less damage")));
        Defense.setItemMeta(DefenseMeta);

        int StrengthStat = CCStats.get().getInt(nick+".Strength");
        //Strength
        Strength = new ItemStack(Material.RED_CONCRETE);
        ItemMeta StrengthMeta = Strength.getItemMeta();
        StrengthMeta.setDisplayName(color("&l&cStrength: "+StrengthStat));
        StrengthMeta.setLore(Arrays.asList(
                color("&cThis stat increases the Strength you can have"),
                color("&cYou get 1% more damage for every 2 Points invested in Strength"),
                color("&cYou already acquired: "+(StrengthStat/2)+"&c% more damage")));
        Strength.setItemMeta(StrengthMeta);

        int AgilityStat = CCStats.get().getInt(nick+".Agility");
        //Agility
        Agility = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta AgilityMeta = Agility.getItemMeta();
        AgilityMeta.setDisplayName(color("&l&eAgility: "+AgilityStat));
        AgilityMeta.setLore(Arrays.asList(
                color("&eThis stat increases the Agility you can have"),
                color("&eYou get 1% more speed for every Point invested in Agility"),
                color("&eYou already acquired: "+(AgilityStat)+"&e% more speed")));
        Agility.setItemMeta(AgilityMeta);

        int IntelStat = CCStats.get().getInt(nick+".Intelligence");
        //Intelligence
        Intelligence = new ItemStack(Material.CYAN_WOOL);
        ItemMeta IntelligenceMeta = Intelligence.getItemMeta();
        IntelligenceMeta.setDisplayName(color("&l&3Intelligence: "+IntelStat));
        IntelligenceMeta.setLore(Arrays.asList(
                color("&3This stat increases the Mana you can have"),
                color("&3You get 5MP more for every Point invested in Intelligence"),
                color("&3You already acquired: "+(IntelStat*5)+"&3 more Mana")));
        Intelligence.setItemMeta(IntelligenceMeta);

        int WisdomStat = CCStats.get().getInt(nick+".Wisdom");
        //Wisdom
        Wisdom = new ItemStack(Material.LIGHT_BLUE_WOOL);
        ItemMeta WisdomMeta = Wisdom.getItemMeta();
        WisdomMeta.setDisplayName(color("&l&bWisdom: "+WisdomStat));
        WisdomMeta.setLore(Arrays.asList(
                color("&bThis stat increases the Mana Regeneration you can have"),
                color("&bYou get 1MP/s for every Point invested in Wisdom"),
                color("&bYou already acquired: "+(WisdomStat/2)+"&bMP/s Mana Regeneration")));
        Wisdom.setItemMeta(WisdomMeta);

        int RegenStat = CCStats.get().getInt(nick+".Regeneration");
        //Regeneration
        Regeneration = new ItemStack(Material.ORANGE_WOOL);
        ItemMeta RegenerationMeta = Regeneration.getItemMeta();
        RegenerationMeta.setDisplayName(color("&l&6Regeneration: "+RegenStat));
        RegenerationMeta.setLore(Arrays.asList(
                color("&6This stat increases the Regeneration you can have"),
                color("&6You get 1HP/2.5s or 4s more Regen speed for every 50"),
                color("&6Points invested in Regeneration"),
                color("&6You already acquired: "+(RegenStat/50)+"&6HP/2.5s or 4s more Regeneration")));
        Regeneration.setItemMeta(RegenerationMeta);

        int LuckStat = CCStats.get().getInt(nick+".Luck");
        //Luck
        Luck = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta LuckMeta = Luck.getItemMeta();
        LuckMeta.setDisplayName(color("&l&aLuck: "+LuckStat));
        LuckMeta.setLore(Arrays.asList(
                color("&aThis stat increases the LUCK you can have"),
                color("&aYou get 1% more luck for every Point invested in Luck"),
                color("&aYou already acquired: "+(LuckStat)+"&a% more luck")));
        Luck.setItemMeta(LuckMeta);

        //Plus
        Plus = new ItemStack(Material.SUNFLOWER);
        ItemMeta PlusMeta = Plus.getItemMeta();
        PlusMeta.setDisplayName(color("&eClick to add Stat points"));
        PlusMeta.setLore(Arrays.asList(color("")));
        Plus.setItemMeta(PlusMeta);

        Inventory Stats = Bukkit.createInventory(null,54,color("&b&lStats"));

        Stats.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(4,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(10,editItem(Health.clone(),HealthStat,Arrays.asList()));
        Stats.setItem(11,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(12,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(13,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(14,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(15,editItem(Intelligence.clone(),IntelStat,Arrays.asList()));
        Stats.setItem(16,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(18,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(19,editItem(Defense.clone(),DefenseStat,Arrays.asList()));
        Stats.setItem(20,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(22,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(24,editItem(Wisdom.clone(),WisdomStat,Arrays.asList()));
        Stats.setItem(25,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(27,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(28,editItem(Strength.clone(),StrengthStat,Arrays.asList()));
        Stats.setItem(29,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(30,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(31,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(32,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(33,editItem(Regeneration.clone(),RegenStat,Arrays.asList()));
        Stats.setItem(34,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(35,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(36,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(37,editItem(Agility.clone(),AgilityStat,Arrays.asList()));
        Stats.setItem(38,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(39,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(40,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(41,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(42,editItem(Luck.clone(),LuckStat,Arrays.asList()));
        Stats.setItem(43,editItem(Plus.clone(),1,Arrays.asList()));
        Stats.setItem(44,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(45,editItem(WhiteGlass.clone(),1,Arrays.asList()));
        Stats.setItem(46,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(47,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(48,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(49,editItem(Points.clone(),1,Arrays.asList()));
        Stats.setItem(50,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(51,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(52,editItem(Glass.clone(),1,Arrays.asList()));
        Stats.setItem(53,editItem(Glass.clone(),1,Arrays.asList()));

        String UniqueAbility = CCSkills.get().getString(nick+".Skills.Unique");
        //Example I
        ExampleI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta ExampleIMeta = ExampleI.getItemMeta();
        ExampleIMeta.setDisplayName(color("&l&bRunner I "));
        ExampleIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to run 10% faster")));
        ExampleI.setItemMeta(ExampleIMeta);

        //ExampleII
        if(UniqueAbility.contains("Example II") || UniqueAbility.contains("Example III")){
            ExampleII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ExampleII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta ExampleIIMeta = ExampleII.getItemMeta();
        ExampleIIMeta.setDisplayName(color("&l&bExample II "));
        ExampleIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to run 20% faster")));
        ExampleII.setItemMeta(ExampleIIMeta);

        //ExampleIII
        if(UniqueAbility.contains("Example III")){
            ExampleIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ExampleIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta ExampleIIIMeta = ExampleIII.getItemMeta();
        ExampleIIIMeta.setDisplayName(color("&l&6Example III "));
        ExampleIIIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to run 30% faster")));
        ExampleIII.setItemMeta(ExampleIIIMeta);

        //Regenerate I
        RegenerateI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta RegenerateIMeta = RegenerateI.getItemMeta();
        RegenerateIMeta.setDisplayName(color("&l&bRunner I "));
        RegenerateIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to regenerate 10% faster")));
        RegenerateI.setItemMeta(RegenerateIMeta);

        //RegenerateII
        if(UniqueAbility.contains("Regenerate II") || UniqueAbility.contains("Regenerate III")){
            RegenerateII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            RegenerateII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta RegenerateIIMeta = ExampleII.getItemMeta();
        RegenerateIIMeta.setDisplayName(color("&l&bRegenerate II "));
        RegenerateIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to regenerate 20% faster")));
        RegenerateII.setItemMeta(RegenerateIIMeta);

        //RegenerateIII
        if(UniqueAbility.contains("Regenerate III")){
            RegenerateIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            RegenerateIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta RegenerateIIIMeta = RegenerateIII.getItemMeta();
        RegenerateIIIMeta.setDisplayName(color("&l&6Regenerate III "));
        RegenerateIIIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to regenerate 30% faster")));
        RegenerateIII.setItemMeta(RegenerateIIIMeta);

        //Reinforcements I
        ReinforcementsI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta ReinforcementsIMeta = ReinforcementsI.getItemMeta();
        ReinforcementsIMeta.setDisplayName(color("&l&bReinforcement I "));
        ReinforcementsIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to get 5% less damage")));
        ReinforcementsI.setItemMeta(ReinforcementsIMeta);

        //ReinforcementsII
        if(UniqueAbility.contains("Reinforcement II") || UniqueAbility.contains("ReinforcementsIII")){
            ReinforcementsII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ReinforcementsII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta ReinforcementsIIMeta = ReinforcementsII.getItemMeta();
        ReinforcementsIIMeta.setDisplayName(color("&l&bReinforcement II "));
        ReinforcementsIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to get 10% less damage")));
        ReinforcementsII.setItemMeta(ReinforcementsIIMeta);

        //ExampleIII
        if(UniqueAbility.contains("Reinforcement III")){
            ReinforcementsIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ReinforcementsIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta ReinforcementsIIIMeta = ReinforcementsIII.getItemMeta();
        ReinforcementsIIIMeta.setDisplayName(color("&l&6Reinforcement III "));
        ReinforcementsIIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you &7&lHard as Rock Skill")));
        ReinforcementsIII.setItemMeta(ReinforcementsIIIMeta);

        //Solo I
        SoloI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta SoloIMeta = SoloI.getItemMeta();
        SoloIMeta.setDisplayName(color("&l&6Solo I "));
        SoloIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to debuff Players around"),
                color("&you by 15% every stat")));
        SoloI.setItemMeta(SoloIMeta);

        //SoloII
        if(UniqueAbility.contains("Solo II") || UniqueAbility.contains("Solo III")){
            SoloII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            SoloII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta SoloIIMeta = ExampleII.getItemMeta();
        SoloIIMeta.setDisplayName(color("&l&6Solo II "));
        SoloIIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to debuff Players around"),
                color("&you by 15% every stat")));
        SoloII.setItemMeta(SoloIIMeta);

        //SoloIII
        if(UniqueAbility.contains("Solo III")){
            SoloIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            SoloIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta SoloIIIMeta = SoloIII.getItemMeta();
        SoloIIIMeta.setDisplayName(color("&l&bSolo III "));
        SoloIIIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to debuff Players around"),
                color("&you by 15% every stat")));
        SoloIII.setItemMeta(SoloIIIMeta);

        //Commander I
        CommanderI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta CommanderIMeta = CommanderI.getItemMeta();
        CommanderIMeta.setDisplayName(color("&l&6Commander I "));
        CommanderIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to boost Players around"),
                color("&you by 5% every stat")));
        CommanderI.setItemMeta(CommanderIMeta);

        //CommanderII
        if(UniqueAbility.contains("Commander II") || UniqueAbility.contains("Commander III")){
            CommanderII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            CommanderII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta CommanderIIMeta = CommanderII.getItemMeta();
        CommanderIIMeta.setDisplayName(color("&l&6Commander II "));
        CommanderIIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to boost Players around"),
                color("&you by 10% every stat")));
        CommanderII.setItemMeta(CommanderIIMeta);

        //CommanderIII
        if(UniqueAbility.contains("Commander III")){
            CommanderIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            CommanderIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta CommanderIIIMeta = ExampleIII.getItemMeta();
        CommanderIIIMeta.setDisplayName(color("&l&6Commander III "));
        CommanderIIIMeta.setLore(Arrays.asList(color("&bThis Ability allows you to boost Players around"),
                                                color("&you by 15% every stat")));
        CommanderIII.setItemMeta(CommanderIIIMeta);

        //MasterArcherI
        MasterArcherI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta MasterArcherIMeta = MasterArcherI.getItemMeta();
        MasterArcherIMeta.setDisplayName(color("&l&eMaster Archer I "));
        MasterArcherIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you 5% more damage with Bows")));
        MasterArcherI.setItemMeta(MasterArcherIMeta);

        //MasterArcherII
        if(UniqueAbility.contains("Master Archer II") || UniqueAbility.contains("MasterArcher III")){
            MasterArcherII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            MasterArcherII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta MasterArcherIIMeta = MasterArcherII.getItemMeta();
        MasterArcherIIMeta.setDisplayName(color("&l&eMaster Archer II "));
        MasterArcherIIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you"),
                color("v10% more damage with Bows")));
        MasterArcherII.setItemMeta(MasterArcherIIMeta);
        //MasterArcherIII
        if(UniqueAbility.contains("Master Archer III")){
            MasterArcherIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            MasterArcherIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta MasterArcherIIIMeta = MasterArcherIII.getItemMeta();
        MasterArcherIIIMeta.setDisplayName(color("&l&eMaster Archer III "));
        MasterArcherIIIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you"),
                color("&b15% more damage with Bows")));
        MasterArcherIII.setItemMeta(MasterArcherIIIMeta);

        //MasterSwordsman I
        MasterSwordsmanI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta MasterSwordsmanIMeta = MasterSwordsmanI.getItemMeta();
        MasterSwordsmanIMeta.setDisplayName(color("&l&4Master Swordsman I "));
        MasterSwordsmanIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you"),
                color("&b5% more damage with swords")));
        MasterSwordsmanI.setItemMeta(MasterSwordsmanIMeta);

        //MasterSwordsmanII
        if(UniqueAbility.contains("Master Swordsman II") || UniqueAbility.contains("Master Swordsman III")){
            MasterSwordsmanII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            MasterSwordsmanII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta MasterSwordsmanIIMeta = ExampleII.getItemMeta();
        MasterSwordsmanIIMeta.setDisplayName(color("&l&4Master Swordsman II "));
        MasterSwordsmanIIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you"),
                color("&b10% more damage with swords")));
        MasterSwordsmanII.setItemMeta(MasterSwordsmanIIMeta);

        //MasterSwordsmanIII
        if(UniqueAbility.contains("Master Swordsman III")){
            MasterSwordsmanIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            MasterSwordsmanIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta MasterSwordsmanIIIMeta = MasterSwordsmanIII.getItemMeta();
        MasterSwordsmanIIIMeta.setDisplayName(color("&l&4Master Swordsman III "));
        MasterSwordsmanIIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you &4&lSwords Ambition Skill")));
        MasterSwordsmanIII.setItemMeta(MasterSwordsmanIIIMeta);


        //PowerOfGiant I
        PowerOfGiantI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta PowerOfGiantIMeta = PowerOfGiantI.getItemMeta();
        PowerOfGiantIMeta.setDisplayName(color("&l&bPower of Giant I "));
        PowerOfGiantIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you 5 Strength points")));
        PowerOfGiantI.setItemMeta(PowerOfGiantIMeta);

        //PowerOfGiantII
        if(UniqueAbility.contains("Power of Giant II") || UniqueAbility.contains("Power of Giant III")){
            PowerOfGiantII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            PowerOfGiantII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta PowerOfGiantIIMeta = ExampleII.getItemMeta();
        PowerOfGiantIIMeta.setDisplayName(color("&l&bPower of Giant II "));
        PowerOfGiantIIMeta.setLore(Arrays.asList(
                color("&bThis Ability grants you 10 Strength points")));
        PowerOfGiantII.setItemMeta(PowerOfGiantIIMeta);

        //PowerOfGiantIII
        if(UniqueAbility.contains("Power of Giant III")){
            PowerOfGiantIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            PowerOfGiantIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta PowerOfGiantIIIMeta = PowerOfGiantIII.getItemMeta();
        PowerOfGiantIIIMeta.setDisplayName(color("&l&bPower of Giant III "));
        PowerOfGiantIIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you &4&lUltimate Giant Skill")));
        PowerOfGiantIII.setItemMeta(PowerOfGiantIIIMeta);

        //NightWatcher I
        NightWatcherI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta NightWatcherIMeta = NightWatcherI.getItemMeta();
        NightWatcherIMeta.setDisplayName(color("&l&bNight Watcher I "));
        NightWatcherIMeta.setLore(Arrays.asList(
                color("&bThis Ability gives you Night Vision Effect")));
        NightWatcherI.setItemMeta(NightWatcherIMeta);

        //NightWatcherII
        if(UniqueAbility.contains("Night Watcher II") || UniqueAbility.contains("Night Watcher III")){
            NightWatcherII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            NightWatcherII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta NightWatcherIIMeta = NightWatcherII.getItemMeta();
        NightWatcherIIMeta.setDisplayName(color("&l&bNight Watcher II "));
        NightWatcherIIMeta.setLore(Arrays.asList(color("&bThis Ability gives you &1&lNight Walking Skill")));
        NightWatcherII.setItemMeta(NightWatcherIIMeta);

        //NightWatcherIII
        if(UniqueAbility.contains("Nigh tWatcher III")){
            NightWatcherIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            NightWatcherIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta NightWatcherIIIMeta = ExampleIII.getItemMeta();
        NightWatcherIIIMeta.setDisplayName(color("&l&bNight Watcher III "));
        NightWatcherIIIMeta.setLore(Arrays.asList(color("&bThis Ability gives you &1&lNight Walker Skill")));
        NightWatcherIII.setItemMeta(NightWatcherIIIMeta);


        //ManaAffinity I
        ManaAffinityI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta ManaAffinityIMeta = ManaAffinityI.getItemMeta();
        ManaAffinityIMeta.setDisplayName(color("&l&bMana Affinity I "));
        ManaAffinityIMeta.setLore(Arrays.asList(
                color("&bThis Ability gives you 3 Intelligence points and 3 Wisdom points")));
        ManaAffinityI.setItemMeta(ManaAffinityIMeta);

        //ManaAffinityII
        if(UniqueAbility.contains("Mana Affinity II") || UniqueAbility.contains("Mana Affinity III")){
            ManaAffinityII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ManaAffinityII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta ManaAffinityIIMeta = ExampleII.getItemMeta();
        ManaAffinityIIMeta.setDisplayName(color("&l&bMana Affinity II "));
        ManaAffinityIIMeta.setLore(Arrays.asList(
                color("&bThis Ability gives you 5 Intelligence points and 5 Wisdom points")));
        ManaAffinityII.setItemMeta(ManaAffinityIIMeta);

        //ManaAffinityIII
        if(UniqueAbility.contains("Mana Affinity III")){
            ManaAffinityIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ManaAffinityIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta ManaAffinityIIIMeta = ManaAffinityIII.getItemMeta();
        ManaAffinityIIIMeta.setDisplayName(color("&l&bMana Affinity III "));
        ManaAffinityIIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you &b&lMana Control Skill")));
        ManaAffinityIII.setItemMeta(ManaAffinityIIIMeta);


        //BloodThief I
        BloodThiefI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta BloodThiefIMeta = BloodThiefI.getItemMeta();
        BloodThiefIMeta.setDisplayName(color("&l&bBlood Thief I "));
        BloodThiefIMeta.setLore(Arrays.asList(
                color("&bThis Ability doens´t heal you for hitting enemy, yet")));
        BloodThiefI.setItemMeta(BloodThiefIMeta);

        //BloodThiefII
        if(UniqueAbility.contains("Blood Thief II") || UniqueAbility.contains("Blood Thief III")){
            BloodThiefII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            BloodThiefII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta BloodThiefIIMeta = BloodThiefII.getItemMeta();
        BloodThiefIIMeta.setDisplayName(color("&l&bBlood Thief II "));
        BloodThiefIIMeta.setLore(Arrays.asList(
                color("&bThis Ability steals HP of enemy"),
                color("&band heals you of 5% of enemy HP")));
        BloodThiefII.setItemMeta(BloodThiefIIMeta);

        //BloodThiefIII
        if(UniqueAbility.contains("Blood Thief III")){
            BloodThiefIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            BloodThiefIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta BloodThiefIIIMeta = BloodThiefIII.getItemMeta();
        BloodThiefIIIMeta.setDisplayName(color("&l&bBlood Thief III "));
        BloodThiefIIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you the &4&lBloody Killer Skill")));
        BloodThiefIII.setItemMeta(BloodThiefIIIMeta);




        //ThirdEye I
        ThirdEyeI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta ThirdEyeIMeta = ThirdEyeI.getItemMeta();
        ThirdEyeIMeta.setDisplayName(color("&l&bThird Eye I "));
        ThirdEyeIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to show stats of enemy")));
        ThirdEyeI.setItemMeta(ThirdEyeIMeta);

        //ThirdEyeII
        if(UniqueAbility.contains("Third Eye II") || UniqueAbility.contains("Third Eye III")){
            ThirdEyeII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ThirdEyeII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta ThirdEyeIIMeta = ThirdEyeII.getItemMeta();
        ThirdEyeIIMeta.setDisplayName(color("&l&bThird Eye II "));
        ThirdEyeIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to"),
                color("&bshow more stats of enemy")));
        ThirdEyeII.setItemMeta(ThirdEyeIIMeta);
        //ThirdEyeIII
        if(UniqueAbility.contains("Third Eye III")){
            ThirdEyeIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            ThirdEyeIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta ThirdEyeIIIMeta = ThirdEyeIII.getItemMeta();
        ThirdEyeIIIMeta.setDisplayName(color("&l&bThird Eye III "));
        ThirdEyeIIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to see"),
                color("&ball stats and gives you &2&lThird Eye Sage Skill")));
        ThirdEyeIII.setItemMeta(ThirdEyeIIIMeta);



        //Runner
        //Runner I
        RunnerI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta RunnerIMeta = RunnerI.getItemMeta();
        RunnerIMeta.setDisplayName(color("&l&bRunner I "));
        RunnerIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to run 10% faster")));
        RunnerI.setItemMeta(RunnerIMeta);

        //Runner II
        if(UniqueAbility.contains("Runner II") || UniqueAbility.contains("Runner III")){
            RunnerII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            RunnerII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta RunnerIIMeta = RunnerII.getItemMeta();
        RunnerIIMeta.setDisplayName(color("&l&bRunner II "));
        RunnerIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to run 20% faster")));
        RunnerII.setItemMeta(RunnerIIMeta);
        //Runner III
        if(UniqueAbility.contains("Runner III")){
            RunnerIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            RunnerIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta RunnerIIIMeta = RunnerIII.getItemMeta();
        RunnerIIIMeta.setDisplayName(color("&l&bRunner III "));
        RunnerIIIMeta.setLore(Arrays.asList(
                color("&bThis Ability allows you to run 30% faster")));
        RunnerIII.setItemMeta(RunnerIIIMeta);

        //Tank
        //Tank 1
        TankI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta TankIMeta = TankI.getItemMeta();
        TankIMeta.setDisplayName(color("&l&4Tank I "));
        TankIMeta.setLore(Arrays.asList(
                color("&4This Ability gives you 2.5HP")));
        TankI.setItemMeta(TankIMeta);

        //Tank II
        if(UniqueAbility.contains("Tank II") || UniqueAbility.contains("Tank III")){
            TankII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            TankII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta TankIIMeta = TankII.getItemMeta();
        TankIIMeta.setDisplayName(color("&l&4Tank II "));
        TankIIMeta.setLore(Arrays.asList(
                color("&4This Ability gives you 5HP")));
        TankII.setItemMeta(TankIIMeta);
        //Tank III
        if(UniqueAbility.contains("Tank III")){
            TankIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            TankIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta TankIIIMeta = TankIII.getItemMeta();
        TankIIIMeta.setDisplayName(color("&l&4Tank III "));
        TankIIIMeta.setLore(Arrays.asList(
                color("&4This Ability gives you 10HP")));
        TankIII.setItemMeta(TankIIIMeta);

        //Jumper
        //Jumper 1
        JumperI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta JumperIMeta = TankI.getItemMeta();
        JumperIMeta.setDisplayName(color("&l&4Jumper I "));
        JumperIMeta.setLore(Arrays.asList(
                color("&4This Ability gives you Jump Boost I")));
        JumperI.setItemMeta(JumperIMeta);

        //Jumper II
        if(UniqueAbility.contains("Jumper II") || UniqueAbility.contains("Jumper III")){
            JumperII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            JumperII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta JumperIIMeta = JumperII.getItemMeta();
        JumperIIMeta.setDisplayName(color("&l&4Jumper II "));
        JumperIIMeta.setLore(Arrays.asList(
                color("&4This Ability gives you Jump Boost II")));
        JumperII.setItemMeta(JumperIIMeta);
        //Jumper III
        if(UniqueAbility.contains("Tank III")){
            JumperIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            JumperIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta JumperIIIMeta = JumperIII.getItemMeta();
        JumperIIIMeta.setDisplayName(color("&l&4Jumper III "));
        JumperIIIMeta.setLore(Arrays.asList(
                color("&4This Ability gives you Jump Boost III")));
        JumperIII.setItemMeta(JumperIIIMeta);

        //LuckerI
        LuckerI = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta LuckerIMeta = LuckerI.getItemMeta();
        LuckerIMeta.setDisplayName(color("&l&aLucker I "));
        LuckerIMeta.setLore(Arrays.asList(color("&bThis Ability grants you 5 Luck Points!")));
        LuckerI.setItemMeta(LuckerIMeta);

        //LuckerII
        if(UniqueAbility.contains("Lucker II") || UniqueAbility.contains("Lucker III")){
            LuckerII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            LuckerII = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        }
        ItemMeta LuckerIIMeta = LuckerII.getItemMeta();
        LuckerIIMeta.setDisplayName(color("&l&aLucker II"));
        LuckerIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you 10 Luck Points!")));
        LuckerII.setItemMeta(LuckerIIMeta);
        //LuckerIII
        if(UniqueAbility.contains("Lucker III")){
            LuckerIII = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        }else{
            LuckerIII = new ItemStack(Material.RED_STAINED_GLASS_PANE);}
        ItemMeta LuckerIIIMeta = LuckerIII.getItemMeta();
        LuckerIIIMeta.setDisplayName(color("&l&aLucker III "));
        LuckerIIIMeta.setLore(Arrays.asList(color("&bThis Ability grants you &l&1U&2n&3i&4q&5u&6e &7L&8u&9c&ak &bS&ck&di&el&fl")));
        LuckerIII.setItemMeta(LuckerIIIMeta);


        Inventory UniqueSkill = Bukkit.createInventory(null, 27,color("&6&lUnique Skill"));
        UniqueSkill.setItem(0,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(1,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(2,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(3,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(4,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(5,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(6,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(7,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(8,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(9,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(10,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(11,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(15,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(16,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(17,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(18,editItem(WhiteGlass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(19,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(20,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(21,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(22,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(23,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(24,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(25,editItem(Glass.clone(),1,Arrays.asList()));
        UniqueSkill.setItem(26,editItem(Glass.clone(),1,Arrays.asList()));


        if(UniqueAbility.contains("Runner")){
            UniqueSkill.setItem(12,editItem(RunnerI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(RunnerII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(RunnerIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Tank")){
            UniqueSkill.setItem(12,editItem(TankI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(TankII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(TankIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Jumper")){
            UniqueSkill.setItem(12,editItem(JumperI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(JumperII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(JumperIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Lucker")){
            UniqueSkill.setItem(12,editItem(LuckerI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(LuckerII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(LuckerIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Third Eye")){
            UniqueSkill.setItem(12,editItem(ThirdEyeI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(ThirdEyeII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(ThirdEyeIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Blood Thief")){
            UniqueSkill.setItem(12,editItem(BloodThiefI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(BloodThiefII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(BloodThiefIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Mana Affinity")){
            UniqueSkill.setItem(12,editItem(ManaAffinityI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(ManaAffinityII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(ManaAffinityIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Night Watcher")){
            UniqueSkill.setItem(12,editItem(NightWatcherI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(NightWatcherII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(NightWatcherIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Power of Giant")){
            UniqueSkill.setItem(12,editItem(PowerOfGiantI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(PowerOfGiantII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(PowerOfGiantIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Master Swordsman")){
            UniqueSkill.setItem(12,editItem(MasterSwordsmanI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(MasterSwordsmanII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(MasterSwordsmanIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Master Archer")){
            UniqueSkill.setItem(12,editItem(MasterArcherI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(MasterArcherII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(MasterArcherIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Commander")){
            UniqueSkill.setItem(12,editItem(CommanderI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(CommanderII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(CommanderIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Solo")){
            UniqueSkill.setItem(12,editItem(SoloI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(SoloII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(SoloIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Regenerate")){
            UniqueSkill.setItem(12,editItem(RegenerateI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(RegenerateII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(RegenerateIII.clone(),1,Arrays.asList()));
        }
        if(UniqueAbility.contains("Reinforcement")){
            UniqueSkill.setItem(12,editItem(ReinforcementsI.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(13,editItem(ReinforcementsII.clone(),1,Arrays.asList()));
            UniqueSkill.setItem(14,editItem(ReinforcementsIII.clone(),1,Arrays.asList()));
        }















        if(click != ClickType.LEFT && click != ClickType.RIGHT){
            //We only allow single left / right clicks
            // No dropping, tripple click, shift clicking etc.
            return;
        }
        if(click!=null){
            switch (slot) {
                case 15:
                    //
                    if(click == ClickType.LEFT){
                        player.openInventory(UniqueSkill);
                    }
                    break;
                case 22:
                    //
                    if(click == ClickType.LEFT){
                        player.openInventory(Stats);
                    }
                    break;

            }
        }




        //Update player effects stat changes(even if its nothing!)
        //1. Set health
        //Base Hearth 20, 1 heart = 2HP
        //player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20D + skills.getHealth() * 2);
        //This is the 1. 8. 9. and belows way of setting
        //2. Set agility - speed increase by 10%
        //player.setWalkSpeed((float) (0.2 + ((skills.getAgility() / 10) * 0.2)));
        //3. Set intelligence

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

