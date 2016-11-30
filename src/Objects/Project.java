package Objects;

import java.util.*;
import interfaces.*;

public class Project extends Entity implements Storable {
	
	Location location;
	boolean isActive;
	int totalTime;
	int canMake = 0;
	List<ProjectMaterials> materialsNeeded;
	
	public void setLocation(Location newLocation){
		if (!newLocation.getIsFull() || location != newLocation) {
			location = newLocation;
			newLocation.addProject(this);
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
		this.location.removeProject(this);
			if(this.location.getIsFull()){
				this.location.setIsFull(false);
			}
		}
	}
	
	public void setIsActive(boolean activityState){
		if (activityState == true){
			//iterate materialsNeeded
			Iterator<ProjectMaterials> itr = materialsNeeded.iterator();
			while (itr.hasNext()){
				Material pm = itr.next().getMaterial();
				int qty = itr.next().getQty();
				pm.addInUse(qty);
			}
		}
		else{
			if (isActive){
				Iterator<ProjectMaterials> itr = materialsNeeded.iterator();
				while (itr.hasNext()){
					Material pm = itr.next().getMaterial();
					int qty = itr.next().getQty();
					pm.subInUse(qty);
				}
			}
		}
		isActive = activityState;
	}
	
	public boolean getIsActive(){
		return isActive;
	}
	
	public void setTotalTime(int hours, int minutes){
		int time = minutes;
		time += (hours * 60);
		totalTime = time;
	}
	
	public void addTime(int hours, int minutes){
		int time = minutes;
		time += (hours * 60);
		totalTime += time;
	}
	
	public void subTime(int hours, int minutes){
		int time = minutes;
		time += (hours * 60);
		totalTime -= time;
	}
	
	public int getTotalTime(){
		return totalTime;
	}
	
	public void setCanMake(){
		int a = this.materialsNeeded.get(0).getQty();
		int b = this.materialsNeeded.get(0).getMaterial().getQuantity();
		canMake = (b/a) - (b/a)%1;
		for (int i =1; i < this.materialsNeeded.size(); i++){
			a = this.materialsNeeded.get(i).getQty();
			b = this.materialsNeeded.get(i).getMaterial().getQuantity();
			int holder = (b/a) - (b/a)%1;
			if (holder <= 0){
				canMake = 0;
			}
			else if (holder < canMake){
				canMake = holder;
			}
			else {}
		}
	}
	
	public int getCanMake(){
		this.setCanMake();
		return canMake;
	}
	
	public void addMaterial(Material material, int qty){
		material.addToUsedIn(this, qty);
	}
	
	public List<ProjectMaterials> getMaterialsNeeded(){
		return materialsNeeded;
	}
	
	public List<ProjectMaterials> getMaterialsShort(){
		List<ProjectMaterials> itemsShort = new ArrayList<ProjectMaterials>();
		ListIterator<ProjectMaterials> itr = materialsNeeded.listIterator();
		while (itr.hasNext()){
			ProjectMaterials m = (ProjectMaterials) itr.next();
			if (m.getShort() > 0){
				itemsShort.add(m);
			}
		}
		return itemsShort;
	}
	
	public int getAmtShort(Material material){
		int idx = materialsNeeded.indexOf(material);
		return materialsNeeded.get(idx).getShort();
	}
	
}
