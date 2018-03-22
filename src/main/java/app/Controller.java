package app; /**
 * Created by User on 06/07/2017.
 */


import app.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
public class Controller
{

    @RequestMapping(value = "/")
    public String get()
    {
        return "VMRG Web Service is ready.";
    }

    @RequestMapping(value = "/valuecar", method = RequestMethod.POST)
    public ResponseEntity<Receipt> update(@RequestBody Car car) {
//            try {
        Receipt receipt = new Receipt();


        if ( car != null && car.getMiles() < 50000 ) {
            receipt.setAmount(8500);
        } else {
            receipt.setAmount(3000);
        }
        return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);

//            }
//        catch (HttpClientErrorException e1)
//        {
//            return  HttpStatusAndBody(e1.getStatusCode().value(),
//                                         e1.getResponseBodyAsString(),
//                                         null);
//        }

    }

}
