package interfaces;

public interface Quantifiable {
	int quantity;
	
	public void setQuantity(int newQuantity);
	public void addQuantity(int quantity);
	public void subtractQuantity(int quantity);
	public void removeQuantity();
	public int getQuantity();

}
