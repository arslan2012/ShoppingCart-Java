package homework7;
enum  booktype {非教材类计算机图书,教材类图书,连环画类图书,养生类图书,其他}

public class _2013211392_阿尔斯兰_7_BookSpecification {
	private int type;
	private double price;
	private String isbn,title;
	public _2013211392_阿尔斯兰_7_BookSpecification(String isbn, double price, String title, int type) {
		super();
		this.type = type;
		this.price = price;
		this.isbn = isbn;
		this.title = title;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[price=" + price + ", isbn=" + isbn + ", title=" + title + "]";
	}
}
