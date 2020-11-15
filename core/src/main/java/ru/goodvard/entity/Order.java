package ru.goodvard.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "video_order")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    private String name;
    private String url;
    private String description;
    private int price;
}
