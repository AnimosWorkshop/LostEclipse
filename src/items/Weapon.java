package items;

import java.util.Set;

import creatures.AbstractCharacter;
import creatures.EquipSlot;
import creatures.Stat;

public class Weapon extends AbstractEquipable {

	private Set<Stat> effectiveStats;
	private int baseDamage;
	
	public Weapon(String name, int value, double weight, Set<Stat> effectiveStats, int baseDamage) {
		super(name, value, weight, EquipSlot.Hands);
		this.baseDamage = baseDamage;
	}
	
	public double calculateDamageBonus(AbstractCharacter character)
	{
		double mult = switch(effectiveStats.size()) {
			case 1 -> 0.65;
			case 2 -> 0.35;
			case 3 -> 0.25;
			default -> 0;
		};
		double weightedSum = 0;
		for (Stat stat : effectiveStats)
		{
			switch(stat) {
				case STR:
					weightedSum += mult * character.getStatBlock().getMight();
					break;
				case DEX:
					weightedSum += mult * character.getStatBlock().getAgility();
					break;
				case WIS:
					weightedSum += mult * character.getStatBlock().getMind();
					break;
			}
		}
		return baseDamage * weightedSum;
	}

	@Override
	public void equip(AbstractCharacter character)
	{
		
	}
	
	@Override
	public void dequip(AbstractCharacter character)
	{
		
	}
	
}
