package tests;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String email;
    private String name;
    private String gender;

    public static User randomUser() {
        Faker faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        String fakeName = faker.name().firstName();
        User.builder().build();
        return User.builder()
                .email(fakeEmail)
                .name(fakeName)
                .gender("Мужской")
                .build();
    }
}