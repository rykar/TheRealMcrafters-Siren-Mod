package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.WhiteSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperWhite extends MovingSound {
    private final TileEntity tileentity;
    private WhiteSirenTileEntity tileWhite; 


    public SirenLooperWhite(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileWhite = (WhiteSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileWhite.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}