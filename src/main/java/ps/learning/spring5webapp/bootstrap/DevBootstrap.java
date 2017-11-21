package ps.learning.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ps.learning.spring5webapp.model.Author;
import ps.learning.spring5webapp.model.Book;
import ps.learning.spring5webapp.model.Publisher;
import ps.learning.spring5webapp.repository.AuthorRepository;
import ps.learning.spring5webapp.repository.BookRepository;
import ps.learning.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        Publisher wam = new Publisher("WAM", "al. Jerozolimskie 10, Warsaw, Poland");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(wam);

        authorRepository.save(eric);
        publisherRepository.save(wam);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE development without EJB", "2344");
        Publisher sth = new Publisher("SomeTHing", "Downing st. 99, London, England");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        noEjb.setPublisher(sth);

        authorRepository.save(rod);
        publisherRepository.save(sth);
        bookRepository.save(noEjb);

    }
}
