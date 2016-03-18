package homework7;

import java.util.ArrayList;

public class _2013211392_阿尔斯兰_7_Sale implements _2013211392_阿尔斯兰_7_Subject{
	private ArrayList<_2013211392_阿尔斯兰_7_SaleLineItem> items;
	private final ArrayList<_2013211392_阿尔斯兰_7_Observer> observers;
	public _2013211392_阿尔斯兰_7_Sale() {
		items = new ArrayList<_2013211392_阿尔斯兰_7_SaleLineItem>();
		observers = new ArrayList<_2013211392_阿尔斯兰_7_Observer>();
	}
	public void additem(_2013211392_阿尔斯兰_7_SaleLineItem o){
		for (int i = 0; i < items.size(); i++){
			if (items.get(i).equals(o))
				items.remove(i);
		}
		items.add(o);
		this.notifyObservers();
	}
	public ArrayList<_2013211392_阿尔斯兰_7_SaleLineItem> getItems() {
		return items;
	}
	public double getTotal(){
		double sum = 0;
		for (int i = 0;i < items.size();i++){
			sum+=items.get(i).getSubTotal();
		}
		return sum;
	}
	@Override
    public void registerObserver(final _2013211392_阿尔斯兰_7_Observer o)
    {
        observers.add(o);
    }

    @Override
    public void removeObserver(final _2013211392_阿尔斯兰_7_Observer o)
    {
        if (observers.indexOf(o) >= 0)
        {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers()
    {
        for (final _2013211392_阿尔斯兰_7_Observer o : observers)
        {
            o.update(items);
        }
    }
}
