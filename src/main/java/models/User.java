package models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String login;
    private String passwordHash;
    private Long id;
}
