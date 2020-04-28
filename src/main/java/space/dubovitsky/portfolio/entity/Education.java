package space.dubovitsky.portfolio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
public class Education extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "education_gen", sequenceName = "education_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_gen")
    private Long id;

    private String summary;

    @Column(name = "begin_year")
    private int beginYear;

    @Column(name = "finish_year")
    private int finishYear;

    private String university;

    private String faculty;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    public Education() {
    }
}
