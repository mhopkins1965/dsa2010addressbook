import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SerializationHandler {
	private static final String filename = "binarytree.ser";
	
	public static void serialize(BinarySearchTree binarySearchTree) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(binarySearchTree);
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BinarySearchTree deserialize() {
		BinarySearchTree binarySearchTree = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			binarySearchTree = (BinarySearchTree)in.readObject();
			in.close();
		}
		catch(IOException ex) {
			return binarySearchTree;
		}
		catch(ClassNotFoundException ex) {
			return binarySearchTree;
		}
		return binarySearchTree;
	}

}