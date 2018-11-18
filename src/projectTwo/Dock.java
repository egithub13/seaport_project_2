package projectTwo;

import java.util.Scanner;

/**
 * @author Eric Hayes
 * Dock.java creates dock objects that exist
 * in a particular SeaPort. The Ship object represents a ship
 * docked at a particular Dock.
 *
 */
public class Dock extends Thing {
    
    //Class variables
	private Ship ship;

	public Dock(Scanner scannerInput) {
		super(scannerInput);
		
	}
	
	/**
	 * Generates getter for ship variable
	 * @return this.ship
	 */

	public Ship getShip() {
		return ship;
	}
	
	/**
	 * Generates setter for ship variable
	 * @param void
	 */

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		String shipInfo = "\nDock: " + super.toString() + "\n";
		
		if(this.getShip() == null) {
			shipInfo += " No ships are docked";
		}else {
			shipInfo += this.getShip().toString();
		}
		
		return shipInfo;
	}
    
    
}
