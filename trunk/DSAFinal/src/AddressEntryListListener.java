import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AddressEntryListListener implements ListSelectionListener {
	private InfoPanel ipanel;
	
	public AddressEntryListListener(InfoPanel ipanel){
		this.ipanel = ipanel;
	}
	@Override
	public void valueChanged(ListSelectionEvent event) {
		JList list = (JList)event.getSource();
		ipanel.setInfo((AddressEntry)list.getSelectedValue());
	}

}
