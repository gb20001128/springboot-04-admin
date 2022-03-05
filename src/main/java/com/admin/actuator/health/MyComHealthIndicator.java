package com.admin.actuator.health;
//定制 Health 信息 (输 http://localhost:8080/actuator/health就可以查到里面多加了个MyCom的组件的健康信息)
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    /*真实的检查方法*/
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //获取连接进行测试
        Map<String,Object> map = new HashMap<>();
        // 检查完成
        if(1 == 1){
            builder.status(Status.UP);//健康
            map.put("count",1);
            map.put("ms",100);
        }else {
            builder.status(Status.OUT_OF_SERVICE);//不健康
            map.put("err","连接超时");
            map.put("ms",3000);
        }


        builder.withDetail("code",100) //health信息带些详细信息
                .withDetails(map);

    }
}