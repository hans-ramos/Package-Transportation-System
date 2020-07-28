/** The class IrregularProduct (part of the class Item) represents the information
	regarding an item as a irregular product

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

public class IrregularProduct extends Item
{
	/** This constructor receives the type, length, width, height, and weight
		of the irregular product
		
		@param type The type of the item
		@param len The length of the irregular product (format: double)
		@param wid The width of the irregular product (format: double)
		@param hgt The height of the irregular product (format: double)
		@param wgt The weight of the irregular product (format: double)
	*/	
	public IrregularProduct (String type, double len, double wid, double hgt, double wgt)
    {
    	super (type, len, wid, hgt, wgt);
    	setVolumeWeight();
    	setBaseRate();
    }
    
	/** This method sets the volumetric weight of the irregular shaped product
	*/	
	public void setVolumeWeight ()
	{
		volumeWeight = Math.ceil((length * width * height) / 305);
	}
	
	/** This method sets the base rate of the irregular shaped product
	*/	
	public void setBaseRate()
	{
		if (volumeWeight * 30 >= weight * 40)
			 baseRate = 30 * volumeWeight;
		 else
			 baseRate = 40 * weight;
	}
	
	private double volumeWeight;
}