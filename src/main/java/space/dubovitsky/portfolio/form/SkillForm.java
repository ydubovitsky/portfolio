package space.dubovitsky.portfolio.form;

import lombok.Getter;
import lombok.Setter;
import space.dubovitsky.portfolio.entity.Skill;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с формой Skills
 */
@Getter @Setter
public class SkillForm implements Serializable {

    private List<Skill> items = new ArrayList<>();

    public SkillForm() {
        super();
    }

    public SkillForm(List<Skill> items) {
        super();
        this.items = items;
    }
}
