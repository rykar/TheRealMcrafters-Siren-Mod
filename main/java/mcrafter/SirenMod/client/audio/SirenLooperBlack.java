package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.BlackSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperBlack extends MovingSound {
    private final TileEntity tileentity;
    private BlackSirenTileEntity tileBlack; 


    public SirenLooperBlack(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileBlack = (BlackSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileBlack.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}