/* name: Braeden Christensen And Steele Anderson
Assignment: A10 - Team Assignment
Class - Programming 1400
*/

import java.util.Random;
public class Critters
{

				
		//attributes/fields
		private String critterName;
		private String attackName;
		private int attackDamageAmount;
		private int critterHealth;
		private int currentHealth;
		
		Random rand = new Random();
		
		//constructor
		public Critters(String name, String attackTitle, int attackDamage, int critterHP)
		{
			critterName = name;
			attackDamageAmount = attackDamage;
			attackName = attackTitle;
			critterHealth = critterHP;
			currentHealth = critterHP;
		}
		
		//methods
		public String getName()
		{
			return critterName;
		}
		
		public String getAttackName()
		{
			return attackName;
		}
		
		public int getAttackDamage()
		{
			return attackDamageAmount;
		}
		
		public void recieveDamage(int damageDealt)
		{
			currentHealth -= damageDealt;
		}
		
		public int getTotalHealth()
		{
			return critterHealth;
		}

		public int getCurrentHealth()
		{
			return currentHealth;
		}
		
		public void restHeal()
		{
			currentHealth += (rand.nextInt(8) + 1);
		}
		
		public void resetCritter()
		{
			currentHealth = getTotalHealth();
		}
		
		
}
