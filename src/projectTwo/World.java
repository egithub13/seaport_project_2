/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectTwo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Eric Hayes
 * World.java stores all other Thing.java objects
 * Thing.java objects are ascertained via the read
 * .txt file and arranges them for searching.
 *
 */
public class World extends Thing {
    
    //Class variables
	private ArrayList<SeaPort> seaPorts;
	//not used in projectOne
	private PortTime time;
	//Need a place store and collect all Things for parsing into appropriate classes.
	private ArrayList<Thing> things;
	

	public World(Scanner scannerInput) {
		super(scannerInput);
		this.setThings(new ArrayList<>());	
		this.setSeaPorts(new ArrayList<>());
		this.getFileData(scannerInput);
		
	}

/**
 * Generates getter for seaPorts
 * @return this.seaPorts
 */
	public ArrayList<SeaPort> getSeaPorts() {
		return this.seaPorts;
	}

	/**
	 * Generates getter for time
	 * @return this.time
	 */
	public PortTime getTime() {
		return this.time;
	}
	
	/**
	 * Generates getter for things
	 * @return this.things
	 */
	
	public ArrayList<Thing> getThings() {
		return this.things;
	}
	
	 
	/**
	 * Generates setter for seaPorts
	 * @return void
	 */
	public void setSeaPorts(ArrayList<SeaPort> seaPorts) {
		this.seaPorts = seaPorts;
	}
	
	/**
	 * Generates setter for things
	 * @return void
	 */
	
	public void setThings(ArrayList<Thing> things) {
		this.things = things;
	}
	/**
	 * Generates setter for time
	 * @return void
	 */

	public void setTime(PortTime time) {
		this.time = time;
	}
	
	/**
	 * Method required to process the .txt file contents in there repsective classes,
	 * in order to create specific objects to display and search. The information is added 
	 * ArrayList<Thing> things for parsing and searching
	 */
	private void getFileData(Scanner scannerInput) {
		
		//Generic String to store each line of data
		String lineData;
		//Scanner object to parse input text
		Scanner scanner;
		
		while(scannerInput.hasNextLine()){
			//Remove unneeded whitespace
			lineData = scannerInput.nextLine().trim();
			
			//Check for lines without text
			if(lineData.length() == 0) {
				//Continue scan of document if blank line is encountered
				continue;
			}
			
			//Create Scanner object
			scanner = new Scanner(lineData);
			
			if(scanner.hasNext()) {
				//Use switch statement to add .txt data to appropriate class 
				//and create new object of specified class
				switch(scanner.next().trim()) {
					case "port":
						SeaPort seaPort = new SeaPort(scanner);
						this.getThings().add(seaPort);
						this.getSeaPorts().add(seaPort);
						break;
					case "person":
						Person person = new Person(scanner);
						this.getThings().add(person);
						this.addThing(person,"getPersons");
						break;
					case "job":
						Job job = new Job(scanner);
						this.getThings().add(job);
						this.addJobToShip(job);
						break;
					case "dock":
						Dock dock = new Dock(scanner);
						this.getThings().add(dock);
						this.addThing(dock,"getDocks");
						break;
					case "pship":
						PassengerShip passengerShip = new PassengerShip(scanner);
						this.getThings().add(passengerShip);
						this.addShipToParent(passengerShip);
						break;
					case "cship":
						CargoShip cargoShip = new CargoShip(scanner);
						this.getThings().add(cargoShip);
						this.addShipToParent(cargoShip);
						break;
					default:
						break;
				}
			}
		}
	}
	
	 private void addShipToParent(Ship ship) {
	        SeaPort seaPort;
	        Dock dock = this.getThingByIndex(ship.getParent(), "getDocks");

	        if (dock == null) {
	            seaPort = this.getParentByIndex(this.getSeaPorts(), ship.getParent());
	            seaPort.getShips().add(ship);
	            seaPort.getQue().add(ship);
	        } else {
	            seaPort = this.getParentByIndex(this.getSeaPorts(), dock.getParent());
	            dock.setShip(ship);
	            seaPort.getShips().add(ship);
	        }
	    }
	/*
	 * The following methods are not operating properly. I Will improve on Project 2.
	 */
	@SuppressWarnings("unchecked")
    private <T extends Thing> void addThing(T thing, String method) {

        // Method variables
        SeaPort seaPort;
        ArrayList<T> things;
        Method getList;

       seaPort = this.getParentByIndex(this.getSeaPorts(), thing.getParent());

        try {
            
            getList = SeaPort.class.getDeclaredMethod(method);
            things = (ArrayList<T>) getList.invoke(seaPort);

            if (seaPort != null) {
                things.add(thing);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
	private <T extends Thing> T getParentByIndex(ArrayList<T> things, int index) {
        for (T thing : things) {
            if (thing.getIndex() == index) {
                return thing;
            }
        }
        return null;
    }
	private void addJobToShip(Job job) {
        Dock dock;
        Ship ship = this.getThingByIndex(job.getParent(), "getShips");

        if (ship != null) {
            ship.getJobs().add(job);
        } else {
            dock = this.getThingByIndex(job.getParent(), "getDocks");
            dock.getShip().getJobs().add(job);
        }
    }
	@SuppressWarnings("unchecked")
    private <T extends Thing> T getThingByIndex(int index, String method) {

        // Declarations
        Method getList;
        T thing;
        ArrayList<T> things;

        try {
            // Either SeaPort.class.getShips or SeaPort.class.getDocks
            getList = SeaPort.class.getDeclaredMethod(method);
            for (SeaPort port : this.getSeaPorts()) {
              
                things = (ArrayList<T>) getList.invoke(port);
                thing = this.getParentByIndex(things, index);

                if (thing != null) {
                    return thing;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
  
	@Override
    public String toString() {
        String worldInfo = "";

        for (SeaPort seaPort : this.getSeaPorts()) {
            worldInfo += seaPort.toString() + "\n\n";
        }
        return worldInfo;
    }
}
