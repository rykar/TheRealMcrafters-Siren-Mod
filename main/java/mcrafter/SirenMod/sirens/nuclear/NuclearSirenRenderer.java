package mcrafter.SirenMod.sirens.nuclear;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;


public class NuclearSirenRenderer extends TileEntitySpecialRenderer {
    
    //The model of your block
    final NuclearSirenModel model;
    
    public NuclearSirenRenderer() {
            this.model = new NuclearSirenModel();
    }
    
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) 
    {
       GL11.glPushMatrix();
       GL11.glTranslatef((float)x+0.5F, (float)y+1.5F, (float)z+0.5F);
       GL11.glRotatef(180, 0F, 0F, 1F);
       GL11.glRotatef(270, 0F, 1F, 0F);
       
       int meta = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
       
       
       if (meta==5) meta = 1;
          else if (meta==2) meta=0; 
       if (meta==4) meta = 3;
          else if (meta==3) meta=2;
       GL11.glRotatef(90 * meta, 0F, 1F, 0F);
       
       
       ResourceLocation textures = (new ResourceLocation("sirenmod:textures/blocks/NuclearSirenModel.png"));
       this.bindTexture(textures);
       
       model.MainHub.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Hub.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece1.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece2.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece3.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece4.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece5.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece6.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece7.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece8.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece9.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece10.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece11.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece12.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       model.Piece13.rotateAngleY = ((NuclearSirenTileEntity)tileentity).rotation;
       
       



       
       this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
       GL11.glPopMatrix();
    }
      
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
            Tessellator tess = Tessellator.instance;
            float brightness = block.getLightValue(world, i, j, k);
            int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
            int modulousModifier = skyLight % 65536;
            int divModifier = skyLight / 65536;
            tess.setColorOpaque_F(brightness, brightness, brightness);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }
}