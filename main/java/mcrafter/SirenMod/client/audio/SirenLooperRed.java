package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.RedSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperRed extends MovingSound {
    private final TileEntity tileentity;
    private RedSirenTileEntity tileRed; 


    public SirenLooperRed(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileRed = (RedSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileRed.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}