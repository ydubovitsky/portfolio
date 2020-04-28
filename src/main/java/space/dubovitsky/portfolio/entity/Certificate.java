package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "certificate")
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Certificate extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "certificate_gen", sequenceName = "certificate_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_gen")
    private Long id;

    @ManyToOne(targetEntity = Profile.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    private String name;

    @Column(name = "target_url")
    private String targetUrl;

    @Column(name = "small_url")
    private String smallUrl;

    public Certificate() {
    }
}
