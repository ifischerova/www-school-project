package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Data
@Entity
@Table
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column(unique = true)
    private String googleId;
    @Column(unique = true)
    private String facebookId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String city;
    private LocalDate driversLicenseValidUntil;
    @Column(unique = true)
    private String driversLicenseId;
    private Boolean isBlocked;
    private String note;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<RideRequest> rideRequests;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.name()))
            .collect(Collectors.toSet());
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public Long getId() {
        return ID;
    }
}