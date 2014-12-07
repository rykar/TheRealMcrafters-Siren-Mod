package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.LightBlueSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperLightBlue extends MovingSound {
    private final TileEntity tileentity;
    private LightBlueSirenTileEntity tileLightBlue; 


    public SirenLooperLightBlue(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileLightBlue = (LightBlueSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileLightBlue.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}