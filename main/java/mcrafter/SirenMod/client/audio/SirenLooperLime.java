package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.LimeSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperLime extends MovingSound {
    private final TileEntity tileentity;
    private LimeSirenTileEntity tileLime; 


    public SirenLooperLime(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileLime = (LimeSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileLime.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}