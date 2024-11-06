package com.ecommerce.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer role_id;

    public Role(AppRole appRole) {
        this.appRole = appRole;
    }

    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(length = 20, name="role_name")
    private AppRole appRole;
}
