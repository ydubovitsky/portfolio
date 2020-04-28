package space.dubovitsky.portfolio.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="skill_category")
@Getter
@Setter
public class SkillCategory extends AbstractEntity<Long> implements Serializable {

    @Id
    @Column
    private Long id;

    @Column(nullable=false, length=50)
    private String category;

}