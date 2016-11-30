package Objects;

public class ProjectMaterials {
	int qty;
	Material material;
	int qtyShort;
	
	public ProjectMaterials(Material material, int qty){
		this.material = material;
		this.qty = qty;
		if (material.quantity < qty){
			qtyShort = qty - material.quantity;
		}
		else {
			qtyShort = 0;
		}
	}
	
	public void setQty(int newQty){
		qty = newQty;
	}
	
	public void addQty(int addQty){
		qty += addQty;
	}
	
	public void subQty(int subQty){
		qty -= subQty;
	}
	
	public int getQty(){
		return qty;
	}
	
	public Material getMaterial(){
		return material;
	}
	
	public int getShort(){
		return qtyShort;
	}

}
