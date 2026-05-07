import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ACTest {

    AC myAC;

    @BeforeEach
    public void setUp() {

        myAC = new AC();
    }

    @Test
    public void testThatACExists()     {
        assertNotNull(myAC);
    }

    @Test
    public void testThatACIsOff()  {
        assertTrue (myAC.isOff());
    }

    @Test
    void testThatACIsOn()  {
        assertTrue(myAC.isOff());
        myAC.turnOnAC();
        assertFalse(myAC.isOff());

    }

    @Test

    void testThatMyACIsOn_WhenTurnedOff_ItShouldBeOffTest()     {
        myAC.turnOnAC();
        assertFalse(myAC.isOff());
        myAC.turnOffAC();
        assertTrue(myAC.isOff());

    }

    @Test

    void myACIsOn_IncreaseTemperature_IncrementsByOne() {

        myAC.turnOnAC();
        assertFalse(myAC.isOff());
        myAC.increaseTemperature();
        assertEquals(25, myAC.getTemperature());
    }

    @Test

    void myACIsOff_WhenTurnedOn_temperatureIs24()       {

        myAC.turnOnAC();
        assertEquals(24, myAC.getTemperature());
    }

    @Test
    void myACIsOff_temperatureShouldNotIncrease()  {
        assertTrue(myAC.isOff());
        myAC.increaseTemperature();
        assertEquals(-1, myAC.getTemperature());
    }

    @Test
    void myACIsOn_TemperatureIs24_IncreaseTemperatureShouldNotExceed30(){
        myAC.turnOnAC();
        for (int count = 0; count < 7; count++) {myAC.increaseTemperature();}

        assertEquals(30, myAC.getTemperature());

    }

    @Test
    void myACIsOff_temperatureShouldNotDecrease()  {
        assertTrue(myAC.isOff());
        myAC.increaseTemperature();
        assertEquals(-1, myAC.getTemperature());
    }

    @Test
    void temperatureIs24Deg_DecreaseTemperature_TemperatureDecreasesByOne()     {

        myAC.turnOnAC();
        myAC.decreaseTemperature();
        assertEquals(23, myAC.getTemperature());
    }

    @Test
    void temperatureIs24Deg_DecreaseTemperature_TemperatureShouldNotGoBelow16()     {

        myAC.turnOnAC();
        for (int count = 0; count < 9; count++) {myAC.decreaseTemperature();}
        assertEquals(16, myAC.getTemperature());
    }



}