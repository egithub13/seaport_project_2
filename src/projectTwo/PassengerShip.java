/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectTwo;

import java.util.Scanner;

/**
 * @author Eric Hayes
 * Passenger.java represents a passenger Ship and contains
 * member variables that differentiate passenger from cargo ships
 *
 */
public class PassengerShip extends Ship {
    
    //Class variables
	private int numberOfOccupiedRooms;
	private int numberOfPassengers;
	private int numberOfRooms;

	public PassengerShip(Scanner scannerInput) {
		super(scannerInput);
		if(scannerInput.hasNextInt()) {
			this.setNumberOfPassengers(scannerInput.nextInt());
		}
		if(scannerInput.hasNextInt()) {
			this.setNumberOfRooms(scannerInput.nextInt());
		}
		if(scannerInput.hasNextInt()) {
			this.setNumberOfOccupiedRooms(scannerInput.nextInt());
		}
	}
	
	/**
	 * Generates getter number of occupied rooms
	 * @return this.numberOfOccupiedRooms
	 */

	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	}
	
	/**
	 * Generates getter number of passengers
	 * @return this.numberOfPassengers
	 */

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	
	/**
	 * Generates getter number of total rooms
	 * @return this.numberOfRooms
	 */

	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	/**
	 * Generates setter number of occupied rooms
	 * @return void
	 */

	public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
		this.numberOfOccupiedRooms = numberOfOccupiedRooms;
	}
	
	/**
	 * Generates setter number of passengers
	 * @return void
	 */

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	
	/**
	 * Generates setter number of total rooms
	 * @return void
	 */

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
    
}
