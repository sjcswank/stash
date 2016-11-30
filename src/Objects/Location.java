package Objects;

import java.util.*;

public class Location extends Entity {
	
	boolean isFull;
	List<Material> heldMaterials = new ArrayList<Material>();
	List<Project> heldProjects = new ArrayList<Project>();
	
	public Location(String name){
		super(name);
	}
	
	public void setIsFull(boolean full){
		isFull = full;
	}
	
	public boolean getIsFull(){
		return isFull;
	}
	
	public void addMaterial(Material material){
		if (!isFull || !this.heldMaterials.contains(material)) {
			heldMaterials.add(material);
			material.setLocation(this);
			}
	}
	
	public void removeMaterial(Material material){
		int idx = heldMaterials.indexOf(material);
		heldMaterials.remove(idx);
		material.setLocation(null);
		if (this.isFull == true){
			this.isFull = false;
		}
	}

	public List<Material> getHeldMaterials(){
		return heldMaterials;
	}
	
	public void addProject(Project project){
		if (!isFull || !this.heldProjects.contains(project)) {
		heldProjects.add(project);
		project.setLocation(this);
		}
	}
	
	public void removeProject(Project project){
		int idx = heldProjects.indexOf(project);
		heldProjects.remove(idx);
		project.setLocation(null);
		if (this.isFull == true){
			this.isFull = false;
		}
	}

	public List<Project> getHeldProjects(){
		return heldProjects;
	}
}
