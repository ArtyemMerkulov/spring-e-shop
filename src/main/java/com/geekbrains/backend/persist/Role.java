package com.geekbrains.backend.persist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> user;

}
