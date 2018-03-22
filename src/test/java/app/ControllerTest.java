package app;

import app.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 06/07/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetMethod()
    {
        String result = this.restTemplate.getForObject("/", String.class);
        String expected =
                "VMRG Web Service is ready.";
        assertEquals(expected, result);
    }

    @Test
    public void testPostMethod()
    {
        Car car = new Car();
        car.setMiles(10000);

        ResponseEntity<Receipt> result = this.restTemplate.postForEntity("/valuecar",
                car,
                Receipt.class);

        assertEquals( 200,  result.getStatusCodeValue() );
        assertEquals( 8500, result.getBody().getAmount() );
    }

}



