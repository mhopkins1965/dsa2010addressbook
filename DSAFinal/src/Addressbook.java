import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

/**
 * Holds all the AddressEntry's for contacts
 *
 */
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
	
	// a basic method to get all entries 
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
			return false; // entry already exists in address book
		}
	}
	
	// delete an Entry but giving the entry wanted to delete
	public void deleteEntry(AddressEntry entry)
	{
		entries.remove(entry);
	}
	
	// save the BinarySearchTree of entries
	public void save() {
		SerializationHandler.serialize(entries);
	}
	
}
