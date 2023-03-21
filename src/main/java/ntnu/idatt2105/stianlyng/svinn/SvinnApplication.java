package ntnu.idatt2105.stianlyng.svinn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ntnu.idatt2105.stianlyng.svinn")
public class SvinnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvinnApplication.class, args);
    }

}




