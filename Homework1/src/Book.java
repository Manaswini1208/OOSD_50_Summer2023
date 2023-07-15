
public class Book {
	String title;
	String firstName;
	String lastName;
	
	public Book(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthorFirstName() {
		return firstName;
	}
	
	public String getAuthorLastName() {
		return lastName;
	}
	
	public String toString() {
		String str = " The book with the title " + title + " is written by " + firstName + lastName + ".";
		return str;
	}
}
