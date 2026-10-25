package in.strikes.springAuth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity 
@Getter 
@Setter 
@NoArgsConstructor 
public class Role {

    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (unique=true,nullable =false)
    private String name;

}
