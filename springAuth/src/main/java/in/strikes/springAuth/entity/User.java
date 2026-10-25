package in.strikes.springAuth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Column;

@Entity
@Getter 
@Setter
@NoArgsConstructor 
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(unique=true,nullable =false)
    private String userName;

    @Column(nullable=false)
    private String password;

    private boolean enabled = false;

    @ManyToMany
    @JoinTable(name ="user_roles",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns= @JoinColumn(name="role_id")
    )
    private Set<Role> roles = new HashSet<>();


}
