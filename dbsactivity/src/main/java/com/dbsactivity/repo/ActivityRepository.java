package com.dbsactivity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbsactivity.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	Activity findByCode(Integer code);
}
