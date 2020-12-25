package com.daytick.customannotation.pojos;

import com.daytick.customannotation.annotation.OneOf;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ly
 * @since 2020/12/25 1:46 PM
 */
@Data
@AllArgsConstructor
public class Person {

    private String name;

    @OneOf(strValue = {"男", "女"})
    private String gender;

    @OneOf(intValue = {0, 1})
    private int isChild;
}
