package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Helper;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;
}
