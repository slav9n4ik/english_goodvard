package ru.goodvard.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "video_order")
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(name="order-seq-gen", sequenceName="order_seq_gen")
    @GeneratedValue(strategy = SEQUENCE, generator="order-seq-gen")
    private int id;

    private String name;
    private String url;
    private String description;
    private int price;
}
