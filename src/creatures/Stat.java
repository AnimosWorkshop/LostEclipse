package creatures;

public enum Stat {

	STR("STR"), 
	DEX("DEX"), 
	WIS("WIS");
	
	String name;
	
	private Stat(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
}
