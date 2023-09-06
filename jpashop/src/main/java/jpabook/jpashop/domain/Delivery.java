package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "ZIPCODE")
    private String zipcode;
    private DeliveryStatus status;
}
