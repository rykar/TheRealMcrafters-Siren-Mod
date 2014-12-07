package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.PinkSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperPink extends MovingSound {
    private final TileEntity tileentity;
    private PinkSirenTileEntity tilePink; 


    public SirenLooperPink(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tilePink = (PinkSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tilePink.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}