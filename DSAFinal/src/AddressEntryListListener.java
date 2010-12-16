import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class listens for selections made to the JList contained in the BookDisplay
 * When the selection is changed, the InfoPanel (has to be given to this listener) is updated
 * 
 * @author Tom Renn
 */
public class AddressEntryListListener implements ListSelectionListener {
	private InfoPanel ipanel;
	
	// constructor
	public AddressEntryListListener(InfoPanel ipanel){
		this.ipanel = ipanel;
	}
	
	// Action performed when something else is selected on the list, changes InfoPanel info
	@Override
	public void valueChanged(ListSelectionEvent event) {
		JList list = (JList)event.getSource();
		ipanel.setInfo((AddressEntry)list.getSelectedValue());
	}

}
