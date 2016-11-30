package Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.UUID;

abstract class Entity {
  UUID uuid;
  String name;
  String desc;
  Currency curr;
  BigDecimal pricePerPack;
  int qtyPerPack;
  BigDecimal pricePerPiece;
  int quantity;
  
  //generate random UUIDs
  public Entity(String... aArgs){
    UUID idOne = UUID.randomUUID();
    uuid = idOne;
  }
 
  public void setName(String newName){
	  name = newName;
  }
  
  public String getName(){
	  return name;
  }
  
	public void setDesc(String description){
		desc = description;
	}
	
	public void removeDesc(){
		desc = null;
	}
	
	public String getDesc(){
		return desc;
	}
	
	//set currency for user location
	public void setCurr(String currencyCode){
		curr = Currency.getInstance(currencyCode);
	}
	
	public Currency getCurr(){
		return curr;
	}
	
	public void setPricePerPack(BigDecimal price){
		pricePerPiece = price;
	}
	
	public BigDecimal getPricePerPack(){
		return pricePerPack;
	}
	
	public void setPricePerPiece(){
		pricePerPiece = pricePerPack.divide(BigDecimal.valueOf(qtyPerPack), 2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getPricePerPiece(){
		return pricePerPiece;
	}
	
	public void setQtyPerPack(int qtyPerPack){
		this.qtyPerPack = qtyPerPack;
	}
	
	public int getQtyPerPack(){
		return qtyPerPack;
	}
	
	public void setQuantity(int newQuantity){
		quantity = newQuantity;
	}
	public void addQuantity(int addQuantity){
		quantity += addQuantity;
	}
	public void subtractQuantity(int subQuantity){
		quantity -= subQuantity;
	}
	public void removeQuantity(){
		quantity = 0;
	}
	public int getQuantity(){
		return quantity;
	}
  
} 