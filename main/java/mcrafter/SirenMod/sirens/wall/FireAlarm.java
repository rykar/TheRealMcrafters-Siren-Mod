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
	
public class FireAlarm extends BlockContainer{ //MUST BE "BlockContainer" NOT "Block"
													  //Model will not render on "Block"!!!!

	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~
//_____________________
//VARIABLE DECLARATIONS
//_____________________
	
	public String textureName;	
	public EntityClientPlayerMP player;
	public boolean active = false;
	public FireAlarmTileEntity tile;
	
	
	public FireAlarm(String textureName) {
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
@Override
	public boolean canProvidePower(){
        return true;}
	
	
	public TileEntity createNewTileEntity(World world, int var2) {
		return new FireAlarmTileEntity();}
	
	
	public void breakBlock(World world, int x, int y, int z, Block block, int integer){
		FireAlarmTileEntity tile = (FireAlarmTileEntity) world.getTileEntity(x, y, z);
		tile.setShouldStop(true);	
		
		world.notifyBlocksOfNeighborChange(x, y, z, this);
		world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
        world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
        world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
        world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
        world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
        world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
	}
	    
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
	

	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
		FireAlarmTileEntity tileentity = (FireAlarmTileEntity) world.getTileEntity(x, y, z);	
		tile = (FireAlarmTileEntity) world.getTileEntity(x, y, z); 
		
			if (world.isRemote){
				if (!((FireAlarmTileEntity)tileentity).activated){
					((FireAlarmTileEntity)world.getTileEntity(x, y, z)).rotation = 1.75F;
					((FireAlarmTileEntity)world.getTileEntity(x, y, z)).activated = true;
					active = true;	
					tile.setShouldStart(true);
				}else{
					((FireAlarmTileEntity)world.getTileEntity(x, y, z)).rotation = 0.0F;
					((FireAlarmTileEntity)world.getTileEntity(x, y, z)).activated = false;
					active = false;
					tile.setShouldStop(true);
				}
			}
			
			world.notifyBlocksOfNeighborChange(x, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
		
		return true;
	}
	
	
	
@Override
	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
		TileEntity te = world.getTileEntity(x, y, z);
					
		if (active){
			if (te instanceof FireAlarmTileEntity) {
				return 15;
			}
		}
		
		return 0;
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
		blockIcon = iconRegister.registerIcon("SirenMod:FireAlarm");
	}
}
