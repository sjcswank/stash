package interfaces;

import java.math.BigDecimal;
import java.util.Currency;

public interface Priceable {
	Currency curr;
	BigDecimal pricePerPack;
	int qtyPerPack;
	BigDecimal pricePerPiece;
	
	public void setCurr(String countryCode);
	public Currency getCurr();
	public void setPricePerPack(BigDecimal price);
	public BigDecimal getPricePerPack();
	public void setPricePerPiece();
	public BigDecimal getPricePerPiece();
	public void setQtyPerPack(int qtyPerPack);
	public int getQtyPerPack();
	

}
