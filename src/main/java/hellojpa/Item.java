package hellojpa;

import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
