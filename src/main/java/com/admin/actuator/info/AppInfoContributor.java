package com.admin.actuator.info;
//定制info信息(详细信息) ,输http://localhost:8080/actuator/info就可以查到了
import java.util.Collections;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","gb")
                .withDetails(Collections.singletonMap("key", "value"));

    }

}