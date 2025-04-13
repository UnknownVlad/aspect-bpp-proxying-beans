package org.example.aspectbppproxyingbeans.bpps.pojos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers.RandomInteger;
import org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers.RandomStringPattern;
import org.example.aspectbppproxyingbeans.bpps.components.enums.PatternType;


@Getter
@Setter
@Data
@NoArgsConstructor
public class UserPojo {
    @RandomStringPattern(patternType = PatternType.PHONE_NUMBER)
    String phoneNumber;

    @RandomStringPattern(patternType = PatternType.NAME)
    String name;

    @RandomStringPattern(patternType = PatternType.USERNAME)
    String username;

    @RandomStringPattern(patternType = PatternType.GENDER)
    String gender;

    @RandomInteger(max = 30, min = 18)
    Integer age;

    @RandomStringPattern(patternType = PatternType.ID)
    String id;

    @RandomStringPattern(patternType = PatternType.EMAIL)
    String email;
}
