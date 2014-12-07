package mcrafter.SirenMod.blocks;

import mcrafter.SirenMod.common.SirenMod;
import mcrafter.SirenMod.sirens.general.BrownSirenTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;



//Class Declaration 
	public class SirenPole extends BlockContainer{ 

		public String textureName;
		public SirenPoleTileEntity tile;
		
		public SirenPole(String textureName) {
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
		return new SirenPoleTileEntity();}

		
		public void onBlockAdded(World world, int x, int y, int z){
			super.onBlockAdded(world, x, y, z);
			Block below = world.getBlock(x, y - 1, z);
			Block above = world.getBlock(x, y + 1, z);
			
			if (below == Blocks.air){
				if (above == Blocks.air){
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleTop);
				} else if (above == SirenMod.SirenPoleTop){
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
				} else if (above == SirenMod.SirenPoleBase){
					world.setBlockToAir(x, y, z);
					world.setBlockToAir(x, y + 1, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleBase);
					world.setBlock(x, y + 1, z, SirenMod.SirenPoleMiddle);
				} else if (above == SirenMod.SirenPoleMiddle){
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
				} else if (!(above == Blocks.air)){
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleTop);
				}
			} else {
				if (below == SirenMod.SirenPoleBase){
					if (above == SirenMod.SirenPoleMiddle){
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
					} else if (above == SirenMod.SirenPoleTop){
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
					} else { 
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleTop);
					}				
				} else if (below == SirenMod.SirenPoleTop){
					if (above == SirenMod.SirenPoleTop){
						world.setBlockToAir(x, y, z);
						world.setBlockToAir(x, y - 1, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
						world.setBlock(x, y - 1, z, SirenMod.SirenPoleMiddle);
					} else {
						world.setBlockToAir(x, y - 1, z);
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y - 1, z, SirenMod.SirenPoleMiddle);
						world.setBlock(x, y, z, SirenMod.SirenPoleTop);
					}
				} else if (below == SirenMod.SirenPoleMiddle){
					if (above == SirenMod.SirenPoleMiddle){
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
					} else if (above == SirenMod.SirenPoleTop){
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
					} else {
						world.setBlockToAir(x, y, z);
						world.setBlock(x, y, z, SirenMod.SirenPoleTop);
					}
				} else if (above == SirenMod.SirenPoleBase){
					world.setBlockToAir(x, y, z);
					world.setBlockToAir(x, y + 1, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleBase);
					world.setBlock(x, y + 1, z, SirenMod.SirenPoleMiddle);
				} else if (!(below == Blocks.air)){
					if (below == SirenMod.SirenPoleBase){
					} else {
						if (below == SirenMod.SirenPoleMiddle){
						} else {
							if (below == SirenMod.SirenPoleTop){
							} else {
								world.setBlockToAir(x, y, z);
								world.setBlock(x, y, z, SirenMod.SirenPoleBase);
							}
						}
						
					}
				} else if (above == SirenMod.SirenPoleTop){
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
				} else if (above == SirenMod.SirenPoleMiddle){
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleMiddle);
				} else {
					world.setBlockToAir(x, y, z);
					world.setBlock(x, y, z, SirenMod.SirenPoleBase);
				}
			}			
		}
		
	

	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon("SirenMod:SirenPole");}
}
