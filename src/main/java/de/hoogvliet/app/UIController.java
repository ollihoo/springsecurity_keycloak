package de.hoogvliet.app;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller @Log4j2
public class UIController {
    @GetMapping("/")
    public String getIndex(Model model, Authentication auth) {
        log.info("/index,html reached");
        model.addAttribute("name",
                auth instanceof OAuth2AuthenticationToken oauth && oauth.getPrincipal() instanceof OidcUser oidc
                        ? oidc.getPreferredUsername()
                        : "");
        model.addAttribute("isAuthenticated",
                auth != null && auth.isAuthenticated());
        model.addAttribute("isNice",
                auth != null && auth.getAuthorities().stream().anyMatch(authority -> {
                    return Objects.equals("NICE", authority.getAuthority());
                }));
        return "index.html";
    }

    @GetMapping("/nice")
    public String getNice(Model model, Authentication auth) {
        return "nice.html";
    }
}