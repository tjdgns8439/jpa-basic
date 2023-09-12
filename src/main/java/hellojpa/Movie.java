package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Getter
@Setter
@Entity
public class Movie extends Item{
    private String director;
    private String actor;
}
