package com.giuseppefrattura.spring6webapp.controllers;


import com.giuseppefrattura.spring6webapp.domain.BeerDTO;
import com.giuseppefrattura.spring6webapp.services.BeerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BeerController {

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";
    private final BeerService beerService;
    private final Timer responseTimer;

    public BeerController(MeterRegistry registry, BeerService beerService) {
        this.responseTimer = registry.timer("http_request_duration_seconds");
        this.beerService = beerService;
    }

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

        beerService.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

        if (!beerService.deleteById(beerId)){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

        if (beerService.updateBeerById(beerId, beer).isEmpty()){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity handlePost(@RequestBody BeerDTO beer){
        return responseTimer.record(() -> {
            BeerDTO savedBeer = beerService.saveNewBeer(beer);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

            return new ResponseEntity(headers, HttpStatus.CREATED);
        });
    }

    @GetMapping(value = BEER_PATH)
    public List<BeerDTO> listBeers(){
        return responseTimer.record(() -> {
            log.debug("Get all Beers");
            return beerService.listBeers();
        });
    }

    @GetMapping(value = BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }



}