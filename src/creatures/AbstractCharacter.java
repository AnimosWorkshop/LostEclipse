package creatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import general.GameManager;
import items.Item;
import items.AbstractEquipable;

public abstract class AbstractCharacter implements Creature {

	private String name;
	private StatBlock statBlock;
	private List<Item> bagInventory;
	private Map<EquipSlot, AbstractEquipable> equippedItems;
	
	public AbstractCharacter(String name)
	{
		this.name = name;
		this.statBlock = new StatBlock();
		this.bagInventory = new ArrayList<>();
	}
	
	public AbstractCharacter(String name, StatBlock statBlock)
	{
		this(name);
		this.statBlock = statBlock;
	}
	
	public String getName()
	{
		return name;
	}
	
	public StatBlock getStatBlock()
	{
		return statBlock;
	}
	
	public List<Item> getInventory()
	{
		return bagInventory;
	}
	
	public AbstractEquipable getEquippedInSlot(EquipSlot slot)
	{
		return equippedItems.get(slot);
	}
	
	public void updateEquipped()
	{
		for(AbstractEquipable equippedItem : equippedItems.values())
			equippedItem.update(this);
	}
	
	/**
	 * @pre getInventory().contains(item)
	 */
	public void equipItem(AbstractEquipable item)
	{
		dequipItem(item.getEquipSlot());
		equippedItems.put(item.getEquipSlot(), item);
		item.equip(this);
		bagInventory.remove(item);
	}
	
	/**
	 * @pre getInventory().contains(item)
	 */
	public void equipItem(AbstractEquipable item, boolean log)
	{
		equipItem(item);
		if(log)
		{
			GameManager.log(getName() + " equipped " + item.getName() + ".");
		}
	}
	
	/**
	 * @post equippedItems(slot) == null
	 * @post $ret != null $implies $prev(dequipItem(slot)) != null 
	 * @post $ret != null $implies getInventory().size() = $prev(getInventory().size()) + 1
	 */
	public AbstractEquipable dequipItem(EquipSlot slot)
	{
		AbstractEquipable prevEquipped = getEquippedInSlot(slot);
		boolean wasEmpty = prevEquipped == null;
		if(!wasEmpty)
		{
			prevEquipped.dequip(this);
			equippedItems.remove(slot);
			bagInventory.add(prevEquipped);
		}
		return prevEquipped;
	}
	
	/**
	 * @post equippedItems(slot) == null
	 * @post $ret $implies $prev(dequipItem(slot)) != null 
	 * @post $ret $implies getInventory().size() = $prev(getInventory().size()) + 1
	 */
	public AbstractEquipable dequipItem(EquipSlot slot, boolean log)
	{
		AbstractEquipable prevEquipped = dequipItem(slot);
		if(prevEquipped != null)
		{
			GameManager.log(getName() + " dequipped " + prevEquipped.getName() + ".");
		}
		return prevEquipped;
	}
	
}
