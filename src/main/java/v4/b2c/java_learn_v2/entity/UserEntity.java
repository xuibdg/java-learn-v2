package v4.b2c.java_learn_v2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "m_user", schema = "public")
public class UserEntity {

    @Id
    @Column(name = "user_id", nullable = false, length = 70)
    private String userId;

    @Column(name = "created_by", length = 70)
    private String createdBy;

    @Column(name = "created_at", columnDefinition = "timestamp(6)")
    private LocalDateTime createdAt;

    @Column(name = "is_deleted", columnDefinition = "bpchar(1)")
    private String isDeleted;

    @Column(name = "update_by", length = 70)
    private String updateBy;

    @Column(name = "update_at", columnDefinition = "timestamp(6)")
    private LocalDateTime updateAt;

    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "user_role_id", length = 70)
    private String userRoleId;

    @Column(name = "fullname", length = 100)
    private String fullname;

    @Column(name = "token", length = 225)
    private String token;

    @Column(name = "session_id", length = 225)
    private String sessionId;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

