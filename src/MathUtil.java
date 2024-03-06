import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil {

    // Speed of light in vacuum (m/s)
    private static final double C = 299792458;
        
    // Gravitational constant (m^3/kg/s^2)
    private static final double G = 6.67408e-11;
    
    // Earth's mass (kg)
    private static final double M = 5.9722e24;
    
    // Earth's radius (m)
    private static final double R = 6371000;
    
    // UTC sync constant
    private static final double L = 6.969290134e-10;

    public MathUtil() {
    }

    public double gravityDiscrepancy(double h) {

        double result = (G*M)/((h+R)*Math.pow(C, 2));
        //System.out.println("Grav discrepancy = " + result);
        return result;
    }

    public double motionDiscrepancy(double v) {

        double result = (Math.pow(v, 2))/(2*Math.pow(C, 2));
        //System.out.println("Motion discrepancy = " + result);
        return result;

    }

    public double gpsClockCorrection(double h, double v) {

        double result = (1-L+gravityDiscrepancy(h)+motionDiscrepancy(v));

        System.out.println("Correction calc result = " + result);

        BigDecimal bd = BigDecimal.valueOf(result);
        bd = bd.setScale(11, RoundingMode.HALF_UP);
        result = bd.doubleValue();
        return result;
    }

}
