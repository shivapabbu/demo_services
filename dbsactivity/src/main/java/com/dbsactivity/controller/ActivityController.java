package com.dbsactivity.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbsactivity.dto.ActivityDto;
import com.dbsactivity.model.Activity;
import com.dbsactivity.service.ActivityServiceImpl;

@RestController
public class ActivityController {

	@Autowired
	private ActivityServiceImpl activityService;

	@Autowired
	private ModelMapper modelMapper;

	public void setActivityService(ActivityServiceImpl activityService) {
		this.activityService = activityService;
	}

	@PostMapping("/api/dailyactivity/add")
	public ResponseEntity<String> addDailyActivity(@Valid @RequestBody ActivityDto activitydto) {
		Activity activity = activityService.viewDailyActivityWithCode(activitydto.getCode());
		if (ObjectUtils.isEmpty(activity)) {
			Activity activityMapper = modelMapper.map(activitydto, Activity.class);
			activityService.addDailyActivity(activityMapper);
		} else {
			return new ResponseEntity<>("Acitivity with employee code " + activitydto.getCode() + " already exists",
					HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Activity Details Added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/api/employee/{code}")
	public ResponseEntity<Activity> viewDailyActivityWithCode(@PathVariable(name = "code") Integer code) {
		Activity activity = activityService.viewDailyActivityWithCode(code);
		if (ObjectUtils.isEmpty(activity)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(activity, HttpStatus.OK);
	}

	/*
	 * viewDailyActivityWithCode editDailyActivity viewDailyActivities
	 * viewDailyActivity viewDailyActivitiesWithCodeAndDateRange
	 */

}
