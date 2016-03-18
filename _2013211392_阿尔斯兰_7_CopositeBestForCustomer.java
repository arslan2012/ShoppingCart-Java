package homework7;

import java.util.ArrayList;

public class _2013211392_阿尔斯兰_7_CopositeBestForCustomer extends _2013211392_阿尔斯兰_7_CopositeStrategy {
	
	public _2013211392_阿尔斯兰_7_CopositeBestForCustomer() {
		super();
	}
	public _2013211392_阿尔斯兰_7_CopositeBestForCustomer(ArrayList<_2013211392_阿尔斯兰_7_IPricingStrategy> strategies) {
		super(strategies);
	}

	@Override
	public double getSubTotal(_2013211392_阿尔斯兰_7_SaleLineItem i) {
		double num = this.strategies.get(0).getSubTotal(i);;
		for (int j=0;j<this.strategies.size();j++){
			if (this.strategies.get(j).getSubTotal(i) >= num)
				num = this.strategies.get(j).getSubTotal(i);
		}
		return num;
	}

	@Override
	public _2013211392_阿尔斯兰_7_CopositeBestForCustomer clone() {
		return new _2013211392_阿尔斯兰_7_CopositeBestForCustomer(this.strategies);
	}
}
