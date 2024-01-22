package oceanarium_project.SpringApplication;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private WlascicielDAO wlascicielDAO;
    @Autowired
    private OceanariumDAO oceanariumDAO;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Adres> listAdres = adresDAO.list();
        model.addAttribute("listAdres",listAdres);

        return "index";
    }

    @RequestMapping("/index_wlasciciel")
    public String viewHomePageWlasciciel(Model model) {
        List<Wlasciciel> listWlasciciel = wlascicielDAO.list();
        model.addAttribute("listWlasciciel",listWlasciciel);

        return "index_wlasciciel";
    }

    @RequestMapping("/index_oceanarium")
    public String viewHomePageOceanarium(Model model) {
        List<Oceanarium> listOceanarium = oceanariumDAO.list();
        model.addAttribute("listOceanarium",listOceanarium);

        return "index_oceanarium";
    }


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
    }
    /////////// ADRES
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



    /////////// WLASCICIEL
    @RequestMapping("/new_wlasciciel")
    public String showNewForm_wlasciciel(Model model) {
        Wlasciciel wlasciciel = new Wlasciciel();
        model.addAttribute("wlasciciel", wlasciciel);
        return "new_form_wlasciciel";
    }

    @RequestMapping(value = "/save_wlasciciel", method = RequestMethod.POST)
    public String save_wlasciciel(@ModelAttribute("wlasciciel") Wlasciciel wlasciciel) {
        wlascicielDAO.save(wlasciciel);

        return "redirect:/index_wlasciciel";
    }

    @RequestMapping("/edit_wlasciciel/{nr_wlasciciela}")
    public ModelAndView showEditForm_wlasciciel(@PathVariable(name = "nr_wlasciciela") int nr_wlasciciela) {
        ModelAndView mav = new ModelAndView("edit_form_wlasciciel");
        Wlasciciel wlasciciel = wlascicielDAO.get(nr_wlasciciela);
        mav.addObject("wlasciciel",wlasciciel);
        return mav;
    }

    @RequestMapping(value = "/update_wlasciciel", method = RequestMethod.POST)
    public String update_wlasciciel(@ModelAttribute("wlasciciel") Wlasciciel wlasciciel) {
        wlascicielDAO.update(wlasciciel);

        return "redirect:/index_wlasciciel";
    }

    @RequestMapping("/delete_wlasciciel/{nr_wlasciciela}")
    public String delete_wlasciciel(@PathVariable(name = "nr_wlasciciela") int nr_wlasciciela) {
        wlascicielDAO.delete(nr_wlasciciela);

        return "redirect:/index_wlasciciel";
    }




    /////////// OCEANARIUM
    @RequestMapping("/new_oceanarium")
    public String showNewForm_oceanarium(Model model) {
        Oceanarium oceanarium = new Oceanarium();
        model.addAttribute("oceanarium", oceanarium);
        return "new_form_oceanarium";
    }

    @RequestMapping(value = "/save_oceanarium", method = RequestMethod.POST)
    public String save_oceanarium(@ModelAttribute("oceanarium") Oceanarium oceanarium) {
        oceanariumDAO.save(oceanarium);

        return "redirect:/index_oceanarium";
    }

    @RequestMapping("/edit_oceanarium/{nr_oceanarium}")
    public ModelAndView showEditForm_oceanarium(@PathVariable(name = "nr_oceanarium") int nr_oceanarium) {
        ModelAndView mav = new ModelAndView("edit_form_oceanarium");
        Oceanarium oceanarium = oceanariumDAO.get(nr_oceanarium);
        mav.addObject("oceanarium",oceanarium);
        return mav;
    }

    @RequestMapping(value = "/update_oceanarium", method = RequestMethod.POST)
    public String update_oceanarium(@ModelAttribute("oceanarium") Oceanarium oceanarium) {
        oceanariumDAO.update(oceanarium);

        return "redirect:/index_oceanarium";
    }

    @RequestMapping("/delete_oceanarium/{nr_oceanarium}")
    public String delete_oceanarium(@PathVariable(name = "nr_oceanarium") int nr_oceanarium) {
        oceanariumDAO.delete(nr_oceanarium);

        return "redirect:/index_oceanarium";
    }

}