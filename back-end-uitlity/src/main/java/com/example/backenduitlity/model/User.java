package com.example.backenduitlity.model;

import com.example.backenduitlity.domain.Authority;
import com.example.backenduitlity.domain.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    private String name;
    private String username;
    private String password;
    private int is_stakeholder_user;
    private int stakeholder_id;
    private String created_by;
    @Temporal(TemporalType.DATE)
    private Date created_time;
    private String updatedBy;
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    private int status;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole>  userRoles = new HashSet<>();

    public User() {

    }

    public User(String email, String name, String username, String password, int is_stakeholder_user, int stakeholder_id, String created_by, Date created_time, String updatedBy, Date updatedDate, int status, Set<UserRole> userRoles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.is_stakeholder_user = is_stakeholder_user;
        this.stakeholder_id = stakeholder_id;
        this.created_by = created_by;
        this.created_time = created_time;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.status = status;
        this.userRoles = userRoles;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIs_stakeholder_user() {
        return is_stakeholder_user;
    }

    public void setIs_stakeholder_user(int is_stakeholder_user) {
        this.is_stakeholder_user = is_stakeholder_user;
    }

    public int getStakeholder_id() {
        return stakeholder_id;
    }

    public void setStakeholder_id(int stakeholder_id) {
        this.stakeholder_id = stakeholder_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorites = new HashSet<>();
        userRoles.forEach(ur -> authorites.add(new Authority(ur.getRole().getTitle())));
        return authorites;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
