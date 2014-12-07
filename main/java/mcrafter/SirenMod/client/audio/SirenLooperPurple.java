package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.PurpleSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperPurple extends MovingSound {
    private final TileEntity tileentity;
    private PurpleSirenTileEntity tilePurple; 


    public SirenLooperPurple(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tilePurple = (PurpleSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tilePurple.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}