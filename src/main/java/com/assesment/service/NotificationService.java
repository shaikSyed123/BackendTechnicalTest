package com.assesment.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.model.NotificationLog;
import com.assesment.model.UserPreference;
import com.assesment.repository.NotificationLogRepository;
import com.assesment.repository.UserPreferenceRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationLogRepository repository;
    
    @Autowired
    private UserPreferenceRepository Userrepository;


    public void createNotification(int userId, String metadata,String subject,String type,String channel,String Status) {
        UserPreference userPreference = Userrepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(userPreference!=null) {
        NotificationLog log = new NotificationLog();
        log.setUserPreference(userPreference);
        log.setType(type);
        log.setChannel(channel);
        log.setStatus(Status);
        log.setSentAt(new Date());
        log.setMetadata(metadata);
        log.setSubject(subject);

        repository.save(log);
        }
    }

    public Optional<NotificationLog> getLogsForUser(int userId) {
        return repository.findById(userId);
    }
    
    public List<NotificationLog> getNotificationStats() {
        return repository.findAll();
    }
}