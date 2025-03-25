package de.hoogvliet.app;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RESTController {

    @GetMapping("/okay")
    @ResponseBody
    public String getAnswer() {
        log.info("Okay reached");
        return "Okay";
    }
}
