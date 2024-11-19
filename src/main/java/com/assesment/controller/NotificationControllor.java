package com.assesment.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assesment.model.NotificationLog;
import com.assesment.model.UserPreference;
import com.assesment.service.NotificationService;
import com.assesment.service.UserPreferenceService;

@Controller
@RequestMapping("/api/preferences")
public class NotificationControllor {

	@Autowired
	private NotificationService service;

	  @PostMapping("/send/{userId}")
	    public ResponseEntity<String> createNotification(@PathVariable int userId, @RequestBody Map<String, Object> request) {
		  
	        try {
	        	  String metadata = (String) request.get("metadata");
	        	  String subject=(String) request.get("subject");
	        	  String type=(String) request.get("type");
	        	  String channel=(String) request.get("channel");
	        	  String Status=(String) request.get("Status");

	        	  service.createNotification(userId, metadata,subject,type,channel,Status);
	            return ResponseEntity.ok("Notification created successfully.");
	        } catch (RuntimeException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("An error occurred while creating the notification.");
	        }
	    }

	  @GetMapping("/log/{userId}")
		public ResponseEntity<Optional<NotificationLog>> getUserPreference(@PathVariable int userId) {
			try {
				Optional<NotificationLog> record = service.getLogsForUser(userId);

				if (record == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
				}

				return ResponseEntity.ok(record);

			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}
	  
	  @GetMapping("/status")
	  public ResponseEntity<List<NotificationLog>> getstaus(){
		  try {
			List<NotificationLog> records=service.getNotificationStats();
			if (records == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

			return ResponseEntity.ok(records);
		} catch (Exception e) { 
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	  }
	  
	  
}
