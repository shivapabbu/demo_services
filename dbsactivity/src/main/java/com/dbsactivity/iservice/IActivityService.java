package com.dbsactivity.iservice;

import java.util.Date;
import java.util.List;

import com.dbsactivity.dto.ActivityDto;
import com.dbsactivity.model.Activity;

public interface IActivityService {

	public void addDailyActivity(Activity activity);

	public Activity viewDailyActivityWithCode(Integer code);

	public void editDailyActivity(Activity activity);

	public List<ActivityDto> viewDailyActivities(Date fromDate, Date toDate);

	public List<ActivityDto> viewDailyActivity(Date date);

	public List<ActivityDto> viewDailyActivitieswithCodeAndDateRange(Integer code, Date fromDate, Date toDate);

}
