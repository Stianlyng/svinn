package ntnu.idatt2105.stianlyng.svinn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootTest
@CrossOrigin(origins = "http://dev.stian.localhost:5173")
class SvinnApplicationTests {

	@Test
	void contextLoads() {
	}

}
