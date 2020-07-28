/** The class Document (part of the class Item) represents the information
	regarding an item as a document

	@author Hans Ramos, Robbie De Mesa
	@version 1.0
*/

import java.util.*;
public class Document extends Item
{

	/** This constructor receives the type, length, width, and number
		of pages of the document
		
		@param type The type of the item
		@param len The length of the document (format: double)
		@param wid The width of the document (format: double)
		@param pages The number of pages of the document (format: int)
	*/	
	public Document (String type, double len, double wid, int pages)
	{
		super (type, len, wid);
		if (pages > 0)
			this.numPages = pages;
		else 
		{
			System.out.println ("Invalid number of pages, setting number to 25 pages");
			this.numPages = 25;
		}
		setHeight (Math.ceil(numPages/25.0));
		setWeight (Math.ceil(numPages/125.0));
		setBaseRate(); 
	}
	
	/** This method returns the number of pages of the document
	
		@return number of pages of the document
	*/
	public int getNumPages ()
	{
		return numPages;
	}

	/** This method sets the base rate of the document
	*/	
	public void setBaseRate()
	{
		baseRate = weight * 40;
	}
	
	private int numPages;
}