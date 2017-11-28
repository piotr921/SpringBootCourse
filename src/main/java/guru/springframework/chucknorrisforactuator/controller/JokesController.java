package guru.springframework.chucknorrisforactuator.controller;

import guru.springframework.chucknorrisforactuator.service.JokesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

  private JokesServiceImpl jokesService;

  @Autowired
  public JokesController(JokesServiceImpl jokesService) {
    this.jokesService = jokesService;
  }

  @RequestMapping({"/", ""})
  public String jokes(Model model) {
    model.addAttribute("joke", jokesService.getJoke());

    return "chucknorris";
  }
}
