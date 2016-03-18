package homework7;

public class _2013211392_阿尔斯兰_7_SaleLineItem {
	int copies;
	_2013211392_阿尔斯兰_7_BookSpecification prodSpec;
	private _2013211392_阿尔斯兰_7_IPricingStrategy strategy;

	public _2013211392_阿尔斯兰_7_SaleLineItem(int copies, _2013211392_阿尔斯兰_7_BookSpecification prodSpec) {
		super();
		this.copies = copies;
		this.prodSpec = prodSpec;
		this.strategy = _2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().getPricingStrategy(this.prodSpec.getType());
	}

	public double getSubTotal(){
		return strategy.getSubTotal(this);
	}

	@Override
	public String toString() {
		return "[copies=" + copies + prodSpec + "]";
	}
}
