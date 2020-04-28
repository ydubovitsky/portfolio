package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="hobby")
@Getter @Setter
@EqualsAndHashCode(exclude = {"profile"}, callSuper = true)
public class Hobby extends AbstractEntity<Long> implements Serializable, Comparable<Hobby> {

    @Id
    @SequenceGenerator(name = "hobby_gen", allocationSize = 1, sequenceName = "hobby_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hobby_gen")
    private Long id;

    private String name;

    @ManyToOne(targetEntity = Profile.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @Transient //! Эти поля (@Transient) используется не для хранения данных, а еще и для отображений на jsp
    public boolean selected;

    public Hobby() {
    }

    @Override
    public int compareTo(Hobby o) { //! Для сортировки Хобби
        if (o == null || getName() == null) {
            return 1;
        } else {
            return getName().compareTo(o.getName());
        }
    }
}
