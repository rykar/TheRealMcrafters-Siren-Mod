package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.OrangeSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperOrange extends MovingSound {
    private final TileEntity tileentity;
    private OrangeSirenTileEntity tileOrange; 


    public SirenLooperOrange(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileOrange = (OrangeSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileOrange.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}