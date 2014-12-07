package mcrafter.SirenMod.common;

//Imports
	import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public final class SirenModCreativeTab extends CreativeTabs{

	public SirenModCreativeTab(int par1, String par2Str){
		super(par1, par2Str);
	}


	public Item getTabIconItem() {
		return Item.getItemFromBlock(SirenMod.BlueGeneralSiren);
	}
	
	
	public String getTranslatedTabLabel(){
		return "Mcrafter's Siren Mod";
	}



	
}