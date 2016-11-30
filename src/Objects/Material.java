package Objects;

import java.util.*;
import interfaces.*;

public class Material extends Entity implements Storable {
	
	Location location;
	List<Project> usedIn;
	int inUse;
	int available;
	
	public void setLocation(Location newLocation){
		if (!newLocation.getIsFull() || location != newLocation) {
			location = newLocation;
			newLocation.addMaterial(this);
		}
		//if isFull == true
		//throw error
		
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void removeLocation(){
		if (this.location != null){
			location = null;
			this.location.removeMaterial(this);
				if(this.location.getIsFull()){
					this.location.setIsFull(false);
				}
			}
		//if location is null do nothing
	}
	
	public void setInUse(int usingAmt){
		inUse = usingAmt;
	}
	
	public void addInUse(int usingAmt){
		inUse += usingAmt;
	}
	
	public void subInUse(int notUsingAmt){
		inUse -= notUsingAmt;
	}
	
	public int getInUse(){
		return inUse;
	}
	
	public void setAvailable(){
		available = quantity - inUse;
	}
	
	public int getAvailable(){
		return available;
	}
	
	public void addToUsedIn(Project project, int qty){
		if (!usedIn.contains(project) || project.getIsActive()){
		usedIn.add(project);
		this.addInUse(qty);
		project.addMaterial(this, qty);
		}
		else if (!usedIn.contains(project)){
			usedIn.add(project);
			project.addMaterial(this, qty);
		}
		//if project is in usedIn do nothing
	}
	
	public List<Project> getUsedIn(){
		return this.usedIn;
	}
	
	
}
