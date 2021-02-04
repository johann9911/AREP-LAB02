package edu.escuelaing.arep;



import java.util.HashMap;
import org.junit.Test;
import edu.escuelaing.arep.Calculator.Calculator;
import junit.framework.Assert;


public class CalculatorTest
{
    Calculator calculator;
    public CalculatorTest()
    {
        
    }

    @Test
    public void testCalcultor(){
    	Calculator calculator = new Calculator();
    	HashMap<String, Double> result =calculator.calculate("160 591 114 229 230 270 128 1657 624 1503");
        Assert.assertEquals(550.6,result.get("Mean"),0.2);
        Assert.assertEquals(572.03,result.get("Deviation"),0.2);
    }
    @Test
    public void testCalcultor2(){
    	Calculator calculator = new Calculator();
    	HashMap<String, Double> result =calculator.calculate("15.0 69.9 6.5 22.4 28.4 65.9 19.4 198.7 38.8 138.2");
    	Assert.assertEquals(60.32,result.get("Mean"),0.2);
        Assert.assertEquals(62.26,result.get("Deviation"),0.2);
    }
    @Test
    public void testCalcultor3(){
    	Calculator calculator = new Calculator();
    	HashMap<String, Double> result =calculator.calculate("186 699 132 272 291 331 199 1890 788 1601");
    	Assert.assertEquals(638.9,result.get("Mean"),0.2);
        Assert.assertEquals(625.63,result.get("Deviation"),0.2);
    }
}
