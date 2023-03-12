package creatures;

public interface Creature {

	/**
	 * @inv level > 0
	 * @inv might > 0
	 * @inv agility > 0
	 * @inv mind > 0
	 */
	public static class StatBlock implements Cloneable {

		private int level;
		private int might;
		private int agility;
		private int mind;
		
		public StatBlock()
		{
			this(1, 8, 8, 8);
		}
		
		public StatBlock(int level, int might, int agility, int mind)
		{
			this.level = level;
			this.might = might;
			this.agility = agility;
			this.mind = mind;
		}
		
		public int getLevel() { return this.level; }
		public int getMight() { return this.might; }
		public int getAgility() { return this.agility; }
		public int getMind() { return this.mind; }
		
		/**
		 * @pre inc > 0
		 */
		public StatBlock increaseStrength(int inc) {
			StatBlock newSB = this.clone();
			newSB.might += inc;
			return newSB;
		}

		/**
		 * @pre inc > 0
		 */
		public StatBlock increaseDexterity(int inc) {
			StatBlock newSB = this.clone();
			newSB.agility += inc;
			return newSB;
		}
		
		/**
		 * @pre inc > 0
		 */
		public StatBlock increaseWisdom(int inc) {
			StatBlock newSB = this.clone();
			newSB.mind += inc;
			return newSB;
		}
		
		public StatBlock clone()
		{
			return new StatBlock(level, might, agility, mind);
		}
		
	}
	
	public StatBlock getStatBlock();
	
}
