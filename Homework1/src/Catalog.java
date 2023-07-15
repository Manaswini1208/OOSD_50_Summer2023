import java.util.ArrayList;
public class Catalog {
   private ArrayList<CatalogItem> catalogItems;
   public Catalog() {
      catalogItems = new ArrayList<>();
   }

   public String add(Book book) {
	   String id = String.valueOf(catalogItems.size());
	   CatalogItem catalogItemObj = new CatalogItem(id, book, true);
	   catalogItems.add(catalogItemObj);
	   return id;   
   }
   
   public boolean checkout(String id) {
	   for(CatalogItem  Item: catalogItems) {
		   if(Item.isAvailable() && Item.getId().equals(id)) {
			   Item.setUnavailable();
			   return true;
			   
		   }   
	   }
	   return false;
   }
   
   public boolean checkin(String id) {
	   for(CatalogItem Item: catalogItems) {
		   if(!Item.isAvailable() && Item.getId().equals(id)) {
			   Item.setAvailable();
			   return true;
		   }
	   }
	   return false;
		  
   }
   
   public ArrayList < String > search(String searchTerm) {
	   ArrayList<String> idsFound;
	   idsFound = new ArrayList<>();
	   for(CatalogItem Item: catalogItems) {
		   Book book = Item.getBook();
		   if(book.getTitle().equals(searchTerm) || book.getAuthorFirstName().equals(searchTerm) || book.getAuthorLastName().equals(searchTerm)) {
			   idsFound.add(Item.getId());
		   }
	   }
	   return idsFound;
	   
   }
   public Book getBook(String id) {
	      for (CatalogItem catalogItem : catalogItems) {
	         if (catalogItem.getId().equals(id)) {
	            return catalogItem.getBook();
	         }
	      }
	      return null;
	   }

	public boolean remove(String id) {
	     for (CatalogItem catalogItem : catalogItems) {
	         if (catalogItem.getId().equals(id)) {
	            if (catalogItem.isAvailable()) {
	               catalogItems.remove(catalogItem);
	               return true;
	            } else {
	               return false;
	            }
	         }
	      }
	      return false;
	   }
	
}



  