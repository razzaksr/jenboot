package mera.springmvc6.apply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// using REST crud with JPARepository
// postmapping->create/save, putmapping->update, getmapping->read/list, deletemapping->delete

//@Controller
@RestController//Instead of Mention @responsebody in each method of controller to say those belong to REST, we simply  configure the controller is @RestController
@RequestMapping("/se")
public class SeyavathuController 
{
	/*
	 * @InitBinder public void skip(WebDataBinder web) { web.setDisallowedFields(new
	 * String[] {"bike.bid"}); }
	 */
	@Autowired
	BikeCrud crud;
	
	// this wont work for postman bcoz its not xml also not json
	@RequestMapping("/ikku/{id}")// we could of use @GetMapping
	@ResponseBody//to return string as page content, no help from html/jsp
	public String getOne(@PathVariable("id") int id)
	{
		return crud.findById(id).toString();
	}
	
	@RequestMapping("/ikkujson/{id}")// we could of use @GetMapping
	@ResponseBody//to return string as page content, no help from html/jsp
	public Optional<Bike> getAsJson(@PathVariable("id") int id)
	{
		return crud.findById(id);
	}
	
	//@RequestMapping("/ullai")
	@GetMapping("/ullai")// similar/ same behave as to above annotation, its for read
	@ResponseBody
	public List<Bike> getAll()// output will be json,xml,.. format bcoz jackson-core converts list to json
	{
		return crud.findAll();
	}
	
	@RequestMapping(path="/ullaixml",produces= {"application/xml"})
	@ResponseBody
	public List<Bike> getAllAsXML()// output will be only xml format bcoz jackson-core converts list to json
	{
		return crud.findAll();
	}
	
	// postmapping says post request method for create/ save new row
	@PostMapping(path="/nava",consumes = {"application/json"})// mentioning that client request only as json not all type
	public Bike addNew(@RequestBody Bike bike)
	{
		crud.save(bike);
		return bike;
	}
	
	@PutMapping("/mathuvo")//for update, mentioning that client request only as json not all type
	public Bike navaMathuvo(@RequestBody Bike bike)// save if its new or update existing
	{
		crud.save(bike);
		return bike;
	}
	
	@DeleteMapping("/achavo/{id}")// for delete
	public Bike achavo(@PathVariable("id") int id)
	{
		Bike b=crud.getOne(id);
		Bike c=b;crud.delete(b);
		return c;// im returning c bcoz b is deleted if i return b then its null 
	}
}