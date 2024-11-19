package com.assesment.service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.model.UserPreference;
import com.assesment.repository.UserPreferenceRepository;

@Service
public class UserPreferenceService {
	 @Autowired
	    private UserPreferenceRepository repository;

	    public UserPreference saveUserPreference(UserPreference userPreference) {
	    	userPreference.setCreatedAt(LocalDate.now());
	        return repository.save(userPreference);
	    }

	    public Optional<UserPreference> getUserPreference(int userId) {
	    	return  repository.findByUserId(userId);
			 
	    }

	    public void deleteUserPreference(int userId) {
	        repository.deleteById(userId);
	    }
	    public void updateUserPreference(int userId, String frequency,String timezome) {
	        // Find the existing user preference by userId
	        Optional<UserPreference> optionalPreference = repository.findById(userId);

	        if (optionalPreference.isPresent()) {
	            UserPreference userPreference = optionalPreference.get();

	            // Iterate over the map and update fields dynamically
	            userPreference.setFrequency(frequency);
	            userPreference.setTimezone(timezome);
	            userPreference.setLastUpdated(LocalDate.now());

	            repository.save(userPreference);
	        } else {
	            throw new IllegalArgumentException("UserPreference with ID " + userId + " not found.");
	        }
	    }
	   
}
