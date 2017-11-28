package guru.springframework.chucknorrisforactuator.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesServiceImpl implements JokesService{

    private final ChuckNorrisQuotes norrisQuotes;

    public JokesServiceImpl() {
        this.norrisQuotes = new ChuckNorrisQuotes();
    }

    public String getJoke() {
        return norrisQuotes.getRandomQuote();
    }
}
