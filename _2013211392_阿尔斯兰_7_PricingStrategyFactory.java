package homework7;

public class _2013211392_阿尔斯兰_7_PricingStrategyFactory {
	private static _2013211392_阿尔斯兰_7_PricingStrategyFactory instance;
	_2013211392_阿尔斯兰_7_StrategyCatalog strats;
	private _2013211392_阿尔斯兰_7_PricingStrategyFactory() {
		strats = new _2013211392_阿尔斯兰_7_StrategyCatalog();
	}
	//单子方法getlnstance返回工厂类的唯一实例
	public static synchronized _2013211392_阿尔斯兰_7_PricingStrategyFactory getInstance() 
	{
	   if ( instance == null )
	         instance = new _2013211392_阿尔斯兰_7_PricingStrategyFactory(); 
	   return instance; 
	}
	public _2013211392_阿尔斯兰_7_IPricingStrategy getPricingStrategy(int type){
		return strats.strategies.get(type);
	}

}
