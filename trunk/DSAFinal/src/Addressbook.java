import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;


public class Addressbook {
	private BinarySearchTree entries;
	public static final int SEARCH_NAME = 0;
	public static final int SEARCH_PHONE = 1;
	public static final int SEARCH_ADDRESS = 2;
	public static final int SEARCH_AGE = 3;
	
	public Addressbook(){
		if(SerializationHandler.deserialize() == null)
			entries = new BinarySearchTree();
		else
			entries = SerializationHandler.deserialize();
	}
	
	
	/**
	 * Searchs for something in the address book
	 * 
	 * @param searchterm What to search for
	 * @param SEARCH_FLAG flag for name, phone number, address
	 * @param exact if true, will only return objects that excatly match the searchterm
	 * @return An Object[] of AddressEntry[]
	 */
	public Object[] search(String searchterm, int SEARCH_FLAG, boolean exact){
		Object matches[] = null;
		switch(SEARCH_FLAG){
			case SEARCH_NAME:
				matches = entries.searchName(searchterm, exact);
				break;
			case SEARCH_PHONE:
				matches = entries.searchPhone(searchterm, exact);
				break;
			case SEARCH_ADDRESS:
				matches = entries.searchAddress(searchterm, exact);
				break;
			case SEARCH_AGE:
//				matches = null;
		}
		return matches;
	}
	
	public AddressEntry getEntry(){
		return null;
	}
	
	public Object[] getEntries()
	{
		ArrayList<AddressEntry> abc = entries.preorder(entries.root);
		return abc.toArray();
	}

		
	// adds new entry to address book or returns false if unable to
	public boolean addNewEntry(String name, String phone, String address){
		try{
			entries.insert(new AddressEntry(name, phone, address));
			return true;
		}
		catch (DuplicateItemException e)
		{
			System.out.println("Entry already exists");
			return false; // entry already exists in address book
		}
	}
	
	public boolean deleteEntry(AddressEntry entry)
	{
		entries.remove(entry);
		return false;
	}
	
	public AddressEntry searchAddressbook(String name)
	{
		return (AddressEntry)entries.find(new AddressEntry(name, null, null));
	}
	
	public void save() {
		SerializationHandler.serialize(entries);
	}
	
	public static void main(String args[])
	{
		
		Addressbook book = new Addressbook();
//		book.addNewEntry("Tom Renn", "732", "24 mirta");
//		book.addNewEntry("Frank Kempter", "732", "wewer");
//		book.addNewEntry("Tom Renn", "732", "24 mirta");
//		book.addNewEntry("Ed Springer", "73245", "233 cort");
//		
//		book.addNewEntry("Kurt Cal", "21173221", "werer");
//		book.addNewEntry("Zack Galifahacks", "2211", "23439");
//		book.addNewEntry("Tim cost", "22", "werebLAWERH");
		
		Object entries[] = book.search("we", Addressbook.SEARCH_ADDRESS, false);
		for (int i=0; i<entries.length; i++)
			System.out.print(" " + entries[i].toString() +"\n");
	}
	
}
