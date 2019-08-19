package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Homepage {

    @GetMapping("/")
    public String wellcomPage()
    {
        return "index";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("fName") String fName, Model model) {
        fName = fName.toUpperCase();

        model.addAttribute("fName", fName);
        return "helloWorld";
    }

}
