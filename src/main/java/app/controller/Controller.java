package app.controller;


import app.model.Car;
import app.model.Receipt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
public class Controller
{
    @GetMapping(value = "/")
    public String get()
    {
        return "Web Service is ready.";
    }

    @PostMapping(value = "/valuecar", produces = "application/json")
    public ResponseEntity<Receipt> update(@RequestBody Car car) {
        final int amount = ( car != null && car.getMiles() < 50000 ) ? 8500 : 3000;
        return new ResponseEntity<Receipt>(new Receipt(amount), HttpStatus.OK);
    }

}
