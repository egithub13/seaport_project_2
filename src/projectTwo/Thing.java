/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectTwo;

import java.util.Scanner;

/**
 * @author eric hayes
 * Thing.java is the parent class of all classes
 *
 */
//Comparable will be implemented in future versions of program
public class Thing implements Comparable<Thing> {
    
    //class variables
	private int index;
	private String name;
	private int parent;
	
	
	//Constructor for Thing that is used to scan contents of chosen .txt file
	public Thing(Scanner scannerInput) {
		
		if(scannerInput.hasNext()) {
			this.setName(scannerInput.next());
		}
		if(scannerInput.hasNextInt()) {
			this.setIndex(scannerInput.nextInt());
		}
		if(scannerInput.hasNextInt()) {
			this.setParent(scannerInput.nextInt());
		}
		
	}
	
	//Create class getters and setters
	//Setters
	private void setIndex(int index) {
		this.index = index;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setParent(int parent) {
		this.parent = parent;
	}
	
	//Getters
	public int getIndex() {
		return this.index;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getParent() {
		return this.parent;
	}
	
	/**
	 * Override the toSTring() method for display in JText Area
	 * toString() will not return parent because the Thing class is the parent class for
	 * all classes
	 */	
	 
	public String toString() {
		return this.getName()+" "+this.getIndex();
	}
	
	/**
	 * compareTo() method to compare instances of Thing objects.
	 * May not need to be used in project 1
	 */
	
	public int compareTo(Thing instanceOfThing) {
		if((instanceOfThing.getIndex() == this.getIndex()) && (instanceOfThing.getName() == this.getName()) &&
				(instanceOfThing.getParent() == this.getParent())) {
			return 1;
		}
		else {
			return 2;
		}
	}
}
