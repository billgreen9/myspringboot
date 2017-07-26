package com.person.myspringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"bean.xml"})
public class GlobalConfig {

}
