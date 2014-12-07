package mcrafter.SirenMod.client;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import mcrafter.SirenMod.blocks.SirenPoleBaseRenderer;
import mcrafter.SirenMod.blocks.SirenPoleBaseTileEntity;
import mcrafter.SirenMod.blocks.SirenPoleMiddleRenderer;
import mcrafter.SirenMod.blocks.SirenPoleMiddleTileEntity;
import mcrafter.SirenMod.blocks.SirenPoleTopRenderer;
import mcrafter.SirenMod.blocks.SirenPoleTopTileEntity;
import mcrafter.SirenMod.common.SirenModCommonProxy;
import mcrafter.SirenMod.sirens.general.BlackGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.BlackSirenTileEntity;
import mcrafter.SirenMod.sirens.general.BlueGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.BlueSirenTileEntity;
import mcrafter.SirenMod.sirens.general.BrownGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.BrownSirenTileEntity;
import mcrafter.SirenMod.sirens.general.CyanGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.CyanSirenTileEntity;
import mcrafter.SirenMod.sirens.general.GreenGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.GreenSirenTileEntity;
import mcrafter.SirenMod.sirens.general.GreyGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.GreySirenTileEntity;
import mcrafter.SirenMod.sirens.general.LightBlueGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.LightBlueSirenTileEntity;
import mcrafter.SirenMod.sirens.general.LightGreyGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.LightGreySirenTileEntity;
import mcrafter.SirenMod.sirens.general.LimeGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.LimeSirenTileEntity;
import mcrafter.SirenMod.sirens.general.MagentaGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.MagentaSirenTileEntity;
import mcrafter.SirenMod.sirens.general.OrangeGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.OrangeSirenTileEntity;
import mcrafter.SirenMod.sirens.general.PinkGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.PinkSirenTileEntity;
import mcrafter.SirenMod.sirens.general.PurpleGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.PurpleSirenTileEntity;
import mcrafter.SirenMod.sirens.general.RedGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.RedSirenTileEntity;
import mcrafter.SirenMod.sirens.general.WhiteGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.WhiteSirenTileEntity;
import mcrafter.SirenMod.sirens.general.YellowGeneralSirenRenderer;
import mcrafter.SirenMod.sirens.general.YellowSirenTileEntity;
import mcrafter.SirenMod.sirens.nuclear.NuclearSirenRenderer;
import mcrafter.SirenMod.sirens.nuclear.NuclearSirenTileEntity;
import mcrafter.SirenMod.sirens.wall.BurglarSirenRenderer;
import mcrafter.SirenMod.sirens.wall.BurglarSirenTileEntity;
import mcrafter.SirenMod.sirens.wall.FireAlarmRenderer;
import mcrafter.SirenMod.sirens.wall.FireAlarmTileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;

public class SirenModClientProxy extends SirenModCommonProxy {

	public void registerRenderInformation(){
		
		ClientRegistry.bindTileEntitySpecialRenderer(BlueSirenTileEntity.class, new BlueGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(YellowSirenTileEntity.class, new YellowGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(RedSirenTileEntity.class, new RedGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(GreySirenTileEntity.class, new GreyGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LightBlueSirenTileEntity.class, new LightBlueGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LightGreySirenTileEntity.class, new LightGreyGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CyanSirenTileEntity.class, new CyanGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BrownSirenTileEntity.class, new BrownGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(MagentaSirenTileEntity.class, new MagentaGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(OrangeSirenTileEntity.class, new OrangeGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PinkSirenTileEntity.class, new PinkGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PurpleSirenTileEntity.class, new PurpleGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(WhiteSirenTileEntity.class, new WhiteGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BlackSirenTileEntity.class, new BlackGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(GreenSirenTileEntity.class, new GreenGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LimeSirenTileEntity.class, new LimeGeneralSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(NuclearSirenTileEntity.class, new NuclearSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BurglarSirenTileEntity.class, new BurglarSirenRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(FireAlarmTileEntity.class, new FireAlarmRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SirenPoleTopTileEntity.class, new SirenPoleTopRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SirenPoleMiddleTileEntity.class, new SirenPoleMiddleRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SirenPoleBaseTileEntity.class, new SirenPoleBaseRenderer());

	}
	

    public void playSound(World world, int x, int y, int z, String soundName) {
    	Minecraft.getMinecraft().theWorld.playSound(x, y, z, soundName, 3.0F, 1.0F, true);
    }
	
}
