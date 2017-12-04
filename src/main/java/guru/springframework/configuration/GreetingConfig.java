package guru.springframework.configuration;

import guru.springframework.services.GreetingRepository;
import guru.springframework.services.GreetingService;
import guru.springframework.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfig {

  @Bean
  GreetingServiceFactory greetingServiceFactory(GreetingRepository repository) {
    return new GreetingServiceFactory(repository);
  }

  @Bean
  @Primary
  @Profile({"default", "en"})
  GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
    return greetingServiceFactory.createGreetingService("en");
  }

  @Bean
  @Primary
  @Profile({"default", "en"})
  GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
    return greetingServiceFactory.createGreetingService("es");
  }

  @Bean
  @Primary
  @Profile({"default", "en"})
  GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
    return greetingServiceFactory.createGreetingService("de");
  }
}