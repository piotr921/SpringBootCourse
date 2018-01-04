package guru.springframework.configuration;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

  @Value("${guru.username}")
  String user;

  @Value("${guru.password}")
  String password;

  @Value("${guru.dburl}")
  String url;

  @Value("${guru.jms.username}")
  String jmsUser;

  @Value("${guru.jms.password}")
  String jmsPassword;

  @Value("${guru.jms.dburl}")
  String jmsUrl;

  @Bean
  public FakeDataSource fakeDataSource() {
    FakeDataSource dataSource = new FakeDataSource();
    dataSource.setName(user);
    dataSource.setPassword(password);
    dataSource.setUrl(url);

    return dataSource;
  }

  @Bean
  public FakeJmsBroker fakeJmsBroker() {
    FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
    fakeJmsBroker.setName(jmsUser);
    fakeJmsBroker.setPassword(jmsPassword);
    fakeJmsBroker.setUrl(jmsUrl);

    return fakeJmsBroker;
  }
}
