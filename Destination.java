/** The class Destination represents the information
	regarding the available locations for shipment/delivery

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

public class Destination
{

	/** This constructor receives the intended region/destination
		and the parcel (specifically the size, which will be used
		to compute the service fee)
		
		@param reg The destination/region of the intended delivery (format: String)
		@param par The parcel chosen by the customer (format: Parcel)
	*/	
	public Destination (String reg, Parcel par)
	{
		if (reg.equalsIgnoreCase ("Metro Manila"))
		{
			this.region = reg;
			this.serviceFee = 50;
			this.deliveryDuration = 2;
			this.destCode = "MML";
			this.status = "Shipping";
			this.delivDay = 1;
		}
		else if (reg.equalsIgnoreCase ("Luzon"))
		{
			this.region = reg;
			this.serviceFee = 100;
			this.deliveryDuration = 3;
			this.destCode = "LUZ";
			this.status = "Preparing";
			this.delivDay = 1;
		}

		else if (reg.equalsIgnoreCase("Visayas"))
		{
			this.region = reg;
			if (0.10 * par.getSize() > 1000)
				this.serviceFee = 0.10 * par.getSize();
			else
				this.serviceFee = 1000;
			this.deliveryDuration = 5;
			this.destCode = "VIS";
			this.status = "Preparing";
			this.delivDay = 1;
		}
		
		else if (reg.equalsIgnoreCase("Mindanao"))
		{
			this.region = reg;
			if (0.25 * par.getSize() > 3000)
				this.serviceFee = 0.25 * par.getSize();
			else
				this.serviceFee = 3000;
			this.deliveryDuration = 8;
			this.destCode = "MIN";
			this.status = "Preparing";
			this.delivDay = 1;
		}
	}
	
	/** This method returns the region/destination
	
		@return the region/destination of the parcel/delivery
	*/
	public String getRegion ()
	{
		return region;
	}
	
	/** This method returns the service fee of the delivery
	
		@return the service fee of the delivery
	*/
	public double getServiceFee ()
	{
		return serviceFee;
	}
	
	/** This method returns the duration of the delivery
	
		@return the duration of the delivery
	*/
	public int getDuration ()
	{
		return deliveryDuration;
	}
	
	/** This method returns the current day of the delivery
	
		@return the current day of the delivery
	*/
	public int getDelivDay ()
	{
		return delivDay;
	}
	
	/** This method returns the destination code (used for the tracking id)
	
		@return the destination code
	*/
	public String getDestCode()
	{
		return destCode;
	}
	
	/** This method returns the current status of the parcel (whether it is preparing, shipping, or delivered)
	
		@return the current status of the parcel
	*/
	public String getStatus()
	{
		return status;
	}
	
	/** This method updates the status of the parcel (whether it is preparing, shipping, or delivered)
	*/
	public void updateStatus()
	{
		delivDay++;
		if (delivDay >= deliveryDuration)
			status = "Delivered";
		else if (delivDay > 1)
			status = "Shipping";
	}
	
	private String region;
	private double serviceFee;
	private int deliveryDuration;
	private int delivDay;
	private String destCode;
	private String status;	
}