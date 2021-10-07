package com.geekbrains.backend.persist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
