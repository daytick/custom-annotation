package com.daytick.customannotation.controller;

import com.daytick.customannotation.pojos.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ly
 * @since 2020/12/25 1:44 PM
 */
@RestController
public class AnnotationTestController {

    @PostMapping("/test/annotation")
    public Person test(@RequestBody @Valid Person person) {
        return person;
    }
}
