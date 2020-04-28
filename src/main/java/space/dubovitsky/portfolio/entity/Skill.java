package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="skill")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Skill extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "SKILL_ID_GENERATOR", sequenceName = "skill_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, length = 2147483647)
    private String value;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_profile", nullable=false)
    private Profile profile;

    public Skill() {
    }
}
