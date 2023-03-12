package items;

public class ReadableItem extends AbstractItem implements Readable {

	String text;
	
	public ReadableItem(String name, int value, double weight, String text)
	{
		super(name, value, weight);
		this.text = text;
	}
	
	@Override
	public String read() {
		return text;
	}

}
