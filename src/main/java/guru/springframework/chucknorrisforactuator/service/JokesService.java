package guru.springframework.chucknorrisforactuator.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesService {

    private ChuckNorrisQuotes norrisQuotes = new ChuckNorrisQuotes();

    public String getJoke() {
        return norrisQuotes.getRandomQuote();
    }
}
