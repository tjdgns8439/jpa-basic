package jpabook.jpashop.domain;

import lombok.Cleanup;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();
}
