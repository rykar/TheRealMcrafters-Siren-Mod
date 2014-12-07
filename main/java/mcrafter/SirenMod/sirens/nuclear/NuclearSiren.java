package mcrafter.SirenMod.sirens.nuclear;

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
import net.minecraft.entity.Entity;
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
	public class NuclearSiren extends BlockContainer{ 

		public String textureName;
		public NuclearSirenTileEntity tile;
		
		public NuclearSiren(String textureName) {
				super(Material.piston);
				this.textureName = textureName;
				this.setCreativeTab(SirenMod.SirenModCreativeTab);
				setBlockName(textureName);
				this.setBlockBounds(0.35F, 0F, 0.35F, 0.65F, 0.65F, 0.65F);
		}
		

	public int getRenderType(){
		return -1;}
	public boolean isOpaqueCube(){
		return false;}
	public boolean renderAsNormalBlock(){
		return false;}
	public TileEntity createNewTileEntity(World world, int var2) {
		return new NuclearSirenTileEntity();}


		public void breakBlock(World world, int x, int y, int z, Block block, int integer){
			tile = (NuclearSirenTileEntity) world.getTileEntity(x, y, z);
			tile.setShouldStop(true);	
		}
		
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);
			if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (NuclearSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStop(true);}
			
	        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (NuclearSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStart(true);}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
			if (!world.isRemote && !world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (NuclearSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStop(true);}
			
	        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){ 
	            tile = (NuclearSirenTileEntity) world.getTileEntity(x, y, z); 
	            tile.setShouldStart(true);}	
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
			((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).toggleOn(world);
			return true;
		}
		
		public void loop(World world, int x, int y, int z){				
			if (((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).timer > 78){
				((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).toggleOff();
				((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).rotation = 0.0F;
				((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).timer = 0;
			} else if (((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).timer > 0){
				((NuclearSirenTileEntity)world.getTileEntity(x, y, z)).rotation += 0.0805;
			}
		}
		
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemstack) {
			 int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		        if (l == 0){world.setBlockMetadataWithNotify(x, y, z, 2, 2);}
		        if (l == 1){world.setBlockMetadataWithNotify(x, y, z, 5, 2);}
		        if (l == 2){world.setBlockMetadataWithNotify(x, y, z, 3, 2);}
		        if (l == 3){world.setBlockMetadataWithNotify(x, y, z, 4, 2);}
		}
			
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:NuclearSiren");}
}
