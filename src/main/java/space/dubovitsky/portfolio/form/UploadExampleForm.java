package space.dubovitsky.portfolio.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class UploadExampleForm {

    private String name;
    private MultipartFile multipartFile;

}
