package space.dubovitsky.portfolio.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.RepositoryDefinition;
import space.dubovitsky.portfolio.entity.SkillCategory;

import java.util.List;

@RepositoryDefinition(domainClass = SkillCategory.class, idClass = Long.class)
public interface SkillCategoryRepository { //* Первый вариант

    List<SkillCategory> findAll(Sort sort);

}
