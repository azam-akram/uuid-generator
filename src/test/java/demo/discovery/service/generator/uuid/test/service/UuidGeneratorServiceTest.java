package demo.discovery.service.generator.uuid.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;
import demo.discovery.service.generator.uuid.service.UuidGeneratorService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class UuidGeneratorServiceTest {

    private UuidGeneratorService uuidGeneratorService;

    @Before
    public void setup() {
        this.uuidGeneratorService = new UuidGeneratorService();
    }

    @Test
    public void getUUID_shouldReturnGeneratedUuid() {
        String generatedUuid = uuidGeneratorService.generateUuidOutput();
        assertThat(generatedUuid).isNotNull();
        assertThat(StringUtils.startsWithIgnoreCase(generatedUuid, "prefix-"));
        assertThat(StringUtils.endsWithIgnoreCase(generatedUuid, "-postfix"));
    }
}
