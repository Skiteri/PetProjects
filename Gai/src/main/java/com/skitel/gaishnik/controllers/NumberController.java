package com.skitel.gaishnik.controllers;

import com.skitel.gaishnik.Number;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NumberController {

    private final Number current;

    public NumberController(Number current) {
        this.current = current;
    }


    @RequestMapping(value = "/times", method = RequestMethod.GET)
    public ResponseEntity<String> next2Times() {
        HttpHeaders httpHeaders = new HttpHeaders();
        current.next();
        current.next();
        httpHeaders.add("Content-type", "text/html;charset=UTF-8");
        return new ResponseEntity<>(current.toString(), httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/next2", method = RequestMethod.GET)
    public ResponseEntity<String> next() {
        HttpHeaders h = new HttpHeaders();
        current.next();
        h.add("Content-type", "text/html;charset=UTF-8");
        return new ResponseEntity<>(current.toString(), h, HttpStatus.OK);
    }

    @RequestMapping(value = "/random2", method = RequestMethod.GET)
    public ResponseEntity<String> random() {
        HttpHeaders h = new HttpHeaders();
        h.add("Content-type", "text/html;charset=UTF-8");
        current.random();
        return new ResponseEntity<>(current.toString(), h, HttpStatus.OK);
    }
}

