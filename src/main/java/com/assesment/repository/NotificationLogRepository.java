package com.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.model.NotificationLog;
@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, Integer>{

}
