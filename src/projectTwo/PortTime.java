
package projectTwo;

/**
 * @author Eric Hayes
 * PortTime.java is unused in project one
 * It will keep port of entry times in future projects
 *
 */
public class PortTime {
    
    private int time;
	
	/**
	 * Constructor
	 */
	public PortTime(int time) {
		this.time = time;
		
	}
	
	/**
	 * Generate getter
	 * @return this.time
	 */

	public int getTime() {
		return time;
	}
	
	/**
	 * Generate setter
	 * @return void
	 */
	public void setTime(int time) {
		this.time = time;
	}
	

	@Override
	public String toString() {
		return "PortTime: " + getTime();
	}
    
}
