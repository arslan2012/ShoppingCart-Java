package homework7;

public class _2013211392_阿尔斯兰_7_NoDiscountStrategy implements _2013211392_阿尔斯兰_7_IPricingStrategy {

	public _2013211392_阿尔斯兰_7_NoDiscountStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getSubTotal(_2013211392_阿尔斯兰_7_SaleLineItem i) {
		return i.copies*i.prodSpec.getPrice();
	}	
	public _2013211392_阿尔斯兰_7_NoDiscountStrategy clone(){
		return new _2013211392_阿尔斯兰_7_NoDiscountStrategy();
	}
}
