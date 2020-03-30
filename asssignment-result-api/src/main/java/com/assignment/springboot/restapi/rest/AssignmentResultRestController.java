package com.assignment.springboot.restapi.rest;

import java.util.List;

import com.assignment.springboot.restapi.entity.AssignmentResult;
import com.assignment.springboot.restapi.entity.TeamTask;
import com.assignment.springboot.restapi.service.ITaskAssignmentResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AssignmentResultRestController {

	private ITaskAssignmentResultService assignmentResultService;
	
	@Autowired
	public AssignmentResultRestController(ITaskAssignmentResultService theassignmentResultService) {
		assignmentResultService = theassignmentResultService;
	}

	@GetMapping("/")
	public String getIndexPage() {
		return "This is index page";
	}
	
	// expose "/assignmentResults" and return list of assignmentResults
	@GetMapping("/assignmentResult")
	public List<AssignmentResult> findAll() {
		return assignmentResultService.findAll();
	}

	// add mapping for GET /assignmentResults/{assignmentResultId}
	
	@GetMapping("/assignmentResults/{assignmentResultId}")
	public AssignmentResult getassignmentResult(@PathVariable int assignmentResultId) {
		
		AssignmentResult theassignmentResult = assignmentResultService.findById(assignmentResultId);
		
		if (theassignmentResult == null) {
			throw new RuntimeException("assignmentResult id not found - " + assignmentResultId);
		}
		
		return theassignmentResult;
	}
	
	// add mapping for POST /assignmentResults - add new assignmentResult
	
	@PostMapping("/assignmentResults")
	public AssignmentResult addassignmentResult(@RequestBody AssignmentResult theassignmentResult) {
		assignmentResultService.save(theassignmentResult);
		
		return theassignmentResult;
	}
	
	// add mapping for PUT /assignmentResults - update existing assignmentResult
	
	@PutMapping("/assignmentResults")
	public AssignmentResult updateassignmentResult(@RequestBody AssignmentResult theassignmentResult) {
		
		assignmentResultService.save(theassignmentResult);
		
		return theassignmentResult;
	}
	
	// add mapping for DELETE /assignmentResults/{assignmentResultId} - delete assignmentResult
	
	@DeleteMapping("/assignmentResults/{assignmentResultId}")
	public String deleteassignmentResult(@PathVariable int assignmentResultId) {
		
		AssignmentResult tempassignmentResult = assignmentResultService.findById(assignmentResultId);
		
		// throw exception if null
		
		if (tempassignmentResult == null) {
			throw new RuntimeException("assignmentResult id not found - " + assignmentResultId);
		}
		
		assignmentResultService.deleteById(assignmentResultId);
		
		return "Deleted assignmentResult id - " + assignmentResultId;
	}
	
}










