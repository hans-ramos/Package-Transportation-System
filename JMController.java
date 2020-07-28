import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.time.*;

public class JMController implements ActionListener, ItemListener
{
	/** This constructor initializes the controller and 
		applys methods in this controller to the GUI
		
		@param gui the GUI where this controller will be added
	*/
	public JMController(JMGUI gui)
	{
		this.gui = gui;
		gui.addListeners(this);
		elapsedTime = 0;
		deliveryNum = 1;
		simDays = 0;
		found = false;
	}
	
	/** This method adds a function for the buttons with ActionListeners
	*/
	public void actionPerformed (ActionEvent e)
	{
		// If button that is pressed says "Check-in"
		if (e.getActionCommand().equals ("Check-in"))
		{
			// Switches to the check in panel
			gui.updateCenterPanel(gui.CHECKIN);
		}
		
		// If button that is pressed says "Track"
		else if (e.getActionCommand().equals ("Track"))
		{
			// Switches to track panel
			gui.updateCenterPanel(gui.TRACK);
			/* Time is computed by how many seconds has the program been running
			   subtracted with how many seconds has been recorded
			*/
			time = System.nanoTime()/1000000000 - elapsedTime;
			// If time is greater than or equal to 15, then one day is simulated
			if (time/15 >= 1)
			{
				// Records how many seconds has the program been running
				elapsedTime = System.nanoTime()/1000000000;
				simDays++;
				// Resets the delivery number back to 1 since it is a new day
				deliveryNum = 1;
				for (i = 0; i <deliveries.size(); i++)
				// Updates statuses to simulated date	
					deliveries.get(i).getDestination().updateStatus();
			}
		}

		// If button that is pressed says "Administrator"
		else if (e.getActionCommand().equals ("Administrator"))
		{
			// Switches to login panel
			gui.updateCenterPanel(gui.LOGIN);
		}

		// If button that is pressed says "Save"
		else if (e.getActionCommand().equals ("Save"))
		{
			if (gui.getRegionsBox().getSelectedItem().equals("<Regions>"))
				JOptionPane.showMessageDialog(gui,"Please choose a region");
			// Checks if num item field is valid and if a radio button is selected
			else
			{
				if (gui.getNumItem() >= 1 && gui.getYes().isSelected())
				{
					delivery = new Delivery (gui.getRecipient(), region, gui.getNumItem(), true);
					numItems = delivery.getNumItems();
					// Switches to item type selection panel
					gui.updateCenterPanel(gui.ITEMTYPE);
				}			
				else if (gui.getNumItem() >=1 && gui.getNo().isSelected())
				{
					delivery = new Delivery (gui.getRecipient(), region, gui.getNumItem(), false);
					numItems = delivery.getNumItems();
					gui.updateCenterPanel(gui.ITEMTYPE);
				}
				// Displays error message if invalid input is found or if both radio buttons are unselected
				else
					JOptionPane.showMessageDialog(gui,"Invalid Input");
			}
		}
		
		// If button that is pressed says "cancel"
		else if (e.getActionCommand().equals ("Cancel"))
		{
			// Returns to menu
			gui.updateCenterPanel(gui.MENU);
			// Resets all fields and combo box of available parcels
			gui.resetFields();
			gui.resetParcelsBox();
		}

		// User chooses to add a document
		else if (e.getActionCommand().equals ("Document"))
		{
			gui.resetFields();
			// Switches to document panel
			gui.updateCenterPanel(gui.DOCUMENT);
		}

		// User chooses to add a regular product
		else if (e.getActionCommand().equals ("Regular Product"))
		{
			gui.resetFields();
			// Switches to regular product panel
			gui.updateCenterPanel(gui.REGULARPRODUCT);	
		}
		
		// User chooses to add an irregular product
		else if (e.getActionCommand().equals ("Irregular Product"))
		{
			gui.resetFields();
			// Switches to irregular product panel
			gui.updateCenterPanel(gui.IRREGULARPRODUCT);	
		}
		
		else if (e.getActionCommand().equals ("Add Document"))
		{
			// Checks if fields are valid
			if (gui.getDocLength() >= 1 && gui.getDocWidth() >= 1 && gui.getDocPages() >= 1){
				numItems--;
				if (numItems>0)
				{
					// Returns to item type selection
					gui.updateCenterPanel(gui.ITEMTYPE);
					// Initializes document with inputted details and adds it to the delivery
					document = new Document ("Document", gui.getDocLength(), gui.getDocWidth(), gui.getDocPages());
					delivery.addItem(document);
				}
				else
				{
					document = new Document ("Document", gui.getDocLength(), gui.getDocWidth(), gui.getDocPages());
					delivery.addItem(document);
					// Sets the limits of the delivery
					delivery.setMaxLength();
					delivery.setMaxWidth();
					delivery.setTotalHeight();
					delivery.setTotalWeight();
					// Compares the parcels with the limits of the delivery
					for (i = 0; i < 2; i++)
						if (((delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth()) ||(delivery.getMaxLength() <= delivery.parcels[i].getParcelWidth() 
						&& delivery.getMaxWidth() <= delivery.parcels[i].getParcelLength())) && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight() && delivery.getTotalWeight() <= delivery.parcels[i].getParcelWeight())
						{
							// Adds the parcel to the list of available parcels if it is within the limits
							gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
						}
					for (i = 2; i < 6; i++)
						if (((delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth()) ||(delivery.getMaxLength() <= delivery.parcels[i].getParcelWidth() 
						&& delivery.getMaxWidth() <= delivery.parcels[i].getParcelLength())) && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight())
							gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
					// Updates the parcels combo box with the list of available parcels
					gui.updateParcelsBox();
					// If atleast one parcel is available, user can choose a parcel
					if (gui.getParcelsBox().getItemCount() > 1)
						gui.updateCenterPanel(gui.PARCEL);
					// If no parcels are available, user can remove an item or cancel the transaction
					else 
					{
						// Sets text area with the items in the delivery
						gui.setItemsArea(delivery);
						// Switches to remove panel
						gui.updateCenterPanel(gui.REMOVE);
					}
				}
			}
			else
				JOptionPane.showMessageDialog (gui, "Invalid input");
		}
		
		else if (e.getActionCommand().equals ("Add Regular Product"))
		{
			if (gui.getRProductLength() > 0 && gui.getRProductWidth() > 0 && gui.getRProductHeight() > 0 && gui.getRProductWeight() > 0){
				numItems--;
				if (numItems>0)
				{
					gui.updateCenterPanel(gui.ITEMTYPE);
					// Initializes and adds a regular product to the delivery
					rProduct = new RegularProduct ("Regular Product", gui.getRProductLength(), gui.getRProductWidth(), gui.getRProductHeight(), gui.getRProductWeight());
					delivery.addItem(rProduct);
				}
				else
				{
					rProduct = new RegularProduct ("Regular Product", gui.getRProductLength(), gui.getRProductWidth(), gui.getRProductHeight(), gui.getRProductWeight());
					delivery.addItem(rProduct);
					delivery.setMaxLength();
					delivery.setMaxWidth();
					delivery.setTotalHeight();
					delivery.setTotalWeight();
					for (i = 0; i < 2; i++)
					if (((delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth()) ||(delivery.getMaxLength() <= delivery.parcels[i].getParcelWidth() 
					&& delivery.getMaxWidth() <= delivery.parcels[i].getParcelLength())) && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight() && delivery.getTotalWeight() <= delivery.parcels[i].getParcelWeight())
							gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
					
					for (i = 2; i < 6; i++)
						if (((delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth()) ||(delivery.getMaxLength() <= delivery.parcels[i].getParcelWidth() 
						&& delivery.getMaxWidth() <= delivery.parcels[i].getParcelLength())) && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight())
							gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
					gui.updateParcelsBox();
					if (gui.getParcelsBox().getItemCount() > 1)
						gui.updateCenterPanel(gui.PARCEL);
					else 
					{
						gui.setItemsArea(delivery);
						gui.updateCenterPanel(gui.REMOVE);
					}					
				}
			}
			else
				JOptionPane.showMessageDialog (gui, "Invalid input");
		}
		
		else if (e.getActionCommand().equals ("Add Irregular Product"))
		{
			if (gui.getIProductLength() > 0 && gui.getIProductWidth() > 0 && gui.getIProductHeight() > 0 && gui.getIProductWeight() > 0){
				numItems--;
				if (numItems>0)
				{
					gui.updateCenterPanel(gui.ITEMTYPE);
					// Initializes and adds an irregular product to the delivery
					iProduct = new IrregularProduct ("Irregular Product", gui.getIProductLength(), gui.getIProductWidth(), gui.getIProductHeight(), gui.getIProductWeight());
					delivery.addItem(iProduct);
				}
				else
				{
					iProduct = new IrregularProduct ("Irregular Product", gui.getIProductLength(), gui.getIProductWidth(), gui.getIProductHeight(), gui.getIProductWeight());
					delivery.addItem(iProduct);
					delivery.setMaxLength();
					delivery.setMaxWidth();
					delivery.setTotalHeight();
					delivery.setTotalWeight();
					for (i = 0; i < 2; i++)
						if (((delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth()) ||(delivery.getMaxLength() <= delivery.parcels[i].getParcelWidth() 
						&& delivery.getMaxWidth() <= delivery.parcels[i].getParcelLength())) && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight() && delivery.getTotalWeight() <= delivery.parcels[i].getParcelWeight())
							gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
					
					for (i = 2; i < 6; i++)
						if (((delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth()) ||(delivery.getMaxLength() <= delivery.parcels[i].getParcelWidth() 
						&& delivery.getMaxWidth() <= delivery.parcels[i].getParcelLength())) && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight())
							gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
					gui.updateParcelsBox();
					if (gui.getParcelsBox().getItemCount() > 1)
						gui.updateCenterPanel(gui.PARCEL);
					else 
					{
						gui.setItemsArea(delivery);
						gui.updateCenterPanel(gui.REMOVE);
					}	
				}
			}
			else
				JOptionPane.showMessageDialog (gui, "Invalid input");
		}
		
		else if (e.getActionCommand().equals ("Remove"))
		{
			// Checks if item number is within the range given
			if (gui.getRemovedItem()>0 && gui.getRemovedItem() <= delivery.getItems().size())
			{
				delivery.removeItem(gui.getRemovedItem());
				// Recomputes the limits and checks the parcels if they are available
				gui.resetParcelsBox();
				delivery.setMaxLength();
				delivery.setMaxWidth();
				delivery.setTotalHeight();
				delivery.setTotalWeight();
				for (i = 0; i < 2; i++)
					if (delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth() && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight() && delivery.
					getTotalWeight() <= delivery.parcels[i].getParcelWeight())
						gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
				for (i = 2; i < 6; i++)
					if (delivery.getMaxLength() <= delivery.parcels[i].getParcelLength() && delivery.getMaxWidth() <= delivery.parcels[i].getParcelWidth() && delivery.getTotalHeight() <= delivery.parcels[i].getParcelHeight())
						gui.addAvailParcel(delivery.parcelToString(delivery.parcels[i]));
				gui.updateParcelsBox();
				if (gui.getParcelsBox().getItemCount() > 1)
					gui.updateCenterPanel(gui.PARCEL);
				else 
				{
					gui.resetFields();
					gui.setItemsArea(delivery);
					gui.updateCenterPanel(gui.REMOVE);
				}	
			}
			// Displays error message if input is invalid
			else 
				JOptionPane.showMessageDialog(gui,"Invalid Input");
		}
		
		else if (e.getActionCommand().equals ("Select"))
		{
			if (gui.getParcelsBox().getSelectedItem().equals("<Sizes>"))
				JOptionPane.showMessageDialog(gui,"Please select a parcel");
			else
			{
				finalParcel = chosenParcel;
				// If final parcel is a box parcel, computes the base rate of the items
				if (gui.getParcelsBox().getSelectedItem().equals("3. 12.0 x 10.0 x 5.0") || gui.getParcelsBox().getSelectedItem().equals("4. 14.0 x 11.0 x 7.0") || gui.getParcelsBox().getSelectedItem().equals("5. 18.0 x 12.0 x 9.0")
					||gui.getParcelsBox().getSelectedItem().equals("6. 20.0 x 16.0 x 12.0"))
					{
						delivery.setTotalBaseRate();
						finalParcel.setTotalBaseRate(delivery.getTotalBaseRate());
					}
				// If items are insured, then insurance fee is added
				if (delivery.getIfInsure())
					finalParcel.setInsuranceFee (delivery.getNumItems());
				// Delivery sets the final parcel chosen by the user
				delivery.setFinalParcel (finalParcel);
				// Delivery gets total weight of the parcel that is to be used if its destination is Visayas or Mindanao
				delivery.getFinalParcel().setSize(delivery.getTotalWeight());
				delivery.setDestination();
				// Computes the total fee of the delivery
				delivery.setTotalFee();
				deliveryNum++;
				time = System.nanoTime()/1000000000 - elapsedTime;
				// For check in, if time is atleast 1 minute, then a day is simulated
				if (time/60 >= 1)
				{
					elapsedTime = System.nanoTime()/1000000000;
					simDays++;
					deliveryNum = 1;
					for (i = 0; i <deliveries.size(); i++)
					// Updates statuses to simulated date	
						deliveries.get(i).getDestination().updateStatus();
				}
				// Sets the start date of the delivery
				delivery.setMonth(LocalDate.now().plusDays(simDays).getMonthValue());
				delivery.setDay(LocalDate.now().plusDays(simDays).getDayOfMonth());
				delivery.setYear(LocalDate.now().plusDays(simDays).getYear());
				delivery.setStartDate();
				
				delivery.setDeliveryNumber(deliveryNum);
				// Generates tracking ID
				delivery.setTrackingID();
				
				gui.updateReceiptPanel (delivery);
				deliveries.add(delivery);

				// Displays the receipt panel
				gui.updateCenterPanel(gui.RECEIPT);
			}
		}
	
		else if (e.getActionCommand().equals ("Return to item type selection"))
		{
			gui.updateCenterPanel(gui.ITEMTYPE);
		}
		
		else if (e.getActionCommand().equals ("Main Menu"))
		{
			gui.updateCenterPanel(gui.MENU);
			gui.resetFields();
			gui.resetParcelsBox();
		}
		
		
		else if (e.getActionCommand().equals ("Find"))
		{
			// Checks the deliveries for the inputted tracking ID
			for (i = 0; i < deliveries.size(); i++)
				// If tracking ID matches
				if (gui.getTrackingID().equalsIgnoreCase(deliveries.get(i).getTrackingID()))
				{
					// Sets update date of delivery
					deliveries.get(i).setUpdateDate(simDays);
					// Updates details panel
					gui.updateDetailsPanel(deliveries.get(i));
					found = true;
				}
			if (found)
			{
				// Switches to details panel
				gui.updateCenterPanel(gui.DETAILS);
				found=false;
			}
			else
			{
				// Displays message that indicates that the delivery was not found
				JOptionPane.showMessageDialog(gui,"Tracking ID not found");
				gui.updateCenterPanel(gui.TRACK);
			}
			gui.resetFields();
		}
		
		else if (e.getActionCommand().equals ("Back"))
		{
			gui.removeNotFoundLabel();
			gui.updateCenterPanel(gui.MENU);
			gui.resetFields();
		}
		
		else if (e.getActionCommand().equals ("Submit"))
		{
			// Checks if inputted string matches the password
			if (gui.getPassword().equalsIgnoreCase("jm_admin@7292019"))
				gui.updateCenterPanel(gui.ADMIN);
			// Displays an error message if wrong password is inputted
			else
				JOptionPane.showMessageDialog(gui,"Incorrect password");
		}	
		
		else if (e.getActionCommand().equals ("Generate Report"))
		{
			// Updates report panel with information regarding the deliveries
			gui.generateReport(deliveries);
			// Switches to report panel
			gui.updateCenterPanel(gui.REPORT);
		}
		
		else if (e.getActionCommand().equals ("Return to admin"))
		{
			gui.resetFields();
			gui.updateCenterPanel(gui.ADMIN);
		}
		
		else if (e.getActionCommand().equals ("Exit"))
			// Exits the program
			System.exit(0);
	}
	
	/** This method adds a function for the components with ItemListeners
	
		@param e the event being done
	*/
	public void itemStateChanged (ItemEvent e)
	{
		// If the event includes an item being selected
		if (e.getStateChange () == ItemEvent.SELECTED)
		{
			// If the source of the event is from the regions combo box
			if(e.getSource() == gui.getRegionsBox())
			{
				if (gui.getRegionsBox().getSelectedItem().equals("Metro Manila"))
					region = "Metro Manila";
				else if (gui.getRegionsBox().getSelectedItem().equals("Luzon"))
					region = "Luzon";
				else if (gui.getRegionsBox().getSelectedItem().equals("Visayas"))
					region = "Visayas";
				else if (gui.getRegionsBox().getSelectedItem().equals("Mindanao"))
					region = "Mindanao";		
			}
			// If the source of the event is from the parcels combo box
			else if (e.getSource() == gui.getParcelsBox())
			{
				if (gui.getParcelsBox().getSelectedItem().equals("1. 9.0 x 14.0 x 1.0"))
					chosenParcel = new Parcel (9, 14, 1, 3, 30, 1);
				else if (gui.getParcelsBox().getSelectedItem().equals("2. 12.0 x 18.0 x 3.0"))
					chosenParcel = new Parcel (12, 18, 3, 3, 50, 2);
				else if (gui.getParcelsBox().getSelectedItem().equals("3. 12.0 x 10.0 x 5.0"))
					chosenParcel = new Parcel (12, 10, 5, 3);
				else if (gui.getParcelsBox().getSelectedItem().equals("4. 14.0 x 11.0 x 7.0"))
					chosenParcel = new Parcel (14, 11, 7, 4);
				else if (gui.getParcelsBox().getSelectedItem().equals("5. 18.0 x 12.0 x 9.0"))
					chosenParcel = new Parcel (18, 12, 9, 5);
				else if (gui.getParcelsBox().getSelectedItem().equals("6. 20.0 x 16.0 x 12.0"))
					chosenParcel = new Parcel (20, 16, 12, 6);
			}
		}		
	}
	
	private JMGUI gui;
	private Delivery delivery;
	private ArrayList <Delivery> deliveries = new ArrayList <Delivery>();
	private Document document;
	private RegularProduct rProduct;
	private IrregularProduct iProduct;
	private Parcel chosenParcel;
	private Parcel finalParcel;
	private String region;
	private long time;
	private long elapsedTime;
	private int numItems;
	private int i;
	private int month = LocalDate.now().getMonthValue(), day = LocalDate.now().getDayOfMonth();
	private int deliveryNum;
	private int simDays;
	private boolean found;
	
}