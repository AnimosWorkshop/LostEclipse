package items;

import creatures.AbstractCharacter;

public interface Equipable {

	public void equip(AbstractCharacter character);
	public void dequip(AbstractCharacter character);
	
}
