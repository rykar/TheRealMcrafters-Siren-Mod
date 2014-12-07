package mcrafter.SirenMod.client.audio;

import mcrafter.SirenMod.sirens.nuclear.NuclearSirenTileEntity;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class SirenLooperNuclear extends MovingSound {
    private final TileEntity tileentity;
    private NuclearSirenTileEntity tileNuclear; 


    public SirenLooperNuclear(TileEntity tile, String Soundname){ 
        super(new ResourceLocation("SirenMod:sirenNuclearBomb")); 
        this.tileentity = tile; 
        this.repeat = true; 
        volume = 2f;
        this.xPosF = tileentity.xCoord;
        this.yPosF = tileentity.yCoord;
        this.zPosF = tileentity.zCoord;
        tileNuclear = (NuclearSirenTileEntity) tileentity;
    }


    public void update(){  
        if (tileNuclear.isShouldStop()){    
            this.donePlaying = true;}
    }

@Override
    public boolean isDonePlaying(){
        return this.donePlaying;} 
}