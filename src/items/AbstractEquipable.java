package items;

import creatures.AbstractCharacter;
import creatures.EquipSlot;

public abstract class AbstractEquipable extends AbstractItem implements Equipable {

	private EquipSlot slot;

	public AbstractEquipable(String name, int value, double weight, EquipSlot slot) {
		super(name, value, weight);
		this.slot = slot;
	}
	
	public EquipSlot getEquipSlot()
	{
		return slot;
	}
	
	public void update(AbstractCharacter character)
	{
		character.equipItem(this);
	}
	
}
