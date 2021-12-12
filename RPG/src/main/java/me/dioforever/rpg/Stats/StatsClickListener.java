package me.dioforever.rpg.Stats;

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

public class StatsClickListener implements Listener{
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
            if(!event.getView().getTitle().equalsIgnoreCase(color("&b&lStats"))){

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

            int HealthStat = CCStats.get().getInt(nick+".Health");
            int MAXHP = CCother.get().getInt(nick+".MAXHP");
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
                    color("&bYou already acquired: "+(WisdomStat/2)+"&bMP/s more Mana Regeneration")));
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
                    case 11:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Health") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Health");
                                CCStats.get().set(nick + ".Health", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 20:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Defense") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Defense");
                                CCStats.get().set(nick + ".Defense", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 29:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Strength") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Strength");
                                CCStats.get().set(nick + ".Strength", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 38:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Agility") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Agility");
                                CCStats.get().set(nick + ".Agility", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 16:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Intelligence") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Intelligence");
                                CCStats.get().set(nick + ".Intelligence", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 25:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Wisdom") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Wisdom");
                                CCStats.get().set(nick + ".Wisdom", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 34:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Regeneration") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Regeneration");
                                CCStats.get().set(nick + ".Regeneration", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 43:
                        //
                        if (click == ClickType.LEFT && !(CCStats.get().getInt(nick + ".Luck") >= 100)) {
                            int Points = CCother.get().getInt(nick + ".POINTS");
                            if (Points != 0) {
                                CCother.get().set(nick + ".POINTS", Points - 1);
                                int HPStat = CCStats.get().getInt(nick + ".Luck");
                                CCStats.get().set(nick + ".Luck", (HPStat + 1));
                                CCStats.save();
                                CCother.save();
                            }
                        }
                        break;
                    case 45:
                        //
                        if (click == ClickType.LEFT) {
                            player.openInventory(Menu);
                        }
                        break;
                }
            }
            int HPStat = CCStats.get().getInt(nick+".Health");
            int DFStat = CCStats.get().getInt(nick+".Defense");
            int STRStat = CCStats.get().getInt(nick+".Strength");
            int AGLStat = CCStats.get().getInt(nick+".Agility");
            int POINTSS = CCother.get().getInt(nick+".Points");
            inv.setItem(10,editItem(Health.clone(),HPStat,Arrays.asList()));

            inv.setItem(19,editItem(Defense.clone(),DFStat,Arrays.asList()));

            inv.setItem(28,editItem(Strength.clone(),STRStat,Arrays.asList()));

            inv.setItem(37,editItem(Agility.clone(),AGLStat,Arrays.asList()));

            inv.setItem(49,editItem(Points.clone(),POINTSS,Arrays.asList()));


            int INTStat = CCStats.get().getInt(nick+".Intelligence");
            int WSDStat = CCStats.get().getInt(nick+".Wisdom");
            int RGNStat = CCStats.get().getInt(nick+".Regeneration");
            int LUCKStat = CCStats.get().getInt(nick+".Luck");
            inv.setItem(15,editItem(Intelligence.clone(),INTStat,Arrays.asList()));

            inv.setItem(24,editItem(Wisdom.clone(),WSDStat,Arrays.asList()));

            inv.setItem(33,editItem(Regeneration.clone(),RGNStat,Arrays.asList()));

            inv.setItem(42,editItem(Luck.clone(),LUCKStat,Arrays.asList()));



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

