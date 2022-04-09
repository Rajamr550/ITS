package com.olx.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Adv;
import com.olx.service.AdvService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/advertise")
@CrossOrigin(origins = "*")

public class AdvController {
    @Autowired
    AdvService advService;

    // 8
    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public Adv postAdvertise(Adv adv) {
	return advService.postAdvertise(adv);
    }

    // 9

    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
		    MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public Adv updateAdvertise(Adv adv) {
	return advService.updateAdvertise(adv);

    }

    // 10 Reads all advertisements posted by logged in user
    @GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public List<Adv> getAllAdvByUser() {
	return null;
    }

    // 11 Reads specific advertisement posed by logged in user
    @GetMapping(value = "/user/advertise/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public List<Adv> getAdvByUser(@PathVariable("id") String uname) {
	return null;
    }

    // 12 Deletes specific advertisement posted by logged in user

    @DeleteMapping(value = "/user/advertise/{id}")
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public boolean deleteAdvByUserId() {
	return false;
    }
    // 13

    @GetMapping(value = "/search/filtercriteria", produces = { MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public List<Adv> searchAdvertisesByFilterCriteria(@RequestParam("searchText") String searchText,
	    @RequestParam(name = "category", required = false) int categoryId,
	    @RequestParam("postedBy") String postedBy, @RequestParam("dateCondition") String dateCondition,
	    @RequestParam("onDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate onDate,
	    @RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
	    @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
	    @RequestParam("sortedBy") String sortedBy,
	    @RequestParam(name = "startIndex", defaultValue = "0") int startIndex,
	    @RequestParam(name = "records", defaultValue = "10") int records) {
	return advService.searchAdvertisesByFilterCriteria(searchText, categoryId, postedBy, dateCondition, onDate,
		fromDate, toDate, sortedBy, startIndex, records);
    }

    // 14 Matches advertisements using the peovided
    // 'searchText' within all fields of an advertise.
    @GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public Adv SearchAdvByText(@RequestParam("searchText") String searchText) {
	return advService.SearchAdvByText(searchText);
    }

    // 15 Return advertise details

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Reads specific stock", notes = "This REST API returns list the stock of given id")

    public Adv returnAdv(int id) {
	return advService.returnAdv(id);
    }

}