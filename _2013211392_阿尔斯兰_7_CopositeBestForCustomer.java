package homework7;

import java.util.ArrayList;
import java.util.Comparator;

public class _2013211392_阿尔斯兰_7_CopositeBestForCustomer extends _2013211392_阿尔斯兰_7_CopositeStrategy {
	
	public _2013211392_阿尔斯兰_7_CopositeBestForCustomer() {
		super();
	}
	public _2013211392_阿尔斯兰_7_CopositeBestForCustomer(ArrayList<_2013211392_阿尔斯兰_7_IPricingStrategy> strategies) {
		super(strategies);
	}

	@Override
	public double getSubTotal(_2013211392_阿尔斯兰_7_SaleLineItem i) {
		return this.strategies.stream()
				.min(Comparator.comparing(strategy -> strategy.getSubTotal(i)))
				.get()
				.getSubTotal(i);

	}

	@Override
	public _2013211392_阿尔斯兰_7_CopositeBestForCustomer clone() {
		return new _2013211392_阿尔斯兰_7_CopositeBestForCustomer(this.strategies);
	}
}
