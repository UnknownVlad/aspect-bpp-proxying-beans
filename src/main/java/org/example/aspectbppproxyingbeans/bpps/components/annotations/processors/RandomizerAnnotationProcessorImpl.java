package org.example.aspectbppproxyingbeans.bpps.components.annotations.processors;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers.RandomIgnore;
import org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers.RandomInteger;
import org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers.RandomStringPattern;
import org.example.aspectbppproxyingbeans.bpps.components.annotations.randomizers.Randomizer;
import org.example.aspectbppproxyingbeans.bpps.components.enums.PatternType;
import org.example.aspectbppproxyingbeans.bpps.components.interfaces.RandomGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RandomizerAnnotationProcessorImpl implements RandomizerAnnotationProcessor {

    private final List<String> genders;

    @SneakyThrows
    @Override
    public void process(Object object, Field field) {
        if (field.getAnnotations().length == 0 || field.isAnnotationPresent(RandomIgnore.class))
            return;
        Object value = null;

        if (field.isAnnotationPresent(Randomizer.class)) {
            Randomizer randomizerAnnotation = field.getAnnotation(Randomizer.class);
            Class<? extends RandomGenerator<?>> generatorClass = randomizerAnnotation.generator();
            RandomGenerator<?> generator = generatorClass.getDeclaredConstructor().newInstance();
            value = generator.generateValue();
        } else if (field.isAnnotationPresent(RandomInteger.class)) {
            RandomInteger randomizerAnnotation = field.getAnnotation(RandomInteger.class);
            int max = randomizerAnnotation.max();
            int min = randomizerAnnotation.min();
            value = new Random().nextInt(max - min) + min;
        } else if (field.isAnnotationPresent(RandomStringPattern.class)) {
            RandomStringPattern randomizerAnnotation = field.getAnnotation(RandomStringPattern.class);
            PatternType patternType = randomizerAnnotation.patternType();
            value = processPatternType(patternType);
        }
        this.inject(field, object, value);
    }

    private String processPatternType(PatternType patternType) {
        return switch (patternType) {
            case ID -> UUID.randomUUID().toString();
            case NAME -> "Name";
            case EMAIL -> "generated.%s.email@mail.ru".formatted(UUID.randomUUID());
            case USERNAME -> "Username";
            case PHONE_NUMBER -> "+7(%d)%d-%d-%d"
                        .formatted(
                                (new Random().nextInt(899) + 100),
                                (new Random().nextInt(899) + 100),
                                (new Random().nextInt(89) + 10),
                                (new Random().nextInt(89) + 10)
                        );
            case GENDER -> genders.get(new Random().nextInt(genders.size()));
        };
    }


    private void inject(Field field, Object object, Object value) {
        field.setAccessible(true);
        ReflectionUtils.setField(field, object, value);
    }
}
