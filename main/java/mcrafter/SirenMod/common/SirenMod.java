package mcrafter.SirenMod.common;

import mcrafter.SirenMod.blocks.SirenPoleBaseTileEntity;
import mcrafter.SirenMod.blocks.SirenPoleMiddleTileEntity;
import mcrafter.SirenMod.blocks.SirenPoleTileEntity;
import mcrafter.SirenMod.blocks.SirenPoleTopTileEntity;
import mcrafter.SirenMod.common.handlers.SirenModEventHandler;
import mcrafter.SirenMod.sirens.general.BlackSirenTileEntity;
import mcrafter.SirenMod.sirens.general.BlueSirenTileEntity;
import mcrafter.SirenMod.sirens.general.BrownSirenTileEntity;
import mcrafter.SirenMod.sirens.general.CyanSirenTileEntity;
import mcrafter.SirenMod.sirens.general.GreenSirenTileEntity;
import mcrafter.SirenMod.sirens.general.GreySirenTileEntity;
import mcrafter.SirenMod.sirens.general.LightBlueSirenTileEntity;
import mcrafter.SirenMod.sirens.general.LightGreySirenTileEntity;
import mcrafter.SirenMod.sirens.general.LimeSirenTileEntity;
import mcrafter.SirenMod.sirens.general.MagentaSirenTileEntity;
import mcrafter.SirenMod.sirens.general.OrangeSirenTileEntity;
import mcrafter.SirenMod.sirens.general.PinkSirenTileEntity;
import mcrafter.SirenMod.sirens.general.PurpleSirenTileEntity;
import mcrafter.SirenMod.sirens.general.RedSirenTileEntity;
import mcrafter.SirenMod.sirens.general.WhiteSirenTileEntity;
import mcrafter.SirenMod.sirens.general.YellowSirenTileEntity;
import mcrafter.SirenMod.sirens.nuclear.NuclearSirenTileEntity;
import mcrafter.SirenMod.sirens.wall.BurglarSirenTileEntity;
import mcrafter.SirenMod.sirens.wall.FireAlarmTileEntity;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = SirenMod.modID, version = "2.2.01", name = "Mcrafter's Siren Mod - test patch")

public class SirenMod {

	@Instance(value="SirenMod")
	public static SirenMod instance;
	public static final String modID = "sirenmod";
	public static CreativeTabs SirenModCreativeTab = new SirenModCreativeTab(CreativeTabs.getNextID(), "Mcrafter's Siren Mod");

	@SidedProxy(clientSide = "mcrafter.SirenMod.client.SirenModClientProxy", serverSide = "mcrafter.SirenMod.common.SirenModCommonProxy") //Tells Forge the location of your proxies
	public static SirenModCommonProxy proxy;
	
//Blocks
	
	
	public static Block SiliconOre;
	public static Block BlueGeneralSiren;
	public static Block YellowGeneralSiren;
	public static Block RedGeneralSiren;
	public static Block GreyGeneralSiren;
	public static Block NuclearSiren;
	public static Block GreenGeneralSiren;
	public static Block WhiteGeneralSiren;
	public static Block LimeGeneralSiren;
	public static Block CyanGeneralSiren;
	public static Block LightGreyGeneralSiren;
	public static Block LightBlueGeneralSiren;
	public static Block PurpleGeneralSiren;
	public static Block PinkGeneralSiren;
	public static Block OrangeGeneralSiren;
	public static Block BlackGeneralSiren;
	public static Block BrownGeneralSiren;
	public static Block MagentaGeneralSiren;
	public static Block BurglarSiren;
	public static Block FireAlarm;
	public static Block SirenPole;
	public static Block SirenPoleTop;
	public static Block SirenPoleBase;
	public static Block SirenPoleMiddle;
	public static Block NuclearExplosive;
	
	
//Items
	public static Item SiliconShard;
	public static Item IntegratedCircuit;
	public static Item Speaker;

@EventHandler
public void load(FMLInitializationEvent event) {
	
//----------BEGINS REGISTERING PROCESS--------------
	
		MinecraftForge.EVENT_BUS.register(new SirenModEventHandler());
		
	//Registers WorldGen
		GameRegistry.registerWorldGenerator(new SirenModWorldGen(), 0);

	//Registers Siren Tile Entities
		proxy.registerRenderInformation();
		GameRegistry.registerTileEntity(SirenPoleTopTileEntity.class, "SirenPoleTopTileEntity");
		GameRegistry.registerTileEntity(SirenPoleBaseTileEntity.class, "SirenPoleBaseTileEntity");
		GameRegistry.registerTileEntity(SirenPoleTileEntity.class, "SirenPoleTileEntity");
		GameRegistry.registerTileEntity(SirenPoleMiddleTileEntity.class, "SirenPoleMiddleTileEntity");
		GameRegistry.registerTileEntity(BlueSirenTileEntity.class, "BlueSirenTileEntity");
		GameRegistry.registerTileEntity(YellowSirenTileEntity.class, "YellowSirenTileEntity");
		GameRegistry.registerTileEntity(RedSirenTileEntity.class, "RedSirenTileEntity");
		GameRegistry.registerTileEntity(GreySirenTileEntity.class, "GreySirenTileEntity");
		GameRegistry.registerTileEntity(NuclearSirenTileEntity.class, "NuclearSirenTileEntity");
		GameRegistry.registerTileEntity(LightBlueSirenTileEntity.class, "LightBlueSirenTileEntity");
		GameRegistry.registerTileEntity(LightGreySirenTileEntity.class, "LightGreySirenTileEntity");
		GameRegistry.registerTileEntity(CyanSirenTileEntity.class, "CyanSirenTileEntity");
		GameRegistry.registerTileEntity(BrownSirenTileEntity.class, "BrownSirenTileEntity");
		GameRegistry.registerTileEntity(OrangeSirenTileEntity.class, "OrangeSirenTileEntity");
		GameRegistry.registerTileEntity(PurpleSirenTileEntity.class, "PurpleSirenTileEntity");
		GameRegistry.registerTileEntity(PinkSirenTileEntity.class, "PinkSirenTileEntity");
		GameRegistry.registerTileEntity(BlackSirenTileEntity.class, "BlackSirenTileEntity");
		GameRegistry.registerTileEntity(WhiteSirenTileEntity.class, "WhiteSirenTileEntity");
		GameRegistry.registerTileEntity(GreenSirenTileEntity.class, "GreenSirenTileEntity");
		GameRegistry.registerTileEntity(LimeSirenTileEntity.class, "LimeSirenTileEntity");
		GameRegistry.registerTileEntity(MagentaSirenTileEntity.class, "MagentaSirenTileEntity");
		GameRegistry.registerTileEntity(BurglarSirenTileEntity.class, "BurglarSirenTileEntity");
		GameRegistry.registerTileEntity(FireAlarmTileEntity.class, "FireAlarmTileEntity");
		
	//REGISTERS BLOCKS
		NuclearExplosive = new mcrafter.SirenMod.blocks.NuclearExplosive("Nuclear Explosive").setHardness(0.3F);		
		SirenPoleTop = new mcrafter.SirenMod.blocks.SirenPoleTop("Siren Pole Top").setHardness(0.3F);		
		SirenPoleMiddle = new mcrafter.SirenMod.blocks.SirenPoleMiddle("Siren Pole Middle").setHardness(0.3F);		
		SirenPoleBase = new mcrafter.SirenMod.blocks.SirenPoleBase("Siren Pole Base").setHardness(0.3F);		
		SirenPole = new mcrafter.SirenMod.blocks.SirenPole("Siren Pole").setHardness(0.3F);		
		OrangeGeneralSiren = new mcrafter.SirenMod.sirens.general.OrangeGeneralSiren("Orange General Siren").setHardness(0.3F);		
		LightGreyGeneralSiren = new mcrafter.SirenMod.sirens.general.LightGreyGeneralSiren("Light Gray General Siren").setHardness(0.3F);		
		LightBlueGeneralSiren = new mcrafter.SirenMod.sirens.general.LightBlueGeneralSiren("Light Blue General Siren").setHardness(0.3F);		
		CyanGeneralSiren = new mcrafter.SirenMod.sirens.general.CyanGeneralSiren("Cyan General Siren").setHardness(0.3F);		
		WhiteGeneralSiren = new mcrafter.SirenMod.sirens.general.WhiteGeneralSiren("White General Siren").setHardness(0.3F);		
		BlackGeneralSiren = new mcrafter.SirenMod.sirens.general.BlackGeneralSiren("Black General Siren").setHardness(0.3F);		
		PinkGeneralSiren = new mcrafter.SirenMod.sirens.general.PinkGeneralSiren("Pink General Siren").setHardness(0.3F);		
		PurpleGeneralSiren = new mcrafter.SirenMod.sirens.general.PurpleGeneralSiren("Purple General Siren").setHardness(0.3F);		
		BrownGeneralSiren = new mcrafter.SirenMod.sirens.general.BrownGeneralSiren("Brown General Siren").setHardness(0.3F);		
		GreenGeneralSiren = new mcrafter.SirenMod.sirens.general.GreenGeneralSiren("Green General Siren").setHardness(0.3F);		
		LimeGeneralSiren = new mcrafter.SirenMod.sirens.general.LimeGeneralSiren("Lime General Siren").setHardness(0.3F);		
		MagentaGeneralSiren = new mcrafter.SirenMod.sirens.general.MagentaGeneralSiren("Magenta General Siren").setHardness(0.3F);		
		GreyGeneralSiren = new mcrafter.SirenMod.sirens.general.GreyGeneralSiren("Gray General Siren").setHardness(0.3F);		
		BlueGeneralSiren = new mcrafter.SirenMod.sirens.general.BlueGeneralSiren("Blue General Siren").setHardness(0.3F);		
		RedGeneralSiren = new mcrafter.SirenMod.sirens.general.RedGeneralSiren("Red General Siren").setHardness(0.3F);		
		YellowGeneralSiren = new mcrafter.SirenMod.sirens.general.YellowGeneralSiren("Yellow General Siren").setHardness(0.3F);		
		NuclearSiren = new mcrafter.SirenMod.sirens.nuclear.NuclearSiren("Nuclear Siren").setHardness(0.3F);		
		SiliconOre = new mcrafter.SirenMod.blocks.SiliconOre("Silicon Ore").setHardness(0.3F);		
		BurglarSiren = new mcrafter.SirenMod.sirens.wall.BurglarSiren("Burglar Alarm").setHardness(0.3F);		
		FireAlarm = new mcrafter.SirenMod.sirens.wall.FireAlarm("Fire Alarm").setHardness(0.3F);		

		GameRegistry.registerBlock(NuclearExplosive, "Nuclear Explosive");
		GameRegistry.registerBlock(SiliconOre, "Silicon Ore");
		GameRegistry.registerBlock(GreyGeneralSiren, "Gray General Siren");
		GameRegistry.registerBlock(BlueGeneralSiren, "Blue General Siren");
		GameRegistry.registerBlock(RedGeneralSiren, "Red General Siren");
		GameRegistry.registerBlock(YellowGeneralSiren, "Yellow General Siren");
		GameRegistry.registerBlock(LightGreyGeneralSiren, "Light Gray General Siren");
		GameRegistry.registerBlock(LightBlueGeneralSiren, "Light Blue General Siren");
		GameRegistry.registerBlock(CyanGeneralSiren, "Cyan General Siren");
		GameRegistry.registerBlock(OrangeGeneralSiren, "Orange General Siren");
		GameRegistry.registerBlock(MagentaGeneralSiren, "Magenta General Siren");
		GameRegistry.registerBlock(BlackGeneralSiren, "Black General Siren");
		GameRegistry.registerBlock(WhiteGeneralSiren, "White General Siren");
		GameRegistry.registerBlock(LimeGeneralSiren, "Lime General Siren");
		GameRegistry.registerBlock(GreenGeneralSiren, "Green General Siren");
		GameRegistry.registerBlock(PurpleGeneralSiren, "Purple General Siren");
		GameRegistry.registerBlock(PinkGeneralSiren, "Pink General Siren");
		GameRegistry.registerBlock(BrownGeneralSiren, "Brown General Siren");
		GameRegistry.registerBlock(NuclearSiren, "Nuclear Siren");
		GameRegistry.registerBlock(BurglarSiren, "Burglar Alarm");
		GameRegistry.registerBlock(FireAlarm, "Fire Alarm");
		GameRegistry.registerBlock(SirenPole, "Siren Pole");
		GameRegistry.registerBlock(SirenPoleBase, "Siren Pole Base");
		GameRegistry.registerBlock(SirenPoleMiddle, "Siren Pole Middle");
		GameRegistry.registerBlock(SirenPoleTop, "Siren Pole Top");
		



		
	//Register Items
		
		IntegratedCircuit = new IntegratedCircuit("Integrated Circuit");
		Speaker = new Speaker("Speaker");
		SiliconShard = new SiliconShard("Silicon Shard");
		
		GameRegistry.registerItem(IntegratedCircuit, "Integrated Circuit");
		GameRegistry.registerItem(Speaker, "Speaker");
		GameRegistry.registerItem(SiliconShard, "Silicon Shard");

	//Recipes
		
		GameRegistry.addRecipe(new ItemStack(SirenMod.Speaker), "CCC", "CNC", "CCC", Character.valueOf('C'), Items.iron_ingot, Character.valueOf('N'), Blocks.noteblock);
		GameRegistry.addRecipe(new ItemStack(SirenMod.IntegratedCircuit), "ABA", "BEB", "ABA", Character.valueOf('A'), SirenMod.SiliconShard, Character.valueOf('B'), Items.redstone, Character.valueOf('E'), Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(SirenMod.WhiteGeneralSiren), "XSX", "TIT", "ZZZ", Character.valueOf('X'), SirenMod.Speaker, Character.valueOf('S'), SirenMod.IntegratedCircuit, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('Z'), Blocks.stone_slab);
		GameRegistry.addRecipe(new ItemStack(SirenMod.NuclearSiren), "XSX", "IZI", "CVC", Character.valueOf('S'), SirenMod.Speaker, Character.valueOf('I'), Items.gold_ingot, Character.valueOf('Z'), SirenMod.SiliconShard, Character.valueOf('C'), Blocks.stone_slab, Character.valueOf('V'), SirenMod.IntegratedCircuit);		
		GameRegistry.addRecipe(new ItemStack(SirenMod.BurglarSiren), "ICI", "ISI", "III", Character.valueOf('S'), SirenMod.Speaker, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), SirenMod.IntegratedCircuit);		
		GameRegistry.addRecipe(new ItemStack(SirenMod.FireAlarm), "WWW", "WIW", "CSC", Character.valueOf('W'), Blocks.wool, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('C'), SirenMod.IntegratedCircuit, Character.valueOf('S'), SirenMod.Speaker);		
		GameRegistry.addRecipe(new ItemStack(SirenMod.SirenPole), "IRI", "IRI", "IRI", Character.valueOf('R'), Items.redstone, Character.valueOf('I'), Items.iron_ingot);		

		
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.BlueGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.LightBlueGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.LightGreyGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.GreyGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.BlackGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.OrangeGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.PinkGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.PurpleGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.MagentaGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.GreenGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.LimeGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.RedGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.YellowGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.CyanGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(SirenMod.BrownGeneralSiren, 1), new ItemStack(SirenMod.WhiteGeneralSiren, 1), new ItemStack(Items.dye, 1, 3));

		LanguageRegistry.addName(OrangeGeneralSiren, "Orange General Siren");
		LanguageRegistry.addName(BlackGeneralSiren, "Black General Siren");
		LanguageRegistry.addName(BrownGeneralSiren, "Brown General Siren");
		LanguageRegistry.addName(WhiteGeneralSiren, "White General Siren");
		LanguageRegistry.addName(CyanGeneralSiren, "Cyan General Siren");
		LanguageRegistry.addName(LightBlueGeneralSiren, "Light Blue General Siren");
		LanguageRegistry.addName(LightGreyGeneralSiren, "Light Gray General Siren");
		LanguageRegistry.addName(PinkGeneralSiren, "Pink General Siren");
		LanguageRegistry.addName(PurpleGeneralSiren, "Purple General Siren");
		LanguageRegistry.addName(GreenGeneralSiren, "Green General Siren");
		LanguageRegistry.addName(LimeGeneralSiren, "Lime General Siren");
		LanguageRegistry.addName(MagentaGeneralSiren, "Magenta General Siren");
		LanguageRegistry.addName(GreyGeneralSiren, "Gray General Siren");
		LanguageRegistry.addName(BlueGeneralSiren, "Blue General Siren");
		LanguageRegistry.addName(RedGeneralSiren, "Red General Siren");
		LanguageRegistry.addName(YellowGeneralSiren, "Yellow General Siren");
		LanguageRegistry.addName(NuclearSiren, "Nuclear Siren");
		LanguageRegistry.addName(SiliconOre, "Silicon Ore");
		LanguageRegistry.addName(SiliconShard, "Silicon Shard");
		LanguageRegistry.addName(IntegratedCircuit, "Integrated Circuit");
		LanguageRegistry.addName(Speaker, "Speaker");
		LanguageRegistry.addName(BurglarSiren, "Burglar Alarm");
		LanguageRegistry.addName(FireAlarm, "Fire Alarm");
		LanguageRegistry.addName(SirenPole, "Siren Pole");
		LanguageRegistry.addName(SirenPoleBase, "Siren Pole Base");
		LanguageRegistry.addName(SirenPoleMiddle, "Siren Pole Middle");
		LanguageRegistry.addName(SirenPoleTop, "Siren Pole Top");




		OreDictionary.registerOre("SiliconOre", SiliconOre);

}


public static void registerItem(Item item, String name, String unlocalizedName) {
    GameRegistry.registerItem(item, SirenMod.modID + unlocalizedName);
    LanguageRegistry.addName(item, name);}

public static void registerBlock(Block block, String name, String unlocalizedName) {
	GameRegistry.registerBlock(block, SirenMod.modID + unlocalizedName);
	LanguageRegistry.addName(block, name);}

}