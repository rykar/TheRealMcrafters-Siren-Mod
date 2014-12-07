package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.GreySirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperGrey extends MovingSound {
    private final TileEntity tileentity;
    private GreySirenTileEntity tileGrey; 


    public SirenLooperGrey(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileGrey = (GreySirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileGrey.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}