package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.GreenSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperGreen extends MovingSound {
    private final TileEntity tileentity;
    private GreenSirenTileEntity tileGreen; 


    public SirenLooperGreen(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileGreen = (GreenSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileGreen.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}