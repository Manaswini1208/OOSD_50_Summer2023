
public class CatalogItem {
	private Book book;
	public String id;
	public boolean availability;
	public CatalogItem(String id, Book book, boolean availability) {
		this.id = id;
		this.availability = availability;
		this.book = new Book(book.getTitle(),book.getAuthorFirstName(), book.getAuthorLastName());	
	}
	public Book getBook() {
		return book;
	}
	public String getId() {
		return id;
	}
	
	public void setAvailable() {
		this.availability = true;
		
	}
	
	public void setUnavailable() {
		this.availability = false;
	}
	public boolean isAvailable() {
		return availability;
	}
	

}
