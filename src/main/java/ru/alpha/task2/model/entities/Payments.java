package ru.alpha.task2.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Payments {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref")
    private String  ref;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "recipient_id")
    private String recipientId;

    @Column(name = "description")
    private String desc;

    @Column(name = "amount")
    private Double amount;
}
