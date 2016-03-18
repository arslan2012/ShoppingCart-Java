package homework7;

public class _2013211392_阿尔斯兰_7_FlatRateStrategy implements _2013211392_阿尔斯兰_7_IPricingStrategy {
	private double discountPerBook;

	public _2013211392_阿尔斯兰_7_FlatRateStrategy(double num) {
		discountPerBook = num;
	}

	@Override
	public double getSubTotal(_2013211392_阿尔斯兰_7_SaleLineItem i) {
		// TODO Auto-generated method stub
		return i.copies*(i.prodSpec.getPrice()-discountPerBook);
	}
	public _2013211392_阿尔斯兰_7_FlatRateStrategy clone(){
		return new _2013211392_阿尔斯兰_7_FlatRateStrategy(this.discountPerBook);
	}
	public void setX(double x){
		discountPerBook = x;
	}
}
