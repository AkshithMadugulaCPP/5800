package test.java.Final;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Final.Driver;
import org.junit.jupiter.api.Test;

class DriverTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Driver#Driver(String, String, String, String)}
     *   <li>{@link Driver#setOperatingCounty(String)}
     *   <li>{@link Driver#setShift(String)}
     *   <li>{@link Driver#getOperatingCounty()}
     *   <li>{@link Driver#getShift()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Driver actualDriver = new Driver("Name", "42 Main St", "3", "Shift");
        actualDriver.setOperatingCounty("3");
        actualDriver.setShift("Shift");
        String actualOperatingCounty = actualDriver.getOperatingCounty();

        // Assert that nothing has changed
        assertEquals("3", actualOperatingCounty);
        assertEquals("Shift", actualDriver.getShift());
    }
}
