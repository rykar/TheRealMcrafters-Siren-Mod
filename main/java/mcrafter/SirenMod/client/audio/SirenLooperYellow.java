package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.YellowSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperYellow extends MovingSound {
    private final TileEntity tileentity;
    private YellowSirenTileEntity tileYellow; 


    public SirenLooperYellow(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileYellow = (YellowSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileYellow.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}