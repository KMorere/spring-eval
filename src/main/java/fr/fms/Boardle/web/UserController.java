package fr.fms.Boardle.web;

import fr.fms.Boardle.dao.AppUserRepository;
import fr.fms.Boardle.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final String REDIRECT = "redirecti:/index";

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, Model model) {
        Optional<AppUser> user = userRepository.findByUsername(username);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            session.setAttribute("currentUser", user.get());
            if (user.get().getRole().equals("ADMIN")) {
                return REDIRECT;
            }
            return REDIRECT;
        }
        model.addAttribute("error", "Identifiants incorrect");
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           HttpSession session) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "redirect:/register?error=exists";
        }

        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        userRepository.save(user);

        session.setAttribute("currentUser", user);
        return REDIRECT;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return REDIRECT;
    }
}
