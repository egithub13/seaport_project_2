
package projectTwo;

import java.util.Scanner;

/**
 * @author Eric Hayes
 * CargoShip.java represents a Cargo Ship and contains
 * member variables that differentiate cargo from passenger ships
 *
 */
public class CargoShip extends Ship{
    //Class varaibles
	private double cargoValue;
	private double cargoVolume;
	private double cargoWeight;

	public CargoShip(Scanner scannerInput) {
		super(scannerInput);
		if (scannerInput.hasNextDouble()) {
            this.setCargoWeight(scannerInput.nextDouble());
        }

        if (scannerInput.hasNextDouble()) {
            this.setCargoVolume(scannerInput.nextDouble());
        }

        if (scannerInput.hasNextDouble()) {
            this.setCargoValue(scannerInput.nextDouble());
        }
	}
	
	/**
	 * Generates getter for cargoValue
	 * @return this.cargoValue
	 */

	public double getCargoValue() {
		return cargoValue;
	}
	
	/**
	 * Generates getter for cargoVolume
	 * @return this.cargoVolume
	 */

	public double getCargoVolume() {
		return cargoVolume;
	}
	
	/**
	 * Generates getter for cargoValue
	 * @return this.cargoWeight
	 */

	public double getCargoWeight() {
		return cargoWeight;
	}
	
	/**
	 * Generates setter for cargoValue
	 * @return void
	 */

	public void setCargoValue(double cargoValue) {
		this.cargoValue = cargoValue;
	}
	/**
	 * Generates setter for cargoVolume
	 * @return void
	 */
	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}
	/**
	 * Generates setter for cargoWeight
	 * @return void
	 */

	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	@Override
	public String toString() {
		
		String cargoInfo = "Cargo Ship: " + super.toString() +
				"\nCargo Weight: " + this.getCargoWeight() +
				"\nCargo Value: " + this.getCargoValue() +
				"\nCargo Volume: " + this.getCargoVolume();
		
		return cargoInfo;
	}
    
}
