package mcrafter.SirenMod.common;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class SiliconShard extends Item {
	
	public String textureName;
	
	public SiliconShard(String textureName) {
		super();
		this.textureName = textureName;
		this.setCreativeTab(SirenMod.SirenModCreativeTab);
		setUnlocalizedName(textureName);
	}
	
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon("sirenmod:SiliconShard");
	}

}
