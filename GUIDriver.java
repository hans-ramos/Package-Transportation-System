import javax.swing.*;

public class GUIDriver
{
	public static void main (String[] args)
	{
		JMGUI gui = new JMGUI();
		JMController controller = new JMController (gui);
		gui.setIconImage (new ImageIcon("JMLogo.png").getImage());
	}
}
