package mcrafter.SirenMod.sirens.wall;

import mcrafter.SirenMod.client.audio.SirenLooperFireAlarm;
import mcrafter.SirenMod.client.audio.SirenLooperGreen;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;


public class FireAlarmTileEntity extends TileEntity {
	
	public float rotation = 0;
	public boolean activated;
	private boolean isPlaying = false;
	private boolean shouldStart = false; 
    private boolean shouldStop = false;
    
    
    public void updateEntity(){
    	
    	if (!isPlaying && shouldStart){
            shouldStart = false; 
            shouldStop = false; 
            isPlaying = true; 
            SirenLooperFireAlarm sirenFire = new SirenLooperFireAlarm(worldObj.getTileEntity(xCoord, yCoord, zCoord), "sirenFire"); 
            Minecraft.getMinecraft().getSoundHandler().playSound(sirenFire); 
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
