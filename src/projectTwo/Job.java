
package projectTwo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Eric Hayes
 * Job.java represents available jobs to be filled
 *
 */
public class Job extends Thing{
    
    //Class variables
	private double duration;
	private ArrayList<String> requirements;

	public Job(Scanner scannerInput) {
		super(scannerInput);
		if(scannerInput.hasNextDouble()) {
			this.setDuration(scannerInput.nextDouble());
		}
		//create arraylist to store jobs
		this.setRequirements(new ArrayList<>());
		while(scannerInput.hasNext()) {
			this.getRequirements().add(scannerInput.next());
		}
		
	}

	/**
	 * Generate getter for duration
	 * @return this.duration
	 */
	public double getDuration() {
		return duration;
	}
	
	/**
	 * Generate getter for requirements
	 * @return this.requirements
	 */
	
	public ArrayList<String> getRequirements() {
		return requirements;
	}
	
	/**
	 * Generate setter for duration
	 * @return void
	 */

	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * Generate setter for requirements
	 * @return void
	 */	

	public void setRequirements(ArrayList<String> requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		String jobInfo;
		
		jobInfo = super.toString() +
				"\nDuration: " + this.getDuration() +
				"\nRequirements:";
		if(this.getRequirements().isEmpty()) {
			jobInfo += "\n No Requiements";
		}else {
			for(String skill:this.getRequirements()) {
				jobInfo += "\n " + skill;
			}
		}
		
		return jobInfo;
	}
}
