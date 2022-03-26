 import java.util.*;


public class EncryptionProgram {
	/**
	 * Declare Instance variables private for application security concerns
	 */
	private Scanner scanner; // User input 
	private Random random;
	private ArrayList<Character> list; // Character objects
	private ArrayList<Character> shuffledList; // 
	private char character; // Starting position for characters used on ASCII Table
	private String line; // 
	private char[] letters; // Array of characters
	
	/**
	 * Constructor for class
	 */
	EncryptionProgram() {
		scanner = new Scanner(System.in); // Initialize Scanner
		random = new Random(); // 
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' '; // Space

/**
 * Generate new key for user
 */
		newKey();
/**
 * Display menu to user
 */
		menu();
	}
/**
 * Menu
 */
	private void menu() {
//		Ensure character entered is valid -> loop
		while(true) {
			System.out.println("***************************************************");
			System.out.println("*      Cipher Encryption Console Application      *");
			System.out.println("*                                                 *");
			System.out.println("*             Enter Option Selection              *");
			System.out.println("*                                                 *");
			System.out.println("***************************************************");
			System.out.println("*  (N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit   *");
			System.out.println("***************************************************");
//			Initialise choice; turn to uppercase get first character
			char choice = Character.toUpperCase(scanner.nextLine().charAt(0));			
			switch(choice) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a valid option..a");
			}
		}
	}

	/**
	 * ASCII character list
	 * Add characters to list
	 * Increment character by 1 after each iteration of loop
	 */
private void newKey(){
		
		character = ' '; // Empty Space -> reset
		list.clear(); // Good practice to clear the list 
		shuffledList.clear(); // Good practice to clear the list 
		
//		ASCII Table Character Iterator
		for(int i=32;i<127;i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
//		Initialize shuffled list 
		shuffledList = new ArrayList(list); // Make copy of arraylist
		Collections.shuffle(shuffledList); // Shuffle method to randomize list of characters
		System.out.println("***************************************************");
		System.out.println("*         A new key has been generated            *");
		
	}

/**
 * Print the scrambled ASCII characters from 32-127 
 */
private void getKey(){
//	List
	System.out.println("Key: ");
	for(Character x : list) {
		System.out.print(x);
	}
//	Shuffled List
	System.out.println();
	for(Character x : shuffledList) {
		System.out.print(x);
	}
	System.out.println();
}

/**
 * Encrypt plain text as cipher text -> secret message
 */
private void encrypt(){
	System.out.println("Enter a message to be encrypted: ");
	String message = scanner.nextLine();
	
	letters = message.toCharArray(); // Iterate through character of letters 
	
//	Nested for loop
	for(int i =0;i<letters.length;i++) {
		
		for(int j =0;j<list.size();j++) {
//			Search for matching letter in array -> retrieve corresponding index and replace
			if(letters[i]==list.get(j)) {
				letters[i]=shuffledList.get(j);
				break;
			}
		}
	}
//	Display Encrypted Message
	System.out.println("Encrypted: ");
	for(char x : letters) {
		System.out.print(x);
	}
	System.out.println();
}
/**
 * Decrypt cipher text to plain text -> take secret message and convert to plain text 
 */
private void decrypt(){
	System.out.println("Enter a message to be decrypted: ");
	String message = scanner.nextLine();
	
	letters = message.toCharArray();
	
	for(int i =0;i<letters.length;i++) {
		
		for(int j =0;j<shuffledList.size();j++) {
			if(letters[i]==shuffledList.get(j)) {
				letters[i]=list.get(j);
				break;
			}
		}
	}
	System.out.println("Decrypted: ");
	for(char x : letters) {
		System.out.print(x);
	}
	System.out.println();
}
/**
 * Exit application
 */
	private void quit() {
		System.out.println("Thank you, for using this Encryption Program.");
		System.exit(0);
	}
}