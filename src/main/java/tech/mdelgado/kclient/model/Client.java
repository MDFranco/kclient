package tech.mdelgado.kclient.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "client")
public class Client {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String birthDay;
    private String probableDateDeath;
}
