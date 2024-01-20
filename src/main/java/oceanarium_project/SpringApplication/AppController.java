package oceanarium_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//@Configuration
@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private AdresDAO adresDAO;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Adres> listAdres = adresDAO.list();
        model.addAttribute("listAdres",listAdres);
        return "index";
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
    }
/*
    @RequestMapping("/new")
    public String showNewForm(Model model) {

    }

 */

}