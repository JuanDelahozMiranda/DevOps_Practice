package config.servingwebcontent.controller;

import config.servingwebcontent.pojo.WeatherRoot;
import config.servingwebcontent.ws.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    WeatherService weatherServices = null;

    @Autowired
    WeatherController(WeatherService weatherService) {
        this.weatherServices = weatherService;
    }

    @ApiOperation(value = "Retorna el clima dependiendo de la locación y el país ", response = String.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna los datos del clima JSON en Kelvin por defecto"),})
    @RequestMapping(value = "/findByZipAndCountry/{zip}/{country}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findByZipAndCountry(@ApiParam(value = "Zip of the location", required = true) @PathVariable("zip") String zip,
                                                 @ApiParam(value = "Country of the location", required = true) @PathVariable("country") String country){
        WeatherRoot wea = null;
        if (!zip.isEmpty() &&  !country.isEmpty()) {
            wea = weatherServices.getWeatherBy(zip, country);
            if (wea != null) {
                return new ResponseEntity<>(wea, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontro info", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>("An error has acurred", HttpStatus.BAD_REQUEST);
    }

}
