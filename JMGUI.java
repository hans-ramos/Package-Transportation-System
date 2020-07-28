import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class JMGUI extends JFrame
{
	/** This constructor initializes the frame and the components that is to be used in th GUI
	*/
	public JMGUI()
    {
        setTitle("Johnny Moves");
        setSize(500, 500);
        setResizable(false);
        setLayout(new BorderLayout());
		setForeground(Color.black);
		init();
		setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
	
	/** This method initializes the panels that is to be used in the GUI
	*/
	public void init()
	{
		mainBackground = new Color(255,222,89);
		secondBackground = new Color (0,133,255);
		// Center panel
		centerPanel = new JPanel (new CardLayout());
		
		// Main menu panel
		menuPanel = new JPanel (null);
		jMLabel = new JLabel ();
		menuPicLabel = new JLabel ();
		jMLabel.setIcon(new ImageIcon("JMLabel.png"));
		menuPicLabel.setIcon(new ImageIcon("menu_bot_pic.png"));
		checkInBtn = new JButton("Check-in");
		trackBtn = new JButton("Track");
		logInBtn = new JButton("Administrator");
		
		// Sets the position and the dimmensions ofr the components
		jMLabel.setBounds(100,10,300,100);
		checkInBtn.setBounds(100,150,300,50);
		trackBtn.setBounds(100,225,300,50);
		logInBtn.setBounds(100,300,300,50);
		menuPicLabel.setBounds(0,370,500,100);

		// Sets the background color of the components
		menuPanel.setBackground(mainBackground);
		jMLabel.setBackground(Color.white);
		checkInBtn.setBackground(secondBackground);
		trackBtn.setBackground(secondBackground);
		logInBtn.setBackground(secondBackground);
		
		// Sets the font color of the button components
		checkInBtn.setForeground(mainBackground);
		trackBtn.setForeground(mainBackground);
		logInBtn.setForeground(mainBackground);

		// Adds a border to the components and sets the color and thickness of the border
		checkInBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		trackBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		logInBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		// Adds the components into the panel
		menuPanel.add(jMLabel);
		menuPanel.add(checkInBtn);
		menuPanel.add(trackBtn);
		menuPanel.add(logInBtn);
		menuPanel.add(menuPicLabel);
		
		// Adds the panel into the center panel and assigns it with a name
		centerPanel.add(menuPanel,MENU);
		
		//Check-in Panel
		checkInPanel = new JPanel (null);
		recipientLabel = new JLabel ("Recipient:");
		regionLabel = new JLabel ("Destination:");
		numItemLabel = new JLabel ("Number of items:");
		insuredLabel = new JLabel ("Insured Parcel?");
		cmbDestination = new JComboBox<String>(regions);
		tfRecipient = new JTextField();
		tfNumItem = new JTextField();
		saveBtn = new JButton("Save");
		backBtn1 = new JButton("Back");
		rButtonYes = new JRadioButton("Yes");
		rButtonNo = new JRadioButton("No");
		insuredOptions = new ButtonGroup();
		
		recipientLabel.setBounds(10,10,300,50);
		tfRecipient.setBounds(110,20,200,30);
		regionLabel.setBounds(10,60,300,50);
		cmbDestination.setBounds(110,70,200,30);
		numItemLabel.setBounds(10,100,300,50);
		tfNumItem.setBounds(110,110,200,30);
		insuredLabel.setBounds(10,150,300,50);
		rButtonYes.setBounds(120,150,300,50);
		rButtonNo.setBounds(120,185,300,50);
		saveBtn.setBounds(180,250,100,50);
		backBtn1.setBounds(180,310,100,50);
		
		checkInPanel.setBackground(mainBackground);
		regionLabel.setBackground(Color.white);
		tfRecipient.setBackground(Color.white);
		cmbDestination.setBackground(Color.white);
		numItemLabel.setBackground(Color.white);
		tfNumItem.setBackground(Color.white);
		saveBtn.setBackground(secondBackground);
		backBtn1.setBackground(secondBackground);
		rButtonYes.setBackground(mainBackground);
		rButtonNo.setBackground(mainBackground);
		
		saveBtn.setForeground(mainBackground);
		backBtn1.setForeground(mainBackground);
		
		tfRecipient.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfNumItem.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		saveBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		backBtn1.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		// Puts the yes radio button and the no radio button into the same group
		insuredOptions.add(rButtonYes);
		insuredOptions.add(rButtonNo);
		
		checkInPanel.add(recipientLabel);
		checkInPanel.add(tfRecipient);
		checkInPanel.add(regionLabel);
		checkInPanel.add(cmbDestination);
		checkInPanel.add(numItemLabel);
		checkInPanel.add(tfNumItem);
		checkInPanel.add(insuredLabel);
		checkInPanel.add(rButtonYes);
		checkInPanel.add(rButtonNo);
		checkInPanel.add(saveBtn);
		checkInPanel.add(backBtn1);
	
		centerPanel.add(checkInPanel, CHECKIN);
		
		//Item type Selection Panel
		itemTypePanel = new JPanel (null);
		itemTypeLabel = new JLabel ("Item Type");
		documentBtn = new JButton ("Document");
		regularProductBtn = new JButton ("Regular Product");
		irregularProductBtn = new JButton ("Irregular Product");
		cancelBtn1 = new JButton ("Cancel");
		
		itemTypeLabel.setBounds (200,60,300,50);
		documentBtn.setBounds (150,130,150,50);
		regularProductBtn.setBounds (150,190,150,50);
		irregularProductBtn.setBounds (150,250,150,50);
		cancelBtn1.setBounds (150,310,150,50);
		
		itemTypePanel.setBackground(mainBackground);
		documentBtn.setBackground(secondBackground);
		regularProductBtn.setBackground(secondBackground);
		irregularProductBtn.setBackground(secondBackground);
		cancelBtn1.setBackground(secondBackground);
		
		documentBtn.setForeground(mainBackground);
		regularProductBtn.setForeground(mainBackground);
		irregularProductBtn.setForeground(mainBackground);
		cancelBtn1.setForeground(mainBackground);
		
		documentBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		regularProductBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		irregularProductBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		cancelBtn1.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		itemTypePanel.add(itemTypeLabel);
		itemTypePanel.add(documentBtn);
		itemTypePanel.add(regularProductBtn);
		itemTypePanel.add(irregularProductBtn);
		itemTypePanel.add(cancelBtn1);
		
		centerPanel.add(itemTypePanel, ITEMTYPE);
		
		//Document Panel
		documentPanel = new JPanel (null);
		documentLengthLabel = new JLabel ("Length:");
		tfDocumentLength = new JTextField ();
		documentWidthLabel = new JLabel ("Width:");
		tfDocumentWidth = new JTextField ();
		documentNumPagesLabel = new JLabel ("Number of Pages:");
		tfDocumentNumPages = new JTextField ();
		addDocumentBtn = new JButton ("Add Document");
		return1Btn = new JButton ("Return to item type selection");
		
		documentLengthLabel.setBounds (10,60,300,50);
		tfDocumentLength.setBounds(120,70,200,30);
		documentWidthLabel.setBounds (10,120,300,50);
		tfDocumentWidth.setBounds(120,130,200,30);
		documentNumPagesLabel.setBounds (10,180,300,50);
		tfDocumentNumPages.setBounds(120,190,200,30);
		addDocumentBtn.setBounds (200,250,100,50);
		return1Btn.setBounds (150,320,200,50);
		
		documentPanel.setBackground(mainBackground);
		tfDocumentLength.setBackground(Color.white);
		tfDocumentWidth.setBackground(Color.white);
		tfDocumentNumPages.setBackground(Color.white);
		addDocumentBtn.setBackground(secondBackground);
		return1Btn.setBackground(secondBackground);
	
		addDocumentBtn.setForeground(mainBackground);
		return1Btn.setForeground(mainBackground);
		
		tfDocumentLength.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfDocumentWidth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfDocumentNumPages.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		addDocumentBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		return1Btn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		documentPanel.add(documentLengthLabel);
		documentPanel.add(documentWidthLabel);
		documentPanel.add(documentNumPagesLabel);
		documentPanel.add(tfDocumentLength);
		documentPanel.add(tfDocumentWidth);
		documentPanel.add(tfDocumentNumPages);
		documentPanel.add(addDocumentBtn);
		documentPanel.add(return1Btn);
		
		centerPanel.add(documentPanel, DOCUMENT); 
		
		//Regular Prodcut Panel
		rProductPanel = new JPanel (null);
		rProductLengthLabel = new JLabel ("Length:");
		tfRProductLength = new JTextField ();
		rProductWidthLabel = new JLabel ("Width:");
		tfRProductWidth = new JTextField ();
		rProductHeightLabel = new JLabel ("Height:");
		tfRProductHeight = new JTextField ();
		rProductWeightLabel = new JLabel ("Weight:");
		tfRProductWeight = new JTextField ();
		addRProductBtn = new JButton ("Add Regular Product");
		return2Btn = new JButton ("Return to item type selection");
		
		rProductLengthLabel.setBounds (10,60,300,50);
		tfRProductLength.setBounds(120,70,200,30);
		rProductWidthLabel.setBounds (10,120,300,50);
		tfRProductWidth.setBounds(120,130,200,30);
		rProductHeightLabel.setBounds (10,180,300,50);
		tfRProductHeight.setBounds(120,190,200,30);
		rProductWeightLabel.setBounds (10,240,300,50);
		tfRProductWeight.setBounds(120,250,200,30);
		addRProductBtn.setBounds (150,290,200,50);
		return2Btn.setBounds (150,350,200,50);
		
		rProductPanel.setBackground(mainBackground);
		tfRProductLength.setBackground(Color.white);
		tfRProductWidth.setBackground(Color.white);
		tfRProductHeight.setBackground(Color.white);
		tfRProductWeight.setBackground(Color.white);
		addRProductBtn.setBackground(secondBackground);
		return2Btn.setBackground(secondBackground);
		
		addRProductBtn.setForeground(mainBackground);
		return2Btn.setForeground(mainBackground);
		
		tfRProductLength.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfRProductWidth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfRProductHeight.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfRProductWeight.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		addRProductBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		return2Btn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		rProductPanel.add(rProductLengthLabel);
		rProductPanel.add(rProductWidthLabel);
		rProductPanel.add(rProductHeightLabel);
		rProductPanel.add(rProductWeightLabel);
		rProductPanel.add(tfRProductLength);
		rProductPanel.add(tfRProductWidth);
		rProductPanel.add(tfRProductHeight);
		rProductPanel.add(tfRProductWeight);
		rProductPanel.add(addRProductBtn);
		rProductPanel.add(return2Btn);
		
		centerPanel.add(rProductPanel, REGULARPRODUCT); 
		
		//Irregular Prodcut Panel
		iProductPanel = new JPanel (null);
		iProductNoteLabel = new JLabel ("Please input the largest measurement for each dimmension");
		iProductLengthLabel = new JLabel ("Length:");
		tfIProductLength = new JTextField ();
		iProductWidthLabel = new JLabel ("Width:");
		tfIProductWidth = new JTextField ();
		iProductHeightLabel = new JLabel ("Height:");
		tfIProductHeight = new JTextField ();
		iProductWeightLabel = new JLabel ("Weight:");
		tfIProductWeight = new JTextField ();
		addIProductBtn = new JButton ("Add Irregular Product");
		return3Btn = new JButton ("Return to item type selection");
		
		iProductLengthLabel.setBounds (10,60,300,50);
		iProductNoteLabel.setBounds(10,20,450,30);
		tfIProductLength.setBounds(120,70,200,30);
		iProductWidthLabel.setBounds (10,120,300,50);
		tfIProductWidth.setBounds(120,130,200,30);
		iProductHeightLabel.setBounds (10,180,300,50);
		tfIProductHeight.setBounds(120,190,200,30);
		iProductWeightLabel.setBounds (10,240,300,50);
		tfIProductWeight.setBounds(120,250,200,30);
		addIProductBtn.setBounds (150,290,200,50);
		return3Btn.setBounds (150,350,200,50);
		
		iProductPanel.setBackground(mainBackground);
		tfIProductLength.setBackground(Color.white);
		tfIProductWidth.setBackground(Color.white);
		tfIProductHeight.setBackground(Color.white);
		tfIProductWeight.setBackground(Color.white);
		addIProductBtn.setBackground(secondBackground);
		return3Btn.setBackground(secondBackground);
		
		addIProductBtn.setForeground(mainBackground);
		return3Btn.setForeground(mainBackground);
		
		tfIProductLength.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfIProductWidth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfIProductHeight.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		tfIProductWeight.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		addIProductBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		return3Btn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		iProductPanel.add(iProductNoteLabel);
		iProductPanel.add(iProductLengthLabel);
		iProductPanel.add(iProductWidthLabel);
		iProductPanel.add(iProductHeightLabel);
		iProductPanel.add(iProductWeightLabel);
		iProductPanel.add(tfIProductLength);
		iProductPanel.add(tfIProductWidth);
		iProductPanel.add(tfIProductHeight);
		iProductPanel.add(tfIProductWeight);
		iProductPanel.add(addIProductBtn);
		iProductPanel.add(return3Btn);
		
		centerPanel.add(iProductPanel, IRREGULARPRODUCT); 
		
		//Parcel Panel=
		parcelPanel = new JPanel (null);
		parcelLabel = new JLabel ("Desired size of parcel");
		cmbParcels = new JComboBox<String> ();
		selectBtn = new JButton ("Select");
		
		parcelLabel.setBounds(10,60,300,50);
		cmbParcels.setBounds(20,120,300,30);
		selectBtn.setBounds(200,200,100,50);
		
		parcelPanel.setBackground(mainBackground);
		cmbParcels.setBackground(Color.white);
		selectBtn.setBackground(secondBackground);
		
		selectBtn.setForeground(mainBackground);
		
		cmbParcels.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		selectBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		parcelPanel.add(parcelLabel);
		parcelPanel.add(cmbParcels);
		parcelPanel.add(selectBtn);

		centerPanel.add(parcelPanel, PARCEL);
		
		//Remove Panel
		removePanel = new JPanel (null);
		itemsTextArea = new JTextArea ();
		tfRemove = new JTextField ();
		removeBtn = new JButton ("Remove");
		cancelBtn2 = new JButton ("Cancel");
	
		itemsTextArea.setBounds(150,60, 200, 200);
		tfRemove.setBounds (150,280, 200, 50);
		removeBtn.setBounds (150,350,200, 50);
		cancelBtn2.setBounds (150, 410, 200, 50);
	
		// Sets this text area to an uneditable through input state
		itemsTextArea.setEditable(false);
		
		removePanel.setBackground(mainBackground);
		itemsTextArea.setBackground(Color.white);
		removeBtn.setBackground(secondBackground);
		cancelBtn2.setBackground(secondBackground);
		
		removeBtn.setForeground(mainBackground);
		cancelBtn2.setForeground(mainBackground);
		
		itemsTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		removeBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		cancelBtn2.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		removePanel.add(itemsTextArea);
		removePanel.add(tfRemove);
		removePanel.add(removeBtn);
		removePanel.add(cancelBtn2);
		
		centerPanel.add(removePanel, REMOVE);
		
		//Receipt Panel
		receiptPanel = new JPanel (null);
		baseFeeLabel = new JLabel ();
		serviceFeeLabel = new JLabel ();
		insuranceFeeLabel = new JLabel ();
		totalFeeLabel = new JLabel ();
		trackingNumLabel = new JLabel ();
		mainMenuBtn1 = new JButton ("Main Menu");
		
		baseFeeLabel.setBounds(10,60,300,50);
		serviceFeeLabel.setBounds(10,120,300,50);
		insuranceFeeLabel.setBounds(10,180,300,50);
		totalFeeLabel.setBounds(10,240,300,50);
		trackingNumLabel.setBounds(10,300,300,50);
		mainMenuBtn1.setBounds(180,360,100,50);
		
		receiptPanel.setBackground(mainBackground);
		mainMenuBtn1.setBackground(secondBackground);
		
		mainMenuBtn1.setForeground(mainBackground);
		
		mainMenuBtn1.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		receiptPanel.add(baseFeeLabel);
		receiptPanel.add(serviceFeeLabel);
		receiptPanel.add(insuranceFeeLabel);
		receiptPanel.add(totalFeeLabel);
		receiptPanel.add(trackingNumLabel);
		receiptPanel.add(mainMenuBtn1);
		
		centerPanel.add(receiptPanel, RECEIPT);
		
		//Track Panel
		trackPanel = new JPanel (null);
		trackLabel = new JLabel ("Please input tracking number:");
		notFoundLabel = new JLabel ("Tracking number not found.");
		tfTrackNo = new JTextField ();
		findBtn = new JButton ("Find");
		backBtn3 =  new JButton ("Back");
		
		trackLabel.setBounds (10,125,480,50);
		tfTrackNo.setBounds (185,125,200,50);
		notFoundLabel.setBounds (10,185,480,50);
		findBtn.setBounds (180,250,100,50);
		backBtn3.setBounds (180,310,100,50);
		
		trackPanel.setBackground(mainBackground);
		tfTrackNo.setBackground(Color.white);
		findBtn.setBackground(secondBackground);
		backBtn3.setBackground(secondBackground);
		
		findBtn.setForeground(mainBackground);
		backBtn3.setForeground(mainBackground);
		
		tfTrackNo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		findBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		backBtn3.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		trackPanel.add(trackLabel);
		trackPanel.add(tfTrackNo);
		trackPanel.add(findBtn);
		trackPanel.add(backBtn3);
		
		centerPanel.add(trackPanel, TRACK);
		
		//Details Panel
		detailsPanel = new JPanel (null);
		startDateLabel = new JLabel ();
		trackingNoLabel = new JLabel ();
		statusLabel = new JLabel ();
		updateLabel = new JLabel ();
		mainMenuBtn2 = new JButton ("Main Menu");
		
		startDateLabel.setBounds (10,60,300,50);
		trackingNoLabel.setBounds (10,120,300,50);
		statusLabel.setBounds (10,180,300,50);
		updateLabel.setBounds (10,240,300,50);
		mainMenuBtn2.setBounds (180,350,100,50);
		
		detailsPanel.setBackground(mainBackground);
		mainMenuBtn2.setBackground(secondBackground);
		
		mainMenuBtn2.setForeground(mainBackground);
		
		mainMenuBtn2.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		detailsPanel.add(startDateLabel);
		detailsPanel.add(trackingNoLabel);
		detailsPanel.add(statusLabel);
		detailsPanel.add(updateLabel);
		detailsPanel.add(mainMenuBtn2);
		
		centerPanel.add(detailsPanel,DETAILS);
		
		//Log in panel
		logInPanel = new JPanel (null);
		logInLabel = new JLabel ("Please input administrator password:");
		// JPasswordField allows the textfield to show encrypted characters
		tfPassword = new JPasswordField(); 
		submitBtn = new JButton("Submit");
		backBtn2 = new JButton("Back");
		
		logInLabel.setBounds(150,60,300,50);
		tfPassword.setBounds(160,125,200,50);
		submitBtn.setBounds(200,200,100,50);
		backBtn2.setBounds(200,280,100,50);
		
		logInPanel.setBackground(mainBackground);
		logInLabel.setBackground(Color.white);
		tfPassword.setBackground(Color.white);
		submitBtn.setBackground(secondBackground);
		backBtn2.setBackground(secondBackground);
		
		submitBtn.setForeground(mainBackground);
		backBtn2.setForeground(mainBackground);
		
		tfPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		submitBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		backBtn2.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		logInPanel.add(logInLabel);
		logInPanel.add(tfPassword);
		logInPanel.add(submitBtn);
		logInPanel.add(backBtn2);
		
		centerPanel.add(logInPanel,LOGIN);
		
		//Admin Panel
		adminPanel = new JPanel (null);
		genReportBtn = new JButton ("Generate Report");
		mainMenuBtn3 = new JButton ("Main Menu");
		exitBtn = new JButton ("Exit");
		
		genReportBtn.setBounds (175,100,150,50);
		mainMenuBtn3.setBounds (175,160,150,50);
		exitBtn.setBounds (175,220,150,50);
		
		adminPanel.setBackground(mainBackground);
		genReportBtn.setBackground(secondBackground);
		mainMenuBtn3.setBackground(secondBackground);
		exitBtn.setBackground(secondBackground);
		
		genReportBtn.setForeground(mainBackground);
		mainMenuBtn3.setForeground(mainBackground);
		exitBtn.setForeground(mainBackground);
		
		genReportBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		exitBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		mainMenuBtn3.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		adminPanel.add(genReportBtn);
		adminPanel.add(mainMenuBtn3);
		adminPanel.add(exitBtn);
		
		centerPanel.add(adminPanel, ADMIN);
		
		//Report Panel
		reportPanel = new JPanel (null);
		reportTextArea = new JTextArea();
		returnAdminBtn = new JButton ("Return to admin");
		
		reportTextArea.setBounds(150,60, 200, 200);
		returnAdminBtn.setBounds(150,300,200,50);
		
		reportTextArea.setEditable(false);
		
		reportPanel.setBackground(mainBackground);
		returnAdminBtn.setBackground(secondBackground);
		
		returnAdminBtn.setForeground(mainBackground);
		
		reportTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		returnAdminBtn.setBorder(BorderFactory.createLineBorder(secondBackground, 4));
		
		reportPanel.add(reportTextArea);
		reportPanel.add(returnAdminBtn);
		
		centerPanel.add(reportPanel, REPORT);
		
		add(centerPanel,BorderLayout.CENTER);
	}
	
	/** This method adds an event listener to a component
	
		@param listener the contoller that adds functions to the components
	*/	
	public void addListeners (EventListener listener)
	{
		// Adds ActionListener to the following buttons
		checkInBtn.addActionListener ((ActionListener) listener);
		trackBtn.addActionListener ((ActionListener) listener);
		logInBtn.addActionListener ((ActionListener) listener);
		saveBtn.addActionListener ((ActionListener) listener);
		cancelBtn1.addActionListener ((ActionListener) listener);
		cancelBtn2.addActionListener ((ActionListener) listener);
		documentBtn.addActionListener((ActionListener) listener);
		regularProductBtn.addActionListener((ActionListener) listener);
		irregularProductBtn.addActionListener((ActionListener) listener);
		submitBtn.addActionListener ((ActionListener) listener);
		addDocumentBtn.addActionListener((ActionListener) listener);
		addRProductBtn.addActionListener((ActionListener) listener);
		addIProductBtn.addActionListener((ActionListener) listener);
		selectBtn.addActionListener((ActionListener) listener);
		removeBtn.addActionListener ((ActionListener) listener);
		return1Btn.addActionListener ((ActionListener) listener);
		return2Btn.addActionListener ((ActionListener) listener);	
		return3Btn.addActionListener ((ActionListener) listener);
		findBtn.addActionListener ((ActionListener) listener);
		backBtn1.addActionListener ((ActionListener) listener);
		backBtn2.addActionListener ((ActionListener) listener);	
		backBtn3.addActionListener ((ActionListener) listener);	
		mainMenuBtn1.addActionListener ((ActionListener) listener);
		mainMenuBtn2.addActionListener ((ActionListener) listener);
		mainMenuBtn3.addActionListener ((ActionListener) listener);
		genReportBtn.addActionListener ((ActionListener) listener);
		exitBtn.addActionListener ((ActionListener) listener);
		returnAdminBtn.addActionListener ((ActionListener) listener);
		// Adds ItemListener to the following components
		cmbDestination.addItemListener ((ItemListener) listener);
		cmbParcels.addItemListener ((ItemListener) listener);	
		rButtonYes.addItemListener ((ItemListener) listener);
		rButtonNo.addItemListener ((ItemListener) listener);
	}
	
	/** This method updates the center panel to the chosen panel
	
		@param name the name of the panel that is to be displayed
	*/
	public void updateCenterPanel (String name)
	{
		CardLayout cards = (CardLayout) centerPanel.getLayout();
		// Displays the component that was added to the center panel with the specified name,
		cards.show(centerPanel, name);
	}
	
	/** This method updates the parcels combo box with the available
		parcels
	*/
	public void updateParcelsBox ()
	{
		cmbParcels.addItem("<Sizes>");
		int i;
		for (i = 0; i < parcels.size(); i++)
			cmbParcels.addItem(parcels.get(i));
	}
	
	/** This method updates the receipt panel with details from the delivery
	
		@param delivery the details of the delivery will be used for updating the receipt panel
	*/
	public void updateReceiptPanel(Delivery delivery)
	{
		baseFeeLabel.setText("Base Fee: " + delivery.getFinalParcel().getTotalBaseRate());
		serviceFeeLabel.setText("Service Fee: " + delivery.getDestination().getServiceFee());
		insuranceFeeLabel.setText("Insurance Fee: " + delivery.getFinalParcel().getInsuranceFee());
		totalFeeLabel.setText("Total Fee: " + delivery.getTotalFee());
		trackingNumLabel.setText("Tracking Number: " + delivery.getTrackingID());
	}
	
	/** This method updates the details panel with details from the delivery	
	
		@param delivery the details of the delivery will be used for updating the details panel
	*/
	public void updateDetailsPanel(Delivery delivery)
	{
		startDateLabel.setText("Start Date: " + delivery.getStartDate());
		trackingNoLabel.setText("Tracking Number: " + delivery.getTrackingID());
		statusLabel.setText("Status: " + delivery.getDestination().getStatus());
		updateLabel.setText("Update Date: " + delivery.getUpdateDate());
	}
	
	/** This method sets the text area for the items in the delivery
		
		@param delivery the items of the delivery will be displayed
	*/	
	public void setItemsArea(Delivery delivery)
	{
		int i;
		for (i=0; i < delivery.getItems().size(); i++)
			itemsTextArea.append((i+1) + ". " + delivery.getItems().get(i).itemToString() + "\n");
	}
	
	/** This method sets the text area for the report
	
		@param deliveries the list of deliveries(Delivered/undelivered)
	*/	
	public void generateReport(ArrayList <Delivery> deliveries)
	{
		int i;
		reportTextArea.append("Parcels to be delivered today:\n"); 
		for (i = 0; i < deliveries.size(); i++)
			if (deliveries.get(i).getDestination().getDelivDay()==deliveries.get(i).getDestination().getDuration())
				reportTextArea.append(deliveries.get(i).getTrackingID() + "\n");
		reportTextArea.append("Undelivered Parcels:\n");	
		for (i = 0; i < deliveries.size(); i++)
			if (!deliveries.get(i).getDestination().getStatus().equals("Delivered"))
				reportTextArea.append(deliveries.get(i).getTrackingID() + "  " + deliveries.get(i).getDestination().getStatus() + "\n");
	}
	
	/** This method adds a label indicating that the tracking number was not found
	*/
	public void addNotFoundLabel()
	{
		trackPanel.add(notFoundLabel);
		// Validates the layout calling add method
		trackPanel.revalidate();
		// Adds the not found label after validation of the layout
		trackPanel.repaint();
	}
	
	/** This method removes the label that indicates if the tracking number was not found 
	*/
	public void removeNotFoundLabel()
	{
		trackPanel.remove(notFoundLabel);
		trackPanel.revalidate();
	}
	
	/** This method adds the string form of a parcel to the list of available parcels
	
		@param p String form of the parcel to be added to the list of available parcels
	*/	
	public void addAvailParcel(String p)
	{
		parcels.add(p);
	}
		
	/** This method removes the contents of the parcels combo box
	*/
	public void resetParcelsBox()
	{
		parcelPanel.remove(cmbParcels);
		// Clears the contents of the parcel arraylist
		parcels.clear();
		// Clears the contents of the parcels combo box
		cmbParcels.removeAllItems();
		parcelPanel.add(cmbParcels);
	}
	
	/** This method resets all fields,combo boxes and radio buttons to its default setting
	*/
	public void resetFields ()
	{
		cmbDestination.setSelectedIndex(0);
		tfRecipient.setText("");
		tfNumItem.setText("");
		tfTrackNo.setText("");
		tfPassword.setText("");
		tfDocumentLength.setText("");
		tfDocumentWidth.setText("");
		tfDocumentNumPages.setText("");
		tfRProductLength.setText("");
		tfRProductWidth.setText("");
		tfRProductHeight.setText("");
		tfRProductWeight.setText("");
		tfIProductLength.setText("");
		tfIProductWidth.setText("");
		tfIProductHeight.setText("");
		tfIProductWeight.setText("");
		itemsTextArea.setText("");
		reportTextArea.setText("");
		tfRemove.setText("");
		insuredOptions.clearSelection();
	}

	/** This method returns the string currently stored at the recipient text field
	
		@return the string stored at the recipient text field
	*/
	public String getRecipient()
	{
		return tfRecipient.getText();
	}
	
	/** This method returns the string stored at the num item text field and converts
		it into an integer
		
		@return the integer form of the string stored at the num item text field
	*/	
	public int getNumItem()
	{
		int num = 0;
		try
		{
			//Checks if the string is a number
			num = Integer.parseInt (tfNumItem.getText());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the radio button for yes
	
		@return the radio button for yes
	*/
	public JRadioButton getYes()
	{
		return rButtonYes;
	}
	
	/** This method returns the radio button for no
	
		@return the radio button for no
	*/
	public JRadioButton getNo()
	{
		return rButtonNo;
	}

	/** This method returns the combo box for the regions/destinations
	
		@return the combo box for the regions/destinations
	*/	
	public JComboBox<String> getRegionsBox()
	{
		return cmbDestination;
	}
	
	/** This method returns the combo box for the available parcels
	
		@return the combo box for the available parcels
	*/
	public JComboBox<String> getParcelsBox()
	{
		return cmbParcels;
	}
	
	/** This method returns the string currently stored at the password text field
	
		@return the string currently stored at the password text field
	*/	
	public String getPassword()
	{
		return tfPassword.getText();
	}
	
	/** This method returns the string currently stored at the tracking ID text field
	
		@return the string currently stored at the tracking ID text field
	*/
	public String getTrackingID()
	{
		return tfTrackNo.getText();
	}
		
	/** This method returns the string currently stored at the document length text field
		and converts it into a double
		
		@return the double form of the string stored at the document length text field
	*/
	public double getDocLength()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfDocumentLength.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the document width text field
		and converts it into a double
		
		@return the double form of the string stored at the document width text field
	*/
	public double getDocWidth()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfDocumentWidth.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the document number of pages text field
		and converts it into an integer
		
		@return the integer form of the string stored at the document number of pages text field
	*/
	public int getDocPages()
	{
		int num = 0;
		try
		{
			//Checks if the string is a number
			num = Integer.parseInt (tfDocumentNumPages.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the regular product length text field
		and converts it into a double
		
		@return the double form of the string stored at the regular product length text field
	*/
	public double getRProductLength()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfRProductLength.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the regular product width text field
		and converts it into a double
		
		@return the double form of the string stored at the regular product width text field
	*/
	public double getRProductWidth()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfRProductWidth.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the regular product height text field
		and converts it into a double
		
		@return the double form of the string stored at the regular product height text field
	*/
	public double getRProductHeight()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfRProductHeight.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the regular product weight text field
		and converts it into a double
		
		@return the double form of the string stored at the regular product weight text field
	*/
	public double getRProductWeight()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfRProductWeight.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the irregular product length text field
		and converts it into a double
		
		@return the double form of the string stored at the irregular product length text field
	*/
	public double getIProductLength()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfIProductLength.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}

	/** This method returns the string currently stored at the irregular product width text field
		and converts it into a double
		
		@return the double form of the string stored at the irregular product width text field
	*/	
	public double getIProductWidth()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfIProductWidth.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the irregular product height text field
		and converts it into a double
		
		@return the double form of the string stored at the irregular product height text field
	*/
	public double getIProductHeight()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfIProductHeight.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the irregular product weight text field
		and converts it into a double
		
		@return the double form of the string stored at the irregular product weight text field
	*/
	public double getIProductWeight()
	{
		double num = 0;
		try
		{
			//Checks if the string is a number
			num = Double.parseDouble (tfIProductWeight.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	/** This method returns the string currently stored at the remove item text field
		and converts it into an integer
		
		@return the integer form of the string stored at the remove item text field
	*/
	public int getRemovedItem()
	{
		int num = 0;
		try
		{
			//Checks if the string is a number
			num = Integer.parseInt (tfRemove.getText ());
		}
		catch (NumberFormatException e)
		{
			//Displays an error message window if the string is not a number
			JOptionPane.showMessageDialog (this, "Invalid Input " + e.getMessage());
		}
		return num;
	}
	
	public final String MENU = "Main Menu";
	public final String CHECKIN = "Check-in";
	public final String ITEMTYPE = "Save";
	public final String DOCUMENT = "Document";
	public final String REGULARPRODUCT = "Regular Product";
	public final String IRREGULARPRODUCT = "Irregular Product";
	public final String RECEIPT = "Select";
	public final String REMOVE = "Remove";
	public final String PARCEL = "Parcel";
	public final String TRACK = "Track";
	public final String DETAILS = "Find";	
	public final String LOGIN = "Administrator";
	public final String ADMIN = "Submit";
	public final String REPORT = "Report";
	
	private JPanel centerPanel;
	private JPanel menuPanel;
	private JPanel trackPanel;
	private JPanel checkInPanel;
	private JPanel itemTypePanel;
	private JPanel documentPanel;
	private JPanel rProductPanel;
	private JPanel iProductPanel;
	private JPanel receiptPanel;
	private JPanel removePanel;
	private JPanel detailsPanel;
	private JPanel parcelPanel;	
	private JPanel logInPanel;
	private JPanel adminPanel;
	private JPanel reportPanel;
	
	private JLabel jMLabel;
	private JLabel menuPicLabel;
	private JLabel recipientLabel;	
	private JLabel regionLabel;
	private JLabel numItemLabel;
	private JLabel insuredLabel;
	private JLabel itemTypeLabel;
	private JLabel documentLengthLabel;
	private JLabel documentWidthLabel;
	private JLabel documentNumPagesLabel;
	private JLabel rProductLengthLabel;
	private JLabel rProductWidthLabel;
	private JLabel rProductHeightLabel;
	private JLabel rProductWeightLabel;
	private JLabel iProductNoteLabel;
	private JLabel iProductLengthLabel;
	private JLabel iProductWidthLabel;
	private JLabel iProductHeightLabel;
	private JLabel iProductWeightLabel;
	private JLabel parcelLabel;
	private JLabel baseFeeLabel;
	private JLabel serviceFeeLabel;
	private JLabel insuranceFeeLabel;
	private JLabel totalFeeLabel;
	private JLabel trackingNumLabel;
	private JLabel trackLabel;
	private JLabel startDateLabel;
	private JLabel trackingNoLabel;
	private JLabel statusLabel;
	private JLabel updateLabel;
	private JLabel notFoundLabel;
	private JLabel logInLabel;
	
	private JButton checkInBtn;
	private JButton trackBtn;
	private JButton saveBtn;
	private JButton submitBtn;
	private JButton documentBtn;
	private JButton regularProductBtn;
	private JButton irregularProductBtn;
	private JButton addDocumentBtn;
	private JButton addRProductBtn;
	private JButton addIProductBtn;
	private JButton selectBtn;
	private JButton removeBtn;
	private JButton return1Btn;
	private JButton return2Btn;
	private JButton return3Btn;
	private JButton cancelBtn1;
	private JButton cancelBtn2;
	private JButton mainMenuBtn1;
	private JButton mainMenuBtn2;
	private JButton mainMenuBtn3;
	private JButton backBtn1;
	private JButton backBtn2;
	private JButton backBtn3;
	private JButton findBtn;
	private JButton logInBtn;
	private JButton genReportBtn;
	private JButton exitBtn;
	private JButton returnAdminBtn;
		
	private JTextField tfRecipient;	
	private JTextField tfNumItem;
	private JTextField tfDocumentLength;
	private JTextField tfDocumentWidth;
	private JTextField tfDocumentNumPages;
	private JTextField tfRProductLength;
	private JTextField tfRProductWidth;
	private JTextField tfRProductHeight;
	private JTextField tfRProductWeight;
	private JTextField tfIProductLength;
	private JTextField tfIProductWidth;
	private JTextField tfIProductHeight;
	private JTextField tfIProductWeight;
	private JTextField tfRemove;
	private JTextField tfTrackNo;
	private JTextField tfPassword;

	private JRadioButton rButtonYes;
	private JRadioButton rButtonNo;
	
	private ButtonGroup insuredOptions;
	
	private String regions [] = {"<Regions>","Metro Manila", "Luzon", "Visayas", "Mindanao"};
	private ArrayList <String> parcels = new ArrayList <String>();
	
	private JComboBox<String> cmbDestination;
	private JComboBox<String> cmbParcels;
	
	private JTextArea itemsTextArea;
	private JTextArea reportTextArea;
	
	private Color mainBackground;
	private Color secondBackground;
}