package mcrafter.SirenMod.sirens.wall;

import mcrafter.SirenMod.client.audio.SirenLooperBurglarAlarm;
import mcrafter.SirenMod.client.audio.SirenLooperFireAlarm;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;


public class BurglarSirenTileEntity extends TileEntity {
	
	private boolean isPlaying = false;
	private boolean shouldStart = false; 
    private boolean shouldStop = false;
    
    
    public void updateEntity(){
    	
    	if (!isPlaying && shouldStart){
            shouldStart = false; 
            shouldStop = false; 
            isPlaying = true; 
            SirenLooperBurglarAlarm sirenBurglar = new SirenLooperBurglarAlarm(worldObj.getTileEntity(xCoord, yCoord, zCoord), "sirenBurglar"); 
            Minecraft.getMinecraft().getSoundHandler().playSound(sirenBurglar); 
        }
    	
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
