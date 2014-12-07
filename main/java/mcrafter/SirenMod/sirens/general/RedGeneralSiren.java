package mcrafter.SirenMod.sirens.general;

//Imports
	import java.lang.ref.Reference;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//Class Declaration 
	public class RedGeneralSiren extends BlockContainer{ //MUST BE "BlockContainer" NOT "Block"
											   			  //Model will not render on "Block"!!!!
	
//Texture and Creative Tab handling
		public String textureName;
		public RedSirenTileEntity tile;
		
			public RedGeneralSiren(String textureName) {
				super(Material.piston);
				this.textureName = textureName;
				this.setCreativeTab(SirenMod.SirenModCreativeTab);
				setBlockName(textureName);
				this.setBlockBounds(0.16F, 0F, 0.16F, 0.84F, 0.57F, 0.84F);
			}
	
//Rendering details
	public int getRenderType(){
		return -1;
	}
	public boolean isOpaqueCube(){
		return false;
	}
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	//Stops sound when block is broken
		public void breakBlock(World world, int x, int y, int z, Block block, int integer){
			RedSirenTileEntity tile = (RedSirenTileEntity) world.getTileEntity(x, y, z);
			tile.setShouldStop(true);	
		}

		//Checks if there is a redstone signal upon placement of the siren
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);
			if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (RedSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStop(true);}
			
	        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (RedSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStart(true);}
		}

	//Called when a nearby block is updated
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
			if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (RedSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStop(true);}
			
	        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (RedSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStart(true);}
		}

	//Called on right click
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
			((RedSirenTileEntity)world.getTileEntity(x, y, z)).toggleOn();
			return true;
		}
		
		
		public void loop(World world, int x, int y, int z){
			if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 145){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).toggleOff();
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation = 0.0F;
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer = 0;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 140){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.15F;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 130){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.25F;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 120){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.4F;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 16){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.5F;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 8){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.4F;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 4){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.25F;
			} else if (((RedSirenTileEntity)world.getTileEntity(x, y, z)).timer > 0){
				((RedSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.15F;
			}
		}
		
	//Handles block orientation
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
			 int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		        if (l == 0){
		            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		        }

		        if (l == 1){
		        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		        }

		        if (l == 2){
		        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		        }

		        if (l == 3){
		        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		        }
		}
		
		//Retrieves meta based on rotation
		   private static int getMetadataBasedOnRotation(int rotation) {
			   if (rotation >= 315 || rotation < 45) {
				   return 1;
			   } 
			   
			   else if (rotation >= 45 && rotation < 135) {
				   return 2;
			   } 
			   
			   else if (rotation >= 135 && rotation < 225) {
				   return 0;
			   } 
			   
			   else {
				   return 3;
			   }
		   }
	
//Registry
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:RedGeneralSiren");
	}


public TileEntity createNewTileEntity(World var1, int var2) {
	return new RedSirenTileEntity();
}

}
