/** The class RegularProduct (part of the class Item) represents the information
	regarding an item as a regular product

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

public class RegularProduct extends Item
{
	/** This constructor receives the type, length, width, height, and weight
		of the regular product
		
		@param type The type of the item
		@param len The length of the regular product (format: double)
		@param wid The width of the regular product (format: double)
		@param hgt The height of the regular product (format: double)
		@param wgt The weight of the regular product (format: double)
	*/	
    public RegularProduct(String type, double len, double wid, double hgt, double wgt)
    {
    	super (type, len, wid, hgt, wgt);
    	setBaseRate();
    }
	
	/** This method sets the base rate of the regular product
	*/	
	public void setBaseRate()
	{
		baseRate = weight * 40;
	}
}