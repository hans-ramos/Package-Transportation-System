/** The class Parcel represents the information
	regarding the parcel that is to pack and deliver the
	items of the customer

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

public class Parcel
{

	/** This constructor receives the length, width, height, weight, the base rate, and the
		index of a flat parcel type
		
		@param length The length of the flat parcel (format: double)
		@param width  The width of the flat parcel (format: double)
		@param height The height of the flat parcel (format: double)
		@param weight The weight capacity of the flat parcel (format: double)
		@param bRate The base rate of the flat parcel (format: double)
		@param ind The index of the flat parcel (format: int)
	*/	
	public Parcel (double length, double width, double height, double weight, double bRate, int ind)
	{
		this.parcelLength = length;
		this.parcelWidth = width;
		this.parcelHeight = height;
		this.parcelWeight = weight;
		this.totalBaseRate = bRate;
		this.index = ind;
		this.insuranceFee = 0;
		this.type = "FLT";
	}		
	
	/** This constructor receives the length, width, height, the base rate, and the
		index of a box parcel type
		
		@param length The length of the box parcel (format: double)
		@param width  The width of the box parcel (format: double)
		@param height The height of the box parcel (format: double)
		@param ind The index of the box parcel (format: int)
	*/	
	public Parcel (double length, double width, double height, int ind)
	{
		this.parcelLength = length;
		this.parcelWidth = width;
		this.parcelHeight = height;
		this.totalBaseRate = 0;
		this.index = ind;
		this.insuranceFee = 0;
		this.type = "BOX";
	}	

	/** This method returns the length of the parcel
	
		@return length of the parcel
	*/
	public double getParcelLength ()
	{
		return parcelLength;
	}

	/** This method returns the width of the parcel
	
		@return width of the parcel
	*/
	public double getParcelWidth ()
	{
		return parcelWidth;
	}
	
	/** This method returns the height of the parcel
	
		@return height of the parcel
	*/
	public double getParcelHeight ()
	{
		return parcelHeight;
	}
	
	/** This method returns the weight of the parcel
	
		@return weight of the parcel
	*/
	public double getParcelWeight ()
	{
		return parcelWeight;
	}
	
	/** This method sets the insurance fee of the parcel
	
		@param nItems The number of items included in the parcel
	*/
	public void setInsuranceFee (int nItems)
	{
		if (nItems >= 1)
			insuranceFee = nItems * 5;
		else
			System.out.println ("Cannot compute for insurance fee due to invalid number of items");
	}
	
	/** This method sets the total base rate of the parcel from
		the base rates of the items
	
		@param baseRate The base rate of the item
	*/
	public void setTotalBaseRate (double baseRate)
	{
		if (baseRate >= 0)
			totalBaseRate += baseRate;
		else
			System.out.println ("Cannot add negative base rate");
	}
	
	/** This method returns the insurance fee of the parcel
	
		@return insurance fee of the parcel
	*/
	public double getInsuranceFee ()
	{
		return insuranceFee;
	}
	
	/** This method returns the total base rate of the parcel
	
		@return total base rate of the parcel
	*/
	public double getTotalBaseRate ()
	{
		return totalBaseRate;
	}
	
	/** This method returns the index in relation to the parcel
	
		@return index in relation to the parcel
	*/
	public int getIndex ()
	{
		return index;
	}
	
	/** This method sets the size of the parcel
	
		@param weight The weight of the parcel
	*/
	public void setSize(double weight)
	{
		size = weight;
	}	
	
	/** This method returns the size of the parcel
	
		@return size of the parcel
	*/
	public double getSize ()
	{
		return size;
	}
	
	/** This method returns the type of the parcel
	
		@return type of the parcel
	*/
	public String getType()
	{
		return type;
	}
	
	private double parcelLength;
	private double parcelWidth;
	private double parcelHeight;
	private double parcelWeight;
	private double parcelVolume;
	private double totalBaseRate;
	private int insuranceFee;
	private int index;
	private double size;
	private String type;
}