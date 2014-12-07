package mcrafter.SirenMod.sirens.wall;

//Imports
	import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
	
public class BurglarSiren extends BlockContainer{ //MUST BE "BlockContainer" NOT "Block"
													  //Model will not render on "Block"!!!!

	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~
//_____________________
//VARIABLE DECLARATIONS
//_____________________
	
	public String textureName;	
	public BurglarSirenTileEntity tile;
	
	
	public BurglarSiren(String textureName) {
		super(Material.piston);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setBlockName(textureName);
	}

//Rendering details
	public int getRenderType(){
		return -1;}
	public boolean isOpaqueCube(){
		return false;}
	public boolean renderAsNormalBlock(){
		return false;}
	
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new BurglarSirenTileEntity();}
	
	
    public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return world.isSideSolid(x - 1, y, z, EAST,  true) ||
               world.isSideSolid(x + 1, y, z, WEST,  true) ||
               world.isSideSolid(x, y, z - 1, SOUTH, true) ||
               world.isSideSolid(x, y, z + 1, NORTH, true);      
    }
        
    protected boolean checkIfWall(World world, int x, int y, int z){
        if (!this.canPlaceBlockAt(world, x, y, z)){
            if (world.getBlock(x, y, z) == this){
                this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                world.setBlockToAir(x, y, z);
            }

            return false;
        }else{
            return true;
        }
    }
	
    
    public void breakBlock(World world, int x, int y, int z, Block block, int integer){
		BurglarSirenTileEntity tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z);
		tile.setShouldStop(true);	
	}
    
  //Checks if there is a redstone signal upon placement of the siren
  		public void onBlockAdded(World world, int x, int y, int z){
  			super.onBlockAdded(world, x, y, z);
  			if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)){ 
  	            tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z); 
  	            tile.setShouldStop(true);}
  			
  	        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){ 
  	            tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z); 
  	            tile.setShouldStart(true);}
  		}

  	//Called when a nearby block is updated
  		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
  			if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)){ 
  	            tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z); 
  	            tile.setShouldStop(true);}
  			
  	        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){ 
  	            tile = (BurglarSirenTileEntity) world.getTileEntity(x, y, z); 
  	            tile.setShouldStart(true);}
  		}
	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
		if (world.isRemote){
			SirenMod.proxy.playSound(world, x, y, z, "SirenMod:sirenNuclearBomb");
		}		
		return true;
	}
	
	
//Handles block orientation
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
		 int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	        if (l == 0){
	            world.setBlockMetadataWithNotify(x, y, z, 2, 2);}

	        if (l == 1){
	        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);}

	        if (l == 2){
	        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);}

	        if (l == 3){
	        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);}
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		
		int meta = world.getBlockMetadata(x, y, z);
			this.setBlockBounds(0.29F, 0.32F, 0.9F, 0.72F, 0.74F, 1.0F);
    	
			if (meta == 4){
				this.setBlockBounds(1.0F, 0.32F, 0.29F, 0.9F, 0.74F, 0.72F);}

			if (meta == 3){
				this.setBlockBounds(0.29F, 0.32F, 0.0F, 0.72F, 0.74F, 0.1F);}
    	
			if (meta == 2){
				this.setBlockBounds(0.29F, 0.32F, 0.9F, 0.72F, 0.74F, 1.0F);}
    	
			if (meta == 5){
				this.setBlockBounds(0.0F, 0.32F, 0.29F, 0.1F, 0.74F, 0.72F);}	
	}

//Retrieves meta based on rotation
	   private static int getMetadataBasedOnRotation(int rotation) {
		   if (rotation >= 315 || rotation < 45) {
			   return 1;} 
		   else if (rotation >= 45 && rotation < 135) {
			   return 2;} 
		   else if (rotation >= 135 && rotation < 225) {
			   return 0;} 
		   else {
			   return 3;}
	   }

	
	
//Registry
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:BurglarSiren");
	}
}
