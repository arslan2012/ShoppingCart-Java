package homework7;

import java.util.ArrayList;

public interface _2013211392_阿尔斯兰_7_Subject {
	public void registerObserver(_2013211392_阿尔斯兰_7_Observer o);
	public void removeObserver(_2013211392_阿尔斯兰_7_Observer o);
	public void notifyObservers();
	public ArrayList<_2013211392_阿尔斯兰_7_SaleLineItem> getItems();
}
