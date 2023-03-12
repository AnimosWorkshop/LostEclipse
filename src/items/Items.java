package items;

public enum Items {

	NovoumSign(new ReadableItem("Sign to Novoum", 1, 1.8, "Novoum - East")),
	ScrollOfTruth(new ReadableItem("Scroll of Wisdom", 200, 0.1, "The truth lies within."));
	
	Item item;
	
	Items(Item item)
	{
		this.item = item;
	}
	
	public Item getItem()
	{
		return this.item;
	}
	
}
