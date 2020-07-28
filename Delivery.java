/** The class Delivery represents a customer's 
    order, including all the details needed to
	make a shipment

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

import java.util.*;
import java.text.*;
import java.time.*;
public class Delivery
{
	final public Parcel[] parcels = new Parcel[6];
	
	/** This constructor receives the basic details needed
		for the shipment, such as the recipient name, destination,
		nunber of items to be shipped, and if the customer wants
		the item to be insured.
		
		@param rec The name of the recipient (format: String)
		@param reg The destination/region of the intended delivery (format: String)
		@param num The number of items to be delivered (format: int)
		@param ins whether the customer wants the parcel to be insured (format: boolean)
	*/	
	public Delivery (String rec, String reg, int num, boolean ins)
	{
		this.recipient = rec;
		if (reg.equalsIgnoreCase("Metro Manila")||reg.equalsIgnoreCase("Luzon")||reg.equalsIgnoreCase("Visayas")||reg.equalsIgnoreCase("Mindanao"))
			this.region = reg;
		else
		{
			System.out.println ("Invalid region, setting default destination to Metro Manila");
			this.region = "Metro Manila";
		}
		if (num >= 1)
			this.numItems = num;
		else
		{
			System.out.println ("Invalid number, setting default number of items to 1");
			this.numItems = 1;
		}
		this.ifInsure = ins;
		parcels[0] = new Parcel (9, 14, 1, 3, 30, 1);
		parcels[1] = new Parcel (12, 18, 3, 3, 50, 2);
		parcels[2] = new Parcel (12, 10, 5, 3);
		parcels[3] = new Parcel (14, 11, 7, 4);
		parcels[4] = new Parcel (18, 12, 9, 5);
		parcels[5] = new Parcel (20, 16, 12, 6);
	}

	/** This method returns the name of the recipient
	
		@return name of the recipient
	*/
	public String getRecipient ()
	{
		return recipient;
	}

	/** This method returns the destination of the parcel
		
		@return destination of parcel
	*/	
	public String getRegion ()
	{
		return region;
	}

	/** This method returns the number of items the customer wants to be delivered
		
		@return number of items to be delivered
	*/	
	public int getNumItems ()
	{
		return numItems;
	}

	/** This method returns if the parcel is insured or not
		
		@return 'true' if the parcel is insured, 'false' otherwise
	*/	
	public boolean getIfInsure ()
	{
		return ifInsure;
	}
	
	/** This method gets the items to be packed in the parcel
	
		@return items the items to be packed in the parcel
	*/
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	/** This method adds an item to the parcel to be delivered
		
		@param item the item to be added to the parcel
	*/	
	public void addItem(Item item)
	{
		if (item.getType().equalsIgnoreCase("Document")||item.getType().equalsIgnoreCase("Regular product")||item.getType().equalsIgnoreCase("Irregular Product"))
			items.add(item);
		else
			System.out.println ("Invalid item type, please input valid type");
	}

	/** This method removes an item from the existing items to be 
		packed in the parcel
		
		@param number the number of the item that is to be removed
	*/
	
	public void removeItem(int number)
	{
		items.remove(number-1);
	}
	
	/** This method finds the greatest length of the items of the customer
		and stores it in the appropriate variable/attribute
	*/		
	public void setMaxLength ()
	{
		int i;
		double max = items.get(0).getLength();
		for (i = 1; i < items.size(); i++)
			if (max < items.get(i).getLength())
				max = items.get(i).getLength();
		maxLength = max;
	}

	/** This method computes the greatest width of the items of the customer
		and stores it in the appropriate variable/attribute
	*/		
	public void setMaxWidth ()
	{
		int i;
		double max = items.get(0).getWidth();
		for (i = 1; i < items.size(); i++)
			if (max < items.get(i).getWidth())
				max = items.get(i).getWidth();
		maxWidth = max;
	}

	/** This method computes the total height of the items of the customer
		and stores it in the appropriate variable/attribute
	*/
	public void setTotalHeight ()
	{
		int i;
		double total = 0;
		for (i = 0; i < items.size(); i++)
			total += items.get(i).getHeight();
		totalHeight = total;
	}
	
	/** This method computes the total weight of the items of the customer
		and stores it in the appropriate variable/attribute
	*/		
	public void setTotalWeight ()
	{
		int i;
		double total = 0;
		for (i = 0; i < items.size(); i++)
			total += items.get(i).getWeight();
		totalWeight = total;
	}

	/** This method returns the greatest length of all the items the customer inputted
		
		@return total length of all items
	*/
	public double getMaxLength()
	{
		return maxLength;
	}

	/** This method returns the greatest width of all the items the customer inputted
		
		@return total width of all items
	*/
	public double getMaxWidth()
	{
		return maxWidth;
	}
	
	/** This method returns the computed total height of all the items the customer inputted
		
		@return total height of all items
	*/
	public double getTotalHeight()
	{
		return totalHeight;
	}
	
	/** This method returns the computed total weight of all the items the customer inputted
		
		@return total weight of all items
	*/
	public double getTotalWeight()
	{
		return totalWeight;
	}
	
	/** This method computes the base rate, taking in to consideration 
		all the items inside the parcel
	*/
	public void setTotalBaseRate ()
	{
		int i;
		double total = 0;
		for (i = 0; i < items.size(); i++)
			total += items.get(i).getBaseRate();
		totalBaseRate = total;
	}
	
	/** This method returns the computed base rate of the parcel (including all the items)
		
		@return base rate of the parcel (including all the items)
	*/
	public double getTotalBaseRate()
	{
		return totalBaseRate;
	}
	
	/** This method overrides the toString() of the object class and will return 
		the information of the available parcel options
		
		@param p the parcel that is to be converted into a string
		
		@return information on the parcel options in String
	*/	
	public String parcelToString(Parcel p)
	{
		return p.getIndex() + ". " + p.getParcelLength() + " x " + p.getParcelWidth() + " x " + p.getParcelHeight(); 
	}
	
	/** This method sets the parcel to be used by the customer (according to his choice)

		@param p the parcel chosen by the customer
	*/
	public void setFinalParcel (Parcel p)
	{
		finalParcel = p;
	}
	
	/** This method gets the parcel chosen by the customer
		
		@return parcel as chosen by the customer
	*/
	public Parcel getFinalParcel ()
	{
		return finalParcel;
	}
	
	/** This method sets the destination of the parcel, as chosen
		by the customer
	*/
	public void setDestination ()
	{
		destination = new Destination (region, finalParcel);
	}
	
	/** This method gets the destination of the parcel, as chosen
		by the customer
		
		@return destination as chosen by the customer
	*/
	public Destination getDestination ()
	{
		return destination;
	}
	
	/** This method computes the total fee to be paid by the customer, including
		the base fee, the insurance fee, and the service fee
	*/
	public void setTotalFee()
	{
		totalFee = finalParcel.getTotalBaseRate() + destination.getServiceFee() + finalParcel.getInsuranceFee();
	}
	
	/** This method sets the delivery number for the current parcel.
		This will be used in creating the tracking ID for the parcel
	
		@param dNum the delivery number for the parcel
	*/
	public void setDeliveryNumber(int dNum)
	{
		deliveryNum = dNum;
	}

	/** This method gets the total fee to be paid by the customer
	
		@return total fee to be paid by the customer
	*/	
	public double getTotalFee()
	{
		return totalFee;
	}
	
	/** This method sets the current day.
		This will be used to create the tracking id
	
		@param d the current day 
	*/
	public void setDay (int d)
	{
		if (d >= 1 && d <= 31)
			day = d;
		else 
		{
			System.out.println ("Invalid day, setting day to 1");
			day = 1;
		}
	}
	
	/** This method sets the current month.
		This will be used to create the tracking id
	
		@param m the current month 
	*/
	public void setMonth (int m)
	{
		if (m >= 1 && m <=12)
			month = m;
		else 
		{
			System.out.println ("Invalid month, setting month to 1");
			month = 1;
		}
	}
	
	/** This method sets the current year.
		This will be used to create the tracking id
	
		@param y the current year 
	*/
	public void setYear (int y)
	{
		if (y >= 2000)
			year = y;
		else 
		{
			System.out.println ("Invalid year, setting year to 2019");
			year = 2019;
		}
	}
	
	/** This method gets the current day
	
		@return the current day
	*/
	public int getDay()
	{
		return day;
	}
	
	/** This method gets the current month
	
		@return the current month
	*/
	public int getMonth()
	{
		return month;
	}
	
	/** This method gets the current year
	
		@return the current year
	*/
	public int getYear()
	{
		return year;
	}
	
	/** This method sets the tracking id of the parcel
	*/
	public void setTrackingID()
	{
		DecimalFormat twoDigit = new DecimalFormat("#00");
		DecimalFormat threeDigit = new DecimalFormat("#000");
		trackingID = finalParcel.getType() + twoDigit.format(month) + twoDigit.format(day) + destination.getDestCode() + twoDigit.format(items.size()) + threeDigit.format(deliveryNum);
	}
	
	/** This method gets the tracking id of the parcel
	
		@return the tracking id of the parcel
	*/
	public String getTrackingID()
	{
		return trackingID;
	}
	
	/** This method sets the date when this delivery was started
	*/	
	public void setStartDate()
	{
		DecimalFormat twoDigit = new DecimalFormat("#00");
		startDate = twoDigit.format(month) + "/" + twoDigit.format(day) + "/" + year;
	}
	
	/** This method gets the date when this delivery was started
	
		@return date when this delivery was started
	*/	
	public String getStartDate()
	{
		return startDate;
	}
	
	/** This method sets the updated date for simulation purposes
	
		@param sim the number of days time will pass
	*/	
	public void setUpdateDate(int sim)
	{
		DecimalFormat twoDigit = new DecimalFormat("#00");
		updateDate = twoDigit.format(LocalDate.now().plusDays(sim).getMonthValue()) + "/" + twoDigit.format(LocalDate.now().plusDays(sim).getDayOfMonth()) + "/" + LocalDate.now().plusDays(sim).getYear();
	}

	/** This method gets the updated date for simulation purposes
	
		@return the updated date in String
	*/		
	public String getUpdateDate()
	{
		return updateDate;
	}
	
	private String recipient;
	private String region;
	private int numItems;
	private int deliveryNum;
	private ArrayList <Item> items = new ArrayList <Item>();
	private boolean ifInsure;
	private double totalHeight;
	private double totalWeight;
	private double maxWidth;
	private double maxLength;
	private double totalBaseRate;
	private Parcel finalParcel;
	private double totalFee;
	private int month;
	private int day;
	private int year;
	private Destination destination;
	private String trackingID;
	private String startDate;
	private String updateDate;
}	