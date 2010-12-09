import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;


public class Addressbook {
	private BinarySearchTree entries;
	
	public Addressbook(){
		entries = new BinarySearchTree();
	}
	
	public AddressEntry getEntry(){
		return null;
	}
	
	public Object[] getEntries()
	{
		ArrayList<AddressEntry> abc = entries.inorder(entries.root);
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
	
	public boolean deleteEntry(String name)
	{
		return false;
	}
	
	public AddressEntry searchAddressbook(String name)
	{
		return (AddressEntry)entries.find(new AddressEntry(name, null, null));
	}
	
	public static void main(String args[])
	{
		
		Addressbook book = new Addressbook();
		book.addNewEntry("Tom Renn", "732", "24 mirta");
		book.addNewEntry("Tom Renn", "732", "24 mirta");
		book.addNewEntry("Ed Springer", "7221", "233 cort");
		book.addNewEntry("Frank Kempter", "343", "wewer");
		book.addNewEntry("Kurt Cal", "334", "werer");
		book.addNewEntry("Tim cost", "2222", "werebLAWERH");
		
		book.getEntries();
	}
}
