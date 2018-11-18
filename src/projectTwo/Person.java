
package projectTwo;

import java.util.Scanner;

/**
 * @author Eric Hayes
 * Person.java represents workers. Workers shall have one or many skills
 *
 */
public class Person extends Thing{
    
    //Class variable
	private String skill;

	public Person(Scanner scannerInput) {
		super(scannerInput);
		
		if(scannerInput.hasNext()) {
			this.setSkill(scannerInput.next());
		}else {
			this.setSkill("No available skill");
		}
	}
	
	/**
	 * Generates getter for skill
	 * @return this.skill
	 */

	public String getSkill() {
		return skill;
	}
	/**
	 * Generates setter for skill
	 * @param void
	 */

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Person: " + super.toString() + " " + this.getSkill();
	}
    
}
