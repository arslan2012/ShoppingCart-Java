package homework7;

public class _2013211392_阿尔斯兰_7_PercentageStrategy implements _2013211392_阿尔斯兰_7_IPricingStrategy {
	private int discountPercentage;

	public _2013211392_阿尔斯兰_7_PercentageStrategy(int num) {
		discountPercentage = num;
	}

	@Override
	public double getSubTotal(_2013211392_阿尔斯兰_7_SaleLineItem i) {
		return i.copies*i.prodSpec.getPrice()*(100-discountPercentage)/100;
	}
	public _2013211392_阿尔斯兰_7_PercentageStrategy clone(){
		return new _2013211392_阿尔斯兰_7_PercentageStrategy(this.discountPercentage);
	}
	public void setX(double x){
		discountPercentage = (int)x;
	}
}
