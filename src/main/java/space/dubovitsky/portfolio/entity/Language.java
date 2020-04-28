package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import space.dubovitsky.portfolio.model.LanguageLevel;
import space.dubovitsky.portfolio.model.LanguageType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Language extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "language_gen", sequenceName = "language_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_gen")
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;

    @Convert(converter = LanguageLevel.LanguageLevelJpaConverter.class) //! Используем конвертер, т.е. правила сохранения и чтения из/в базы данных
    private LanguageLevel level;

    @Convert(converter = LanguageType.LanguageTypeJpaConverter.class)
    private LanguageType type;

    @ManyToOne(targetEntity = Profile.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile")
    private Profile profile;

    public Language() {
    }
}
