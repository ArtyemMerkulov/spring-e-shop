package com.geekbrains.backend.persist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uuid;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_category_id"))
    private Category category;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "description")
    private String description;

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "created_by_user_uuid", foreignKey = @ForeignKey(name = "fk_user_uuid"))
    private User createByUser;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

}
