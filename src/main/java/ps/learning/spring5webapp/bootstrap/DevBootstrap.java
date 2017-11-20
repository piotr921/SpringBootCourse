package ps.learning.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ps.learning.spring5webapp.model.Author;
import ps.learning.spring5webapp.model.Book;
import ps.learning.spring5webapp.repository.AuthorRepository;
import ps.learning.spring5webapp.repository.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE development without EJB", "2344", "Worx");
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);

    }
}
