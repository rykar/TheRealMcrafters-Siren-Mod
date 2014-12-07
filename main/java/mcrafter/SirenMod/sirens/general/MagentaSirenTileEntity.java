package mcrafter.SirenMod.sirens.general;

import mcrafter.SirenMod.client.audio.SirenLooperBlue;
import mcrafter.SirenMod.client.audio.SirenLooperMagenta;
import mcrafter.SirenMod.common.SirenMod;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;


public class MagentaSirenTileEntity extends TileEntity {
	public float rotation = 0;
	public double timer;
	public int isOn = 0;
	private boolean isPlaying = false;
	private boolean shouldStart = false; 
    private boolean shouldStop = false;
	
	MagentaGeneralSiren siren = new MagentaGeneralSiren(null);
				
	public void updateEntity(){
		
		if (!isPlaying && shouldStart){
            shouldStart = false; 
            shouldStop = false; 
            isPlaying = true; 
            SirenLooperMagenta sirenOne = new SirenLooperMagenta(worldObj.getTileEntity(xCoord, yCoord, zCoord), "sirenOne"); 
            Minecraft.getMinecraft().getSoundHandler().playSound(sirenOne); 
        }
	
		if (isOn == 1){
			if (timer > 1000){
				timer = 0;
			} else {
				timer = timer + 1;
				siren.loop(worldObj, xCoord, yCoord, zCoord);
			}				
		}
	}
	
	public void toggleOn(){
		isOn = 1;
		if (worldObj.isRemote){
			SirenMod.proxy.playSound(worldObj, xCoord, yCoord, zCoord, "SirenMod:sirenOne");
		}
	}
	
	public void toggleOff(){
		isOn = 0;
	}
	
	public boolean isShouldStop(){
        return shouldStop;}

    public void setShouldStart(boolean shouldStart){ 
        this.shouldStart = shouldStart;}

    public void setShouldStop(boolean shouldStop){
        if (isPlaying){
        	isPlaying = false; 
            this.shouldStop = shouldStop;}}

    public boolean isPlaying(){
        return isPlaying;}
}