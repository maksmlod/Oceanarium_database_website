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
    @Autowired
    private PracownikDAO pracownikDAO;
    @Autowired
    private KlientDAO klientDAO;

    @RequestMapping("/index_adres")
    public String viewHomePage(Model model) {
        List<Adres> listAdres = adresDAO.list();
        model.addAttribute("listAdres",listAdres);

        return "index_adres";
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

    @RequestMapping("/index_pracownik")
    public String viewHomePagePracownik(Model model) {
        List<Pracownik> listPracownik = pracownikDAO.list();
        model.addAttribute("listPracownik",listPracownik);

        return "index_pracownik";
    }

    @RequestMapping("/index_klient")
    public String viewHomePageKlient(Model model) {
        List<Klient> listKlient = klientDAO.list();
        model.addAttribute("listKlient",listKlient);

        return "index_klient";
    }

    @RequestMapping("/index_klient_specified")
    public String viewHomePageKlient2(Model model) {
        List<Klient> listKlient = klientDAO.list2();
        model.addAttribute("listKlient",listKlient);

        return "index_klient_specified";
    }


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");


        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");

    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if(request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if(request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else {
                return "redirect:/index";
            }
        }
    }
    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
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

        return "redirect:/index_adres";
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

        return "redirect:/index_adres";
    }

    @RequestMapping("/delete/{nr_adresu}")
    public String delete(@PathVariable(name = "nr_adresu") int nr_adresu) {
        adresDAO.delete(nr_adresu);

        return "redirect:/index_adres";
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








    ///////////Pracownik
    @RequestMapping("/new_pracownik")
    public String showNewForm_pracownik(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);
        return "new_form_pracownik";
    }

    @RequestMapping(value = "/save_pracownik", method = RequestMethod.POST)
    public String save_pracownik(@ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikDAO.save(pracownik);

        return "redirect:/index_pracownik";
    }

    @RequestMapping("/edit_pracownik/{nr_pracownika}")
    public ModelAndView showEditForm_pracownik(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
        ModelAndView mav = new ModelAndView("edit_form_pracownik");
        Pracownik pracownik = pracownikDAO.get(nr_pracownika);
        mav.addObject("pracownik", pracownik);
        return mav;
    }

    @RequestMapping(value = "/update_pracownik", method = RequestMethod.POST)
    public String update_pracownik(@ModelAttribute("pracownik") Pracownik pracownik) {
        pracownikDAO.update(pracownik);

        return "redirect:/index_pracownik";
    }

    @RequestMapping("/delete_pracownik/{nr_pracownika}")
    public String delete_pracownik(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
        pracownikDAO.delete(nr_pracownika);

        return "redirect:/index_pracownik";
    }






    ////////KLIENT
    @RequestMapping("/new_klient")
    public String showNewForm_klient(Model model) {
        Klient klient = new Klient();
        model.addAttribute("klient", klient);
        return "new_form_klient";
    }

    @RequestMapping(value = "/save_klient", method = RequestMethod.POST)
    public String save_klient(@ModelAttribute("klient") Klient klient) {
        klientDAO.save(klient);

        return "redirect:/index_klient";
    }

    @RequestMapping("/edit_klient/{nr_klienta}")
    public ModelAndView showEditForm_klient(@PathVariable(name = "nr_klienta") int nr_klienta) {
        ModelAndView mav = new ModelAndView("edit_form_klient");
        Klient klient = klientDAO.get(nr_klienta);
        mav.addObject("klient", klient);
        return mav;
    }

    @RequestMapping(value = "/update_klient", method = RequestMethod.POST)
    public String update_klient(@ModelAttribute("klient") Klient klient) {
        klientDAO.update(klient);

        return "redirect:/index_klient";
    }






    @RequestMapping("/delete_klient/{nr_klienta}")
    public String delete_klient(@PathVariable(name = "nr_klienta") int nr_klienta) {
        klientDAO.delete(nr_klienta);

        return "redirect:/index_klient";
    }

}