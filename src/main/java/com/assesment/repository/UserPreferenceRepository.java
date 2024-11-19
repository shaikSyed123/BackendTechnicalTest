package com.assesment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.model.NotificationLog;
import com.assesment.model.UserPreference;
@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Integer>{
	Optional<UserPreference> findByUserId(int userId);
}
