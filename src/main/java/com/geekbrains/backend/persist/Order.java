package com.geekbrains.backend.persist;

import com.geekbrains.backend.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "user_uuid", foreignKey = @ForeignKey(name = "fk_order_user_user_uuid"))
    private User user;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

}
