/** The class Item represents the information
	regarding the items of a customer, including the
	determination and selection of items

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

import java.util.*;
public abstract class Item
{
	
	/** This constructor receives the item type and its length and width.
		Invalid values will be set to a default size (9 inches and 10 inches respectively)
		
		@param type The type of the item (format: String)
		@param len The length of the item (format: double)
		@param wid The width of the item (format: double)
	*/	
	public Item (String type, double len, double wid)
	{
		this.itemType = type;
		if (len>0)
			this.length = len;
		else
		{
			System.out.println ("Invalid length, setting length to 9 inches");
			this.length = 9;
		}
		if (wid>0)
			this.width = wid;
		else
		{
			System.out.println ("Invalid width, setting width to 10 inches");
			this.width = 10;
		}
	}
	
	/** This constructor receives the item type, its length, width, height, and weight.
		Invalid values will be set to a default size (9 inches, 10 inches, 1 inch, and 3 kg respectively)
		
		@param type The type of the item (format: String)
		@param len The length of the item (format: double)
		@param wid The width of the item (format: double)
		@param hgt The height of the item (format: double)
		@param wgt The weight of the item (format: double)
	*/	
	public Item (String type, double len, double wid, double hgt, double wgt)
	{
		this.itemType = type;
		if (len > 0)
			this.length = len;
		else
		{
			System.out.println ("Invalid length, setting length to 9 inches");
			this.length = 9;
		}
		if (wid > 0)
			this.width = wid;
		else
		{
			System.out.println ("Invalid width, setting width to 10 inches");
			this.width = 10;
		}
		if (hgt > 0)
			this.height = hgt;
		else
		{
			System.out.println ("Invalid height, setting height to 1 inch");
			this.height = 1;
		}
		if (wgt > 0)
			this.weight = wgt;
		else
		{
			System.out.println ("Invalid weight, setting weight to 3 kilograms");
			this.weight = 3;
		}
	}
	
	/** This method sets the item type of the item
	
		@param type the type of the item
	*/
	public void setItemType (String type)
	{
		itemType = type;
	}
	
	/** This method sets the height of the item
	
		@param hgt The height of the item
	*/
	public void setHeight (double hgt)
	{
		if (hgt >= 0)
			height = hgt;
		else
		{
			System.out.println ("Invalid height, setting height to 1 inch");
			height = 1;
		}
			
	}
	
	/** This method sets the weight of the item
	
		@param wgt The weight of the item
	*/
	public void setWeight (double wgt)
	{
		if (wgt > 0)
			weight = wgt;
		else
		{
			System.out.println ("Invalid weight, setting weight to 3 kilograms");
			weight = 3;
		}
	}
	
	/** This method returns the item type of the item
	
		@return the type of the item
	*/
	public String getType ()
	{
		return itemType;
	}
	
	/** This method returns the length of the item
	
		@return the length of the item
	*/
	public double getLength ()
	{
		return length;
	}

	/** This method returns the width of the item
	
		@return the width of the item
	*/	
	public double getWidth ()
	{
		return width;
	}
	
	/** This method returns the height of the item
	
		@return the height of the item
	*/	
	public double getHeight ()
	{
		return height;
	}
	
	/** This method returns the weight of the item
	
		@return the weight of the item
	*/	
	public double getWeight ()
	{
		return weight;
	}
	
	/** This method sets the base rate of the item
	*/	
	public abstract void setBaseRate();
	
	/** This method returns the base rate of the item
	
		@return the base rate of the item
	*/	
	public double getBaseRate ()
	{
		return baseRate;
	}
	
	/** This method returns the dimmensions of the item in String
	
		@return the dimmensions of the item in String
	*/
	public String itemToString()
	{
		return length + " x " + width + " x " + height;
	}		
	
	private String itemType;
	protected double length;
	protected double width;
	protected double height;
	protected double weight;
	protected double baseRate;
}

