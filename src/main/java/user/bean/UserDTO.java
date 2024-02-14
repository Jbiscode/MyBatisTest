package user.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@Data
@Builder
@Setter
@Getter
public class UserDTO {
    private String name;
    private String id;
    private String pwd;
}
