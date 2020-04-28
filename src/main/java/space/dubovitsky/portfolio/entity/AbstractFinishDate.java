package space.dubovitsky.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.sql.Date;

@MappedSuperclass //! Аннотация @MappedSuperclass позволяет включать класс и его jpa аннотации в производный класс, не делая базовый класс сущностью. https://easyjava.ru/data/jpa/nasledovanie-v-jpa/
public abstract class AbstractFinishDate<T> extends AbstractEntity<T> {

    @Column(name = "finish_date")
    private Date finishDate;

    @Transient
    private Integer finishDateMonth;

    @Transient
    private Integer finishDateYear;

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Transient //! Это поле нужно для работы внутри приложения, но НЕ для хранения в БД
    public Integer getFinishDateMonth() {
        return finishDateMonth;
    }

    public void setFinishDateMonth(Integer finishDateMonth) {
        this.finishDateMonth = finishDateMonth;
        setFinishDate();
    }

    @Transient
    public Integer getFinishDateYear() {
        return finishDateYear;
    }

    public void setFinishDateYear(Integer finishDateYear) {
        this.finishDateYear = finishDateYear;
        setFinishDate();
    }

    /**
     * Получаем дату окончания на основе месяца и года
     */
    public void setFinishDate() {
        if (finishDateMonth != null && finishDateYear != null) {
            finishDate = new Date(finishDateYear, finishDateMonth, 0); //? Заменить на календарь
        } else {
            finishDate = null;
        }
    }

}
