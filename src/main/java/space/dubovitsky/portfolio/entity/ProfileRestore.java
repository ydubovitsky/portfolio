package space.dubovitsky.portfolio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profile_restore")
@Getter @Setter
public class ProfileRestore extends AbstractEntity<Long> implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false) //! без optional = false, не будет работать fetch = FetchType.LAZY
    @JoinColumn(name = "id", nullable = false)
    private Profile profile;

    @Column(nullable = false, unique = true, length = 100)
    private String token;

    public ProfileRestore() {
    }
}
