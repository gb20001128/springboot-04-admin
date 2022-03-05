package com.admin.actuator.endpoint;
//自定制的端点(输http://localhost:8080/actuator/container就可以查到)
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "container") //端点名
public class MyServiceEndpoint {


    @ReadOperation //写操作
    public Map getDockerInfo(){
        return Collections.singletonMap("info","docker started...");
    }

    @WriteOperation //读操作
    private void restartDocker(){
        System.out.println("docker restarted....");
    }

}
