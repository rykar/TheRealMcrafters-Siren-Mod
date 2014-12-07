package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.CyanSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperCyan extends MovingSound {
    private final TileEntity tileentity;
    private CyanSirenTileEntity tileCyan; 


    public SirenLooperCyan(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileCyan = (CyanSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileCyan.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}