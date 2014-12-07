package mcrafter.SirenMod.blocks;

import mcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;



//Class Declaration 
	public class SirenPoleMiddle extends BlockContainer{ 

		public String textureName;
		public SirenPoleTileEntity tile;
		
		public SirenPoleMiddle(String textureName) {
				super(Material.piston);
				this.textureName = textureName;
				//Disabled for releases, useful for debugging
				//this.setCreativeTab(SirenMod.SirenModCreativeTab);
				setBlockName(textureName);
				this.setBlockBounds(0.45F, 0F, 0.45F, 0.55F, 1.0F, 0.55F);
		}
		

	public int getRenderType(){
		return -1;}
	public boolean isOpaqueCube(){
		return false;}
	public boolean renderAsNormalBlock(){
		return false;}
	public TileEntity createNewTileEntity(World world, int var2) {
		return new SirenPoleMiddleTileEntity();}

		

	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:LightPole");}
}
