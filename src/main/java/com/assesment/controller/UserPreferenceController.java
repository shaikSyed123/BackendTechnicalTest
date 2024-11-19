package com.assesment.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assesment.model.UserPreference;
import com.assesment.service.UserPreferenceService;

@Controller
@RequestMapping("/api/preferences")
public class UserPreferenceController {

	@Autowired
	private UserPreferenceService service;

	@PostMapping
	public ResponseEntity<String> createUserPreference(@RequestBody UserPreference userPreference) {
		try {
			service.saveUserPreference(userPreference);
			return ResponseEntity.ok("user data saved");
		} catch (Exception e) {
			return ResponseEntity.ok("got error");
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Optional<UserPreference>> getUserPreference(@PathVariable int userId) {
		try {
			Optional<UserPreference> record = service.getUserPreference(userId);

			if (record == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

			return ResponseEntity.ok(record);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserPreference(@PathVariable int userId) {
		try {
			service.deleteUserPreference(userId);
			return ResponseEntity.ok("userId is successfully deleted");
		} catch (Exception e) {
			return ResponseEntity.ok("faild to delete userid");
		}
	}

	@PatchMapping("/{userId}")
	public ResponseEntity<String> updateUserPreference(@PathVariable int userId,@RequestBody UserPreference userPreference) {
		try {
			String frequency=userPreference.getFrequency();
        	String timezome=userPreference.getTimezone();
			service.updateUserPreference(userId, frequency,timezome);
			return ResponseEntity.ok("User preference updated successfully");

		} catch (Exception e) {
			return ResponseEntity.ok("User preference not updated ");
		}
	}
}