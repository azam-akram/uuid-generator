package demo.discovery.service.generator.uuid.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import demo.discovery.service.generator.uuid.controller.UuidGeneratorController;
import demo.discovery.service.generator.uuid.service.UuidGeneratorService;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UuidGeneratorController.class)
public class UuidGeneratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UuidGeneratorService uuidGeneratorService;

    @Test
    public void generateUuid_ShouldReturnGeneratedUuid() throws Exception {

        String uuid = UUID.randomUUID().toString();
        String expectedOutput = "prefix-" + uuid + "-postfix";

        given(uuidGeneratorService.generateUuidOutput()).willReturn(expectedOutput);

        this.mockMvc.perform(get("/uuid/"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(content().string(expectedOutput));
    }
}
