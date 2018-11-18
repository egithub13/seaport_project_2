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
 * Ship.java represents a ship object.
 * Ship.java is the parent class for PassengerShip.java and
 * CargoShip.java
 *
 */
public class Ship extends Thing {
    
    //Class variables
	//PortTime object(s) are not used in projectOne
	private PortTime arrivalTime;
	private PortTime dockTime;
	private double draft;
	private double length;
	private double weight;
	private double width;
	private ArrayList<Job> jobs;

	public Ship(Scanner scannerInput) {
		super(scannerInput);
		if(scannerInput.hasNextDouble()) {
			this.setWeight(scannerInput.nextDouble());
		}
		if(scannerInput.hasNextDouble()) {
			this.setLength(scannerInput.nextDouble());
		}
		
		if(scannerInput.hasNextDouble()) {
			this.setWeight(scannerInput.nextDouble());
		}
		if(scannerInput.hasNextDouble()) {
			this.setDraft(scannerInput.nextDouble());
		}
		//Create arrayList of jobs
		this.setJobs(new ArrayList<>());
	}
	
	/**
	 * Generate getter for arrivalTime - future project
	 * @return this.arrivalTime
	 */

	public PortTime getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * Generate getter for dockTime - future project
	 * @return this.dockTime
	 */

	public PortTime getDockTime() {
		return dockTime;
	}
	
	/**
	 * Generate getter for draft
	 * @return this.draft
	 */
	
	public double getDraft() {
		return draft;
	}
	/**
	 * Generate getter for length
	 * @return this.length
	 */

	
	public double getLength() {
		return length;
	}
	
	/**
	 * Generate getter for weight
	 * @return this.weight
	 */
	
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Generate getter forwidth
	 * @return this.width
	 */
	
	public double getWidth() {
		return width;
	}
	
	/**
	 * Generate getter for jobs at dock
	 * @return this.jobs
	 */

	public ArrayList<Job> getJobs() {
		return jobs;
	}
	
	/**
	 * Generate setter for arrivalTime - future project
	 * @return void
	 */

	public void setArrivalTime(PortTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	/**
	 * Generate setter for dockTime - future project
	 * @return void
	 */
	public void setDockTime(PortTime dockTime) {
		this.dockTime = dockTime;
	}

	/**
	 * Generate setter for draft 
	 * @return void
	 */

	public void setDraft(double draft) {
		this.draft = draft;
	}

	/**
	 * Generate setter for length 
	 * @return void
	 */

	public void setLength(double length) {
		this.length = length;
	}

	
	/**
	 * Generate setter for weight 
	 * @return void
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Generate setter for width 
	 * @return void
	 */

	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Generate setter for jobs
	 * @return void
	 */

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		
		String shipInfo;
		shipInfo = "\n" + super.toString() + "\nWeight: " + this.getWeight() +
				"\nLength: " + this.getLength() +
				"\nWidth: " + this.getWidth() +
				"\nDraft: " + this.getDraft() +
				"\nJobs: ";
		if(this.getJobs().isEmpty()) {
			shipInfo += " No jobs at this time";
		}else {
			//interate through jobs arraylist to get available jobs
			for(Job availableJobs:this.getJobs()) {
				shipInfo += "\n" + availableJobs.toString();
			}
			
		}
		return shipInfo;
	}
	  
    
}
