package com.assesment.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class UserPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private boolean marketing;
	@Column(nullable = false)
    private boolean newsletter;
	@Column(nullable = false)
    private boolean updates;
	@Column(nullable = false)
    private String frequency;
    private boolean emailChannel;
    private boolean smsChannel;
    private boolean pushChannel;
    private String timezone;
    private LocalDate lastUpdated;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "userPreference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NotificationLog> notificationLogs;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMarketing() {
        return marketing;
    }

    public void setMarketing(boolean marketing) {
        this.marketing = marketing;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isUpdates() {
        return updates;
    }

    public void setUpdates(boolean updates) {
        this.updates = updates;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(boolean emailChannel) {
        this.emailChannel = emailChannel;
    }

    public boolean isSmsChannel() {
        return smsChannel;
    }

    public void setSmsChannel(boolean smsChannel) {
        this.smsChannel = smsChannel;
    }

    public boolean isPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(boolean pushChannel) {
        this.pushChannel = pushChannel;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<NotificationLog> getNotificationLogs() {
        return notificationLogs;
    }

    public void setNotificationLogs(List<NotificationLog> notificationLogs) {
        this.notificationLogs = notificationLogs;
    }
    public enum Frequency {
        DAILY, WEEKLY, MONTHLY, NEVER
    }
}
