package homework7;

import java.util.ArrayList;

public abstract class _2013211392_阿尔斯兰_7_CopositeStrategy implements _2013211392_阿尔斯兰_7_IPricingStrategy {
	ArrayList<_2013211392_阿尔斯兰_7_IPricingStrategy> strategies;
	
	public _2013211392_阿尔斯兰_7_CopositeStrategy(){
		this.strategies = new ArrayList<_2013211392_阿尔斯兰_7_IPricingStrategy>();
	}
	public _2013211392_阿尔斯兰_7_CopositeStrategy(ArrayList<_2013211392_阿尔斯兰_7_IPricingStrategy> strategies){
		this.strategies = strategies;
	}
	
	public void add (_2013211392_阿尔斯兰_7_IPricingStrategy s){
		this.strategies.add(s.clone());
	}
	public abstract _2013211392_阿尔斯兰_7_CopositeStrategy clone();
}
