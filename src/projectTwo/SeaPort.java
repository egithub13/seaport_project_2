/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectTwo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Eric Hayes
 * SeaPort.java contains docks, ships, and persons.
 *
 */
public class SeaPort extends Thing{
    private ArrayList<Dock> docks;
	//List of ships at this port
	private ArrayList<Ship> ships;
	//List of ships waiting to dock
	private ArrayList<Ship> que;
	//People with skills at this port
	private ArrayList<Person> persons;

	public SeaPort(Scanner scannerInput) {
		super(scannerInput);
	this.setDocks(new ArrayList<>());
        this.setQue(new ArrayList<>());
        this.setShips(new ArrayList<>());
        this.setPersons(new ArrayList<>());
		
	}

	/**
	 * Generates getter for docks
	 * @return this.docks
	 */
	public ArrayList<Dock> getDocks() {
		return docks;
	}
	
	/**
	 * Generates getter for ship
	 * @return this.ships
	 */
	public ArrayList<Ship> getShips() {
		return ships;
	}
	/**
	 * Generates getter for que
	 * @return this.que
	 */

	public ArrayList<Ship> getQue() {
		return que;
	}
	/**
	 * Generates getter for persons
	 * @return this.persons
	 */

	public ArrayList<Person> getPersons() {
		return persons;
	}
	
	/**
	 * Generates setter for docks
	 * @return void
	 */

	public void setDocks(ArrayList<Dock> docks) {
		this.docks = docks;
	}
	/**
	 * Generates setter for ship
	 * @return void
	 */

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}
	/**
	 * Generates setter for dque
	 * @return void
	 */


	public void setQue(ArrayList<Ship> que) {
		this.que = que;
	}
	
	/**
	 * Generates setter for persons
	 * @return void
	 */

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		String seaPortInfo;
		seaPortInfo = "Sea Port: \t***** " + super.toString() + " *****";
		
		//Interate through Arraylist<Dock> to return available dock info
		for(Dock dock:this.getDocks()) {
			seaPortInfo +="\n " + dock.toString();
		}
		
		//get Ships in que and interate through ArrayList<Ship> to return available ship info
		seaPortInfo += "\n ---Ships Waitng in Que----\n";
		for(Ship ships:this.getShips()) {
			seaPortInfo +="--> " + ships.getName() + " "+ ships.getIndex() + "\n" +
					"Type: " + ships.getClass().getSimpleName() + "\n";
		}
		
		//Get persons on ships and interate through ArrayList<Person> to return available person info
		seaPortInfo += "\n ---Available People\n";
		for(Person person:this.getPersons()) {
			seaPortInfo += "--> " + person.toString() + "\n";
		}
		return seaPortInfo +"\n";
	}
}
