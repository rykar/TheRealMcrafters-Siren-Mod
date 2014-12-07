package mcrafter.SirenMod.sirens.nuclear;

import mcrafter.SirenMod.client.audio.SirenLooperBlue;
import mcrafter.SirenMod.client.audio.SirenLooperNuclear;
import mcrafter.SirenMod.common.SirenMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

	public class NuclearSirenTileEntity extends TileEntity{
		
		public float rotation = 0;
		public double timer;
		public int isOn = 0;
		private boolean isPlaying = false;
		private boolean shouldStart = false; 
	    private boolean shouldStop = false;
		
		NuclearSiren siren = new NuclearSiren(null);
					
		public void updateEntity(){
			if (!isPlaying && shouldStart){
	            shouldStart = false; 
	            shouldStop = false; 
	            isPlaying = true; 
	            SirenLooperNuclear sirenNuclearBomb = new SirenLooperNuclear(worldObj.getTileEntity(xCoord, yCoord, zCoord), "sirenNuclearBomb"); 
	            Minecraft.getMinecraft().getSoundHandler().playSound(sirenNuclearBomb); 
	        }
						
			if (isOn == 1){				
				if (timer > 1000){
					timer = 0;}
				else{
					timer = timer + 1;
					siren.loop(worldObj, xCoord, yCoord, zCoord);}				
			}			
		}
		
		public void toggleOn(World world){
			isOn = 1;
			if (worldObj.isRemote){
				SirenMod.proxy.playSound(world, xCoord, yCoord, zCoord, "SirenMod:sirenNuclearBomb");
			}
		}
				
		public void toggleOff(){
			isOn = 0;}

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