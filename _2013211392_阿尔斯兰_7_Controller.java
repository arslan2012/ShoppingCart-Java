package homework7;

public class _2013211392_阿尔斯兰_7_Controller {
	private _2013211392_阿尔斯兰_7_BookCatalog BookCatalog;
	private _2013211392_阿尔斯兰_7_Sale sales;
	public _2013211392_阿尔斯兰_7_Controller() {
		BookCatalog = new _2013211392_阿尔斯兰_7_BookCatalog();
	}
	public void addBook(String isbn, double price, String title, int type){
		BookCatalog.books.add(new _2013211392_阿尔斯兰_7_BookSpecification(isbn, price, title, type));
	}
	public _2013211392_阿尔斯兰_7_BookCatalog getBookCatalog(){
		return BookCatalog;
	}
	public void addCompositeStrategy(int type,int strats){
		_2013211392_阿尔斯兰_7_CopositeBestForCustomer tmp = new _2013211392_阿尔斯兰_7_CopositeBestForCustomer();
		int n = 0;
		for (int i = 1;i <= 5;i++){
			n = strats%10;
			tmp.add(_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(n));
			if (n == 0) break;
		}
		_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.put(type,tmp);
	}
	public void addSimpleStrategy(int type,int strattype,int num){
		switch (strattype){
		case 0:
			_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.put(type, new _2013211392_阿尔斯兰_7_PercentageStrategy(num));
			break;
		case 1:
			_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.put(type, new _2013211392_阿尔斯兰_7_FlatRateStrategy(num));
			break;
		case 2:
			_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.put(type, new _2013211392_阿尔斯兰_7_NoDiscountStrategy());
			break;
		default:
			break;
		}
	}
	public void deleteStrategy(int type){
		_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.remove(type);
	}
	public void updateStrategy(int type,double x){
		if (_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(type) instanceof _2013211392_阿尔斯兰_7_PercentageStrategy) {
			((_2013211392_阿尔斯兰_7_PercentageStrategy) _2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(type)).setX(x);
		}else if (_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(type) instanceof _2013211392_阿尔斯兰_7_FlatRateStrategy) {
			((_2013211392_阿尔斯兰_7_FlatRateStrategy) _2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(type)).setX(x);
		}
	}
	public int getStrategiesType(){
		int tmp = 0;
		for (int i = 1;i <=5;i++){
			if (_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(i) instanceof _2013211392_阿尔斯兰_7_PercentageStrategy) {
				tmp = tmp * 10 + 1;
			}else if (_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(i) instanceof _2013211392_阿尔斯兰_7_FlatRateStrategy) {
				tmp = tmp * 10 + 2;
			}
			else if (_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(i) instanceof _2013211392_阿尔斯兰_7_NoDiscountStrategy) {
				tmp = tmp * 10 + 3;
			}
			else if (_2013211392_阿尔斯兰_7_PricingStrategyFactory.getInstance().strats.strategies.get(i) instanceof _2013211392_阿尔斯兰_7_CopositeBestForCustomer) {
				tmp = tmp * 10 + 4;
			}
			else tmp = tmp *10;
		}
		return tmp;
	}
	public void buyBook(int num, String isbn){
		sales.additem(new _2013211392_阿尔斯兰_7_SaleLineItem(num,BookCatalog.getBookSpecification(isbn)));
	}
	public _2013211392_阿尔斯兰_7_Sale getSale(){
		return sales;
	}
	public void setSale(_2013211392_阿尔斯兰_7_Sale sales){
		this.sales = sales;
	}

}
