package bike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {
    private Bike bike;
    @BeforeEach
    void setUp() {
        bike = new Bike();
    }

    @Test
    void bikeIsOffAtCreation(){
        assertTrue(bike.turnOn());
    }

    @Test
    void bikeIsOn_TurnedOff(){
        bike.turnOn();
        assertFalse(bike.turnOff());
    }

    @Test
    void bikeIsOn_GearIsOne_CurrentSpeedIs15_AcceleratorIncreasedBy1() {
        bike.turnOn();
        for (int speedCount = 1; speedCount <= 15; speedCount++) {
            bike.accelerator();
        }
        assertEquals(15, bike.getSpeed());
        assertEquals(1, bike.getGear());
        bike.accelerator();
        assertEquals(16, bike.getSpeed());
        assertEquals(1, bike.getGear());

    }

    @Test
    void bikeIsOn_GearIsTwo_CurrentSpeedIs24_acceleratorIncreaseBy2(){
        bike.turnOn();
        bike.setSpeed(24);

        assertEquals(24,bike.getSpeed());
        assertEquals(2, bike.getGear());

        bike.accelerator();
        assertEquals(26,bike.getSpeed());
        assertEquals(2,bike.getGear());
    }

    @Test
    void bikeIsOn_GearIsThree_CurrentSpeedIs35_AcceleratorIncreaseBy3(){
        bike.turnOn();
        bike.setSpeed(35);

        assertEquals(35,bike.getSpeed());
        assertEquals(3, bike.getGear());

        bike.accelerator();
        assertEquals(38, bike.getSpeed());
        assertEquals(3,bike.getGear());
    }

    @Test
    void bikeOn_GearIsFour_CurrentSpeedIs44_AcceleratorIncreasedBy4(){
        bike.turnOn();
        bike.setSpeed(44);

        assertEquals(44, bike.getSpeed());
        assertEquals(4,bike.getGear());

        bike.accelerator();
        assertEquals(48,bike.getSpeed());
        assertEquals(4,bike.getGear());
    }
    @Test
    void testThatBikeIsOn_GearISOne_CurrentSpeedIs15_DecrementBy1(){
        bike.turnOn();
        for(int count =1; count <=15; count++){
            bike.accelerator();
        }
        bike.deaccelerate();
        assertEquals(14, bike.getSpeed());
        assertEquals(1,bike.getGear());
    }
    @Test
    void testThatBikeIsOn_GearIsTwo_CurrentSpeedIs24_DecrementBy2(){
        bike.turnOn();
        bike.setSpeed(24);
        bike.accelerator();
        assertEquals(26,bike.getSpeed());
        assertEquals(2,bike.getGear());
        bike.deaccelerate();
        assertEquals(24,bike.getSpeed());
        assertEquals(2,bike.getGear());
    }
    @Test
    void testThatBikeIsOn_GearIsThree_CurrentSpeedIs35_DecrementBy3(){
        bike.turnOn();
        bike.setSpeed(35);
        bike.accelerator();
        assertEquals(38,bike.getSpeed());
        assertEquals(3,bike.getGear());
        bike.deaccelerate();
        assertEquals(35,bike.getSpeed());
        assertEquals(3,bike.getGear());
    }
    @Test
    void testThatBikeOn_GearIsFour_CurrentSpeedIs44_Accelerate_DecrementBy4(){
        bike.turnOn();
        bike.setSpeed(44);
        bike.accelerator();
        assertEquals(48, bike.getSpeed());
        assertEquals(4,bike.getGear());
        bike.deaccelerate();
        assertEquals(44,bike.getSpeed());
        assertEquals(4,bike.getGear());

    }

}