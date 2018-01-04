package guru.springframework;

import guru.springframework.controllers.MyController;
import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework.services", "guru.springframework"})
public class DiDemoApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

    MyController controller = (MyController) ctx.getBean("myController");

    FakeDataSource dataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
    System.out.println(dataSource.getName());
    System.out.println(dataSource.getPassword());
    System.out.println(dataSource.getUrl());

    FakeJmsBroker jmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);

    System.out.println(jmsBroker.getName());
    System.out.println(jmsBroker.getPassword());
    System.out.println(jmsBroker.getUrl());
  }
}
