package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.BrownSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperBrown extends MovingSound {
    private final TileEntity tileentity;
    private BrownSirenTileEntity tileBrown; 


    public SirenLooperBrown(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileBrown = (BrownSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileBrown.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}