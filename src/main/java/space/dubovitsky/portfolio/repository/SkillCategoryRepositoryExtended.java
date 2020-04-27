package space.dubovitsky.portfolio.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.portfolio.entity.SkillCategory;

//@Repository
public interface SkillCategoryRepositoryExtended extends PagingAndSortingRepository<SkillCategory, Long> { //* Второй вариант

}
