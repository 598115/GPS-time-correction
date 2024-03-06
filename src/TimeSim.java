import java.math.BigDecimal;
import java.math.RoundingMode;

public class TimeSim {

    private double remainingTime;
    private CSVFileHandler fileHandler;
    private double timeQuantum;

    public TimeSim(double remainingTime, double timeQuantum, CSVFileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.remainingTime = remainingTime;
        this.timeQuantum = timeQuantum;
    }

    public void runSim() {

        MathUtil util = new MathUtil();
        double cumulator = 0;
        int counter = 1;                  //Only for debugging

      while(remainingTime > 0) {
        double v = fileHandler.readNextVline();
        System.out.println("Velocity" + counter + " = " + v);
        double h = fileHandler.readNextHline();
        System.out.println("Height" + counter + " = " + h);
        double output = util.gpsClockCorrection(h, v)*timeQuantum;
        cumulator += output;
        BigDecimal bd = BigDecimal.valueOf(cumulator);
        bd = bd.setScale(11, RoundingMode.HALF_UP);
        fileHandler.writeNextLine(bd.doubleValue() + "");
        remainingTime -= timeQuantum;
        counter++;
      }
      fileHandler.flushWriter();
      fileHandler.close();
    }

}
