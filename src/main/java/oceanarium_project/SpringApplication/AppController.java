package oceanarium_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Adres adres = new Adres();
        model.addAttribute("adres", adres);
        return "new_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("adres") Adres adres) {
        adresDAO.save(adres);

        return "redirect:/";
    }

    @RequestMapping("/edit/{nr_adresu}")
    public ModelAndView showEditForm(@PathVariable(name = "nr_adresu") int nr_adresu) {
        ModelAndView mav = new ModelAndView("edit_form");
        Adres adres = adresDAO.get(nr_adresu);
        mav.addObject("adres",adres);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("adres") Adres adres) {
        adresDAO.update(adres);

        return "redirect:/";
    }

    @RequestMapping("/delete/{nr_adresu}")
    public String delete(@PathVariable(name = "nr_adresu") int nr_adresu) {
        adresDAO.delete(nr_adresu);

        return "redirect:/";
    }



}