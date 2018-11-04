package test.tantalum.generator.uuid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGeneratorService {

    // Prefix and postfix are configurable

    @Value("${application.uuid.prefix}")
    private String uuidPrefix;

    @Value("${application.uuid.postfix}")
    private String uuidPostfix;

    public String generateUuidOutput() {
        return uuidPrefix + "-" + UUID.randomUUID().toString() + "-" + uuidPostfix;
    }
}