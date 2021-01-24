package local.vagabond.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsulApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootConsulApplication.class);

    final
    UserProperties userProperties;

    public SpringBootConsulApplication(UserProperties userProperties) {
        this.userProperties = userProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsulApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info(String.format("foo property value: '%1$s'", userProperties.getFoo()));
    }
}
