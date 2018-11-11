package demo.discovery.service.generator.uuid.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.discovery.service.generator.uuid.service.UuidGeneratorService;

@Slf4j
@RestController
@RequestMapping(path = "/uuid")
public class UuidGeneratorController {

    @Autowired
    UuidGeneratorService uuidGeneratorService;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateUuid() {
        log.trace("Generating a unique uuid");
        return uuidGeneratorService.generateUuidOutput();
    }
}
