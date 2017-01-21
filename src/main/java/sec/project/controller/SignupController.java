package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("/")                 /// !!!
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, @RequestParam String pcode, @RequestParam String pword) {
        signupRepository.save(new Signup(name, address, pcode, pword));
        return "done";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String noou(){
       return "secrets"; 
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logg(){
       return "login"; 
    }

    
    
    //  A nice and easy way to check customers AT home!
   
    @RequestMapping("/users200900700")  
    @ResponseBody 
     public List<Signup> home() {
         List<Signup> msgs = signupRepository.findAll();
       //  if (msgs.isEmpty()) {
        //   return "No Customers";  (OK b4 List<Signup> etc by UI
        //   }
         
    //@RequestMapping  {
    // public String showUsers(Model model, Pageable pageable)  {
    //  model.addAttribute("user", signupRepository.findAll());
    // public List<Message> messages() {
        //return "user";
    return signupRepository.findAll();
    
        
      }

    
                
        // signupRepository.save(new Signup(name, address));
    //}
    
}
