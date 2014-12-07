package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.BlueSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperBlue extends MovingSound {
    private final TileEntity tileentity;
    private BlueSirenTileEntity tileBlue; 


    public SirenLooperBlue(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileBlue = (BlueSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileBlue.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}