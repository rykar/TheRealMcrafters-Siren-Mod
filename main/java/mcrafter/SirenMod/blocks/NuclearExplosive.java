package mcrafter.SirenMod.blocks;

import mcrafter.SirenMod.common.SirenMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;


public class NuclearExplosive extends Block {

	public String textureName;
	public int rad = 1;
	public int yLevel = 120;
	public int severity = 0;
	


	public NuclearExplosive(String textureName){
		super(Material.rock);
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setBlockName(textureName);
		
	}	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t){
		
		yLevel = y + 40;
		fillCircle(world, x, y + 1, z, 40, Blocks.air);
		fillCircle(world, x, y + 2, z, 40, Blocks.air);
		fillCircle(world, x, y + 3, z, 40, Blocks.air);
		fillCircle(world, x, y + 4, z, 40, Blocks.air);
		fillCircle(world, x, y, z, 40, Blocks.air);
		fillCircle(world, x, y - 1, z, 40, Blocks.air);
		fillCircle(world, x, y - 2, z, 40, Blocks.air);
		fillCircle(world, x, y - 3, z, 40, Blocks.air);
		fillCircle(world, x, y - 4, z, 40, Blocks.air);
		
		for (int times = 80; times > 40; times = times - 1){
			fillCircle(world, x, yLevel, z, rad, Blocks.air);
			fillCircle(world, x, yLevel, z, rad + 1, Blocks.air);

			rad = rad + 1;
			yLevel = yLevel - 1;
		}
		
		for (int times = 39; times > 0; times = times - 1){
			fillCircle(world, x, yLevel, z, rad, Blocks.air);
			fillCircle(world, x, yLevel, z, rad + 1, Blocks.air);
			rad = rad - 1;
			yLevel = yLevel - 1;
		}
		
		return true;
	}
	
	
	public void fillCircle(World world, int x, int y, int z, int radius, Block block) {
		while(radius != 0) {
			for(int i = 0; i < 360; i++){
				world.setBlock((int) (x + radius * Math.cos(i)), y, (int) (z + radius * Math.sin(i)), block);
			}
			
			radius--;
		}
	}

public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("sirenmod:null");
	}
}

