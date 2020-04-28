package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Practice extends AbstractFinishDate<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "practice_gen", sequenceName = "practice_seq", allocationSize = 1)
    @GeneratedValue(generator = "practice_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String company;

    @Column(length = 255)
    private String demo;

    @Column(length = 255)
    private String src;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(nullable = false, length = 2147483647)
    private String responsibilities;

    @Column(name = "begin_date", nullable = false)
    private Date beginDate;

    // bi-directional many-to-one association to Profile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    public Practice() {
    }

}
