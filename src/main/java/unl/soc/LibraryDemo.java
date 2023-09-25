package unl.soc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Main driver file for the library demonstration.
 *
 */
public class LibraryDemo {

	private final static Scanner STDIN = new Scanner(System.in);

	private final Library lib;

	public LibraryDemo() {
		this.lib = new Library();
		loadFile();
	}

	private void loadFile() {
		Scanner s = null;
		try {
			s = new Scanner(new File("data/books.csv"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		while (s.hasNext()) {
			String line = s.nextLine();
			String tokens[] = line.split(",");
			String title = tokens[0];
			String auth[] = tokens[1].split(" ");
			Author author = new Author();
			author.firstName = auth[0];
			author.lastName = auth[1];
			String isbn = tokens[2];
			String publishDate = tokens[3];
			Book b = new Book();
			b.setTitle(title);
			b.setAuthor(author);
			b.setISBN(isbn);
			b.setPublishDate(publishDate);
			lib.addBook(b);
		}
		s.close();
	}

	/**
	 * Method that searches for a book.
	 */
	private void searchBookInterface() {
		System.out
				.println("Please enter a Search Option:\n (1) Search By Title (2) Search By Author (3) Keyword Search");
		int userChoice = STDIN.nextInt();
		System.out.print("Enter your search term: ");
		String query = STDIN.next();

		STDIN.nextLine(); // to account for search terms with more than one word

		switch (userChoice) {
		case 1:
			printBooks(this.lib.titleSearch(query));
			break;
		case 2:
			printBooks(this.lib.authorSearch(query));
			break;
		case 3:
			printBooks(this.lib.keywordSearch(query));
			break;
		default:
			break;
		}
		return;
	}

	private void printBooks(List<Book> books) {

		System.out.print("\n");
		System.out.println(String.format("%-50s %-20s %-15s", "TITLE", "AUTHOR", "ISBN"));
		for (Book b : books) {
			String formattedAuthor = null;
			if (b.getAuthor() != null) {
				formattedAuthor = b.getAuthor().lastName + ", " + b.getAuthor().lastName;
			}
			String line = String.format("%-50s %-20s %-15s", b.getTitle(), formattedAuthor, b.getISBN());
			System.out.println(line);
		}
		System.out.print("\n\n");
	}

	/**
	 * Method that adds a book.
	 */
	private void addBookInterface() {
		// change this function
		System.out.println("Please enter the details of the book you want to add to the library");
		System.out.println("Enter the title of the book: ");
		STDIN.nextLine();
		String title = STDIN.nextLine();
		System.out.println("Enter the first name of the author: ");
		String firstName = STDIN.nextLine();
		System.out.println("Enter the last name of the author: ");
		String lastName = STDIN.nextLine();
		System.out.println("Enter the ISBN of the book: ");
		String isbn = STDIN.nextLine();
		System.out.println("Enter the publication date (YYYY-MM-DD)");
		String publishDate = STDIN.nextLine();
		Author author = new Author();
		author.firstName = firstName;
		author.lastName = lastName;
		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setISBN(isbn);
		b.setPublishDate(publishDate);
		this.lib.addBook(b);
		return;
	}

	/**
	 * Method that acts as the interface to the library software.
	 */
	public void libraryInterface() {
		int userChoice = 0;

		while (userChoice != 4) {
			System.out.println("Welcome to the Arcadia Library.");
			System.out.print("Please enter a choice: (1) Add a book, (2) Find a book, (3) Print Collection (4) Exit:");
			userChoice = STDIN.nextInt();

			switch (userChoice) {
			case 1:
				this.addBookInterface();
				break;
			case 2:
				this.searchBookInterface();
				break;
			case 3:
				printBooks(this.lib.getCollection());
				break;
			default:
				break;
			}

		}
		STDIN.close();
		System.out.println("Thank You for Using Arcadia Library !");

		return;
	}

	/**
	 * Main method
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		LibraryDemo demo = new LibraryDemo();
		demo.libraryInterface();
	}
}