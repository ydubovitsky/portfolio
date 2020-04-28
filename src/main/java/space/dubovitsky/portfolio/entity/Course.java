package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Course extends AbstractFinishDate<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;

    private String school;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Profile.class)
    @JoinColumn(name = "id_profile")
    private Profile profile;

    public Course() {
    }
}
