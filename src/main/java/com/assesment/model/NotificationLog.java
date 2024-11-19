package com.assesment.model;

import java.util.Date;
import java.util.Map;

import com.assesment.configur.MetadataConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
@Entity
public class NotificationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
	@Column(nullable = false)
    private String type;
	@Column(nullable = false)
    private String channel;
	@Column(nullable = false)
    private String status;
	@Column(nullable = false)
    private Date sentAt;
    private String failureReason;
    private String metadata;
    @Column(nullable = false)
    private String subject;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) 
    @JsonIgnore
    private UserPreference userPreference;

    @Transient
    private Integer userId;

    public Integer getUserId() {
        return userPreference != null ? userPreference.getUserId() : null;
    }
    
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public UserPreference getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

}