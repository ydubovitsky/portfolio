package space.dubovitsky.portfolio.entity.embedded;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
public class Contacts implements Serializable {

    @Column(length = 80)
    private String skype;

    @Column(length = 255)
    private String vkontakte;

    @Column(length = 255)
    private String facebook;

    @Column(length = 255)
    private String linkedin;

    @Column(length = 255)
    private String github;

    @Column(length = 255)
    private String stackoverflow;

    public Contacts() {
        super();
    }
}
