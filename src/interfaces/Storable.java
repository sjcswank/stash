package interfaces;

import Objects.Location;

public interface Storable {
	//Materials and Projects can be stored in locations
	public void setLocation(Location newLocation);
	public Location getLocation();
	public void removeLocation();

}
