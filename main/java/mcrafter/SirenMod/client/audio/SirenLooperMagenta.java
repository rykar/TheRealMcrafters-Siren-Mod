package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.general.MagentaSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperMagenta extends MovingSound {
    private final TileEntity tileentity;
    private MagentaSirenTileEntity tileMagenta; 


    public SirenLooperMagenta(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenOne")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileMagenta = (MagentaSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileMagenta.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}