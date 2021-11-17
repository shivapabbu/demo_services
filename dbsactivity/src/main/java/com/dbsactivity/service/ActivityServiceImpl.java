package com.dbsactivity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbsactivity.dto.ActivityDto;
import com.dbsactivity.iservice.IActivityService;
import com.dbsactivity.model.Activity;
import com.dbsactivity.repo.ActivityRepository;

@Service
public class ActivityServiceImpl implements IActivityService{

	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public void addDailyActivity(Activity activity) {
		activityRepository.save(activity);
	}

	@Override
	public Activity viewDailyActivityWithCode(Integer code) {
		return activityRepository.findByCode(code);
	}

	@Override
	public void editDailyActivity(Activity activity) {
		Activity actv = activityRepository.findByCode(activity.getCode());
		if (actv != null) {
			actv.setDate(activity.getDate());
			actv.setDescription(activity.getDescription());
			actv.setCode(activity.getCode());
			actv.setStatus(activity.getStatus());
			activityRepository.save(actv);
		}
	}

	@Override
	public List<ActivityDto> viewDailyActivities(Date fromDate, Date toDate) {
		return null;
	}

	@Override
	public List<ActivityDto> viewDailyActivity(Date date) {
		return null;
	}

	@Override
	public List<ActivityDto> viewDailyActivitieswithCodeAndDateRange(Integer code, Date fromDate, Date toDate) {
		return null;
	}

}
