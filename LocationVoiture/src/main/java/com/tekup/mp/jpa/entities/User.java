package com.tekup.mp.jpa.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.tekup.mp.jpa.enums.RoleEnum;
import com.tekup.mp.tools.BCryptManagerTool;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

	
@Entity
@Table(name = "users")
public class User implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id_user")
private Long idUser;
@NotNull
@Column(name = "username", nullable = false, unique = true)
private String username;
@NotNull
@Column(name = "password", nullable = false)
private String password;
@NotNull
@Column(name = "firstname", nullable = false)
private String firstname;
@NotNull
@Column(name = "lastname", nullable = false)
private String lastname;
@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
@Cascade(value = CascadeType.REMOVE)
@JoinTable(
indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "id_user")},
name = "roles",
joinColumns = @JoinColumn(name = "id_user")
)
@Column(name = "role", nullable = false)
@Enumerated(EnumType.STRING)
private Collection<RoleEnum> roles;
@Column(name = "account_non_expired")
private boolean accountNonExpired;
@Column(name = "account_non_locked")
private boolean accountNonLocked;
@Column(name = "credentials_non_expired")
private boolean credentialsNonExpired;
@Column(name = "enabled")
private boolean enabled;

public User() {
	this.accountNonExpired = true;
	this.accountNonLocked = true;
	this.credentialsNonExpired = true;
	this.enabled = true;
	this.roles = Collections.singletonList(RoleEnum.AGENT);
}
public User(String username, String password, String firstname, String lastname, Collection<RoleEnum> roles) {
	this.username = username;
	this.password = BCryptManagerTool.passwordencoder().encode(password);
	this.firstname = firstname;
	this.lastname = lastname;
	this.accountNonExpired = true;
	this.accountNonLocked = true;
	this.credentialsNonExpired = true;
	this.enabled = true;
	this.roles = roles;
}

public Long getIdUser() {
	return idUser;
}
public void setIdUser(Long idUser) {
	this.idUser = idUser;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public Collection<RoleEnum> getRoles() {
	return roles;
}
public void setRoles(Collection<RoleEnum> roles) {
	this.roles = roles;
}
public boolean isAccountNonExpired() {
	return accountNonExpired;
}
public void setAccountNonExpired(boolean accountNonExpired) {
	this.accountNonExpired = accountNonExpired;
}
public boolean isAccountNonLocked() {
	return accountNonLocked;
}
public void setAccountNonLocked(boolean accountNonLocked) {
	this.accountNonLocked = accountNonLocked;
}
public boolean isCredentialsNonExpired() {
	return credentialsNonExpired;
}
public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	this.credentialsNonExpired = credentialsNonExpired;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public String getPassword() {
	return password;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	String roles =StringUtils.collectionToCommaDelimitedString(getRoles().stream().map(Enum::name).collect(Collectors.toList()));
	return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
}

public void setPassword(String password) {
	if (!password.isEmpty()) {
		this.password = BCryptManagerTool.passwordencoder().encode(password);
}
}
}
