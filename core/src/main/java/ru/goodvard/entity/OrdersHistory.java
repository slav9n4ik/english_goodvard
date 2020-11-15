package ru.goodvard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Timestamp;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "orders_history")
@NoArgsConstructor
public class OrdersHistory {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    private Timestamp orderTime;
    private int orderPrice;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "parent_user_id")
    private ParentUser parentUser;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "order_id")
    private Order order;
}
