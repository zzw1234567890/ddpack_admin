package top.amazing.ddpack_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("top.amazing.ddpack_admin.dao")
@ComponentScan({"zzw.util.fileupload","top.amazing.ddpack_admin"})
public class DdpackAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdpackAdminApplication.class, args);
    }

}
