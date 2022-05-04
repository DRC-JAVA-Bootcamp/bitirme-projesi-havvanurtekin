package com.example.kodluyoruzbitirmewbs.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
public enum UserRole {
    SCRUM_MASTER, PRODUCT_OWNER, TEAM_MEMBER
}
