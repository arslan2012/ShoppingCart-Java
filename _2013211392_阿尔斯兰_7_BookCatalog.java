package homework7;

import java.util.ArrayList;

public class _2013211392_阿尔斯兰_7_BookCatalog {
	ArrayList<_2013211392_阿尔斯兰_7_BookSpecification> books;
	public _2013211392_阿尔斯兰_7_BookCatalog(){
		books = new ArrayList<_2013211392_阿尔斯兰_7_BookSpecification>();
	}
	public _2013211392_阿尔斯兰_7_BookSpecification getBookSpecification(String str){
		for (_2013211392_阿尔斯兰_7_BookSpecification book : books){
			if (book.getIsbn().equalsIgnoreCase(str))
				return book;
		}
		return null;
	}

}
