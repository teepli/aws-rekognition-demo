package fi.academy.rekognitiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextCredentialsAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;


@SpringBootApplication(exclude = {ContextCredentialsAutoConfiguration.class, ContextStackAutoConfiguration.class})
public class RekognitionDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(RekognitionDemoApplication.class, args);
    }

}
