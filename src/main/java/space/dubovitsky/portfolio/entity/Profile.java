package space.dubovitsky.portfolio.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import space.dubovitsky.portfolio.entity.embedded.Contacts;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class Profile extends AbstractEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "profile_gen", sequenceName = "profile_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_gen")
    @Column(unique = true, nullable = false)
    private Long id;

    private String uid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDay;

    private String phone; //! phone & email идут как основные контакты, поэтому они не вынесены в отдельную сущность

    private String email;

    private String country;

    private String city;

    private String objective;

    private String summary;

    @Column(name = "target_photo")
    private String targetPhoto;

    @Column(name = "small_photo")
    private String smallPhoto;

    private String info;

    private String password;

    private boolean completed;

    @Column(insertable=false)
    private Timestamp created;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST}) //* Каскадно обновляются и сохраняются данные
    @OrderBy(value = "id desc")
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Course> courses;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Education> educations;

    @OneToMany(mappedBy = "profile", targetEntity = Hobby.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy(value = "name asc")
    private List<Hobby> hobbies;

    @OneToMany(mappedBy = "profile", targetEntity = Practice.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Practice> practices;

    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Skill> skills;

    @Embedded //! Одна таблица profile мапится на две сущности: profile and Contacts
    private Contacts contacts;

    public Profile() {
    }

    @Transient
    public String getFullName() { //!TODO Вынести в сервис какой нибудь или в контроллер
        return firstName + " " + lastName;
    }
}
