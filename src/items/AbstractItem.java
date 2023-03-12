package items;

/**
 * @imp_inv value >= 0
 * @imp_inv weight >= 0.
 */
public abstract class AbstractItem implements Item {
	
	private String name;
	private int value;
	private double weight;
	
	public AbstractItem(String name, int value, double weight)
	{
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public int getValue()
	{
		return this.value;
	}

	@Override
	public double getWeight()
	{
		return this.weight;
	}
	
	@Override
	public String toString() {
		return getName() + " | " + getValue() + " coins | " + getWeight() + " lb.";
	}

}
