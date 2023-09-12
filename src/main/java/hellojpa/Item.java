package hellojpa;

import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn
public abstract class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
