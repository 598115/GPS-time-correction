

public class GPSClockApp {
    public static void main(String[] args) {

         CSVFileHandler fileHandler = new CSVFileHandler("v_data.csv", "h_data.csv", "coord_time.csv");
         
         //Paramter 1 = Total time of the simulation in seconds. 
         //Paramter 2 = the time increments between each measurment of height and velocity
         TimeSim sim = new TimeSim(86400.0, 60.0, fileHandler);

         sim.runSim();
    }
}
