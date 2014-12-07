package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.LightGreySirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperLightGrey extends MovingSound {
    private final TileEntity tileentity;
    private LightGreySirenTileEntity tileLightGrey; 


    public SirenLooperLightGrey(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileLightGrey = (LightGreySirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileLightGrey.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}