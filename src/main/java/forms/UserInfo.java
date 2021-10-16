package forms;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
