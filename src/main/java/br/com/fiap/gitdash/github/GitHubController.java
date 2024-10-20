package br.com.fiap.gitdash.github;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/")
    public String getUserInfo(Model model, @RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient authorizedClient) {
        
        String tokenValue = authorizedClient.getAccessToken().getTokenValue();
        List<RepositoryInfo> repos = gitHubService.getUserRepositories(tokenValue);
        
        OAuth2User oauthUser = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = oauthUser.getAttribute("name");
        String avatar = oauthUser.getAttribute("avatar_url");
        String profile = oauthUser.getAttribute("html_url");
        model.addAttribute("repos", repos);
        model.addAttribute("name", name);
        model.addAttribute("avatar_url", avatar);
        model.addAttribute("html_url", profile);
        return "user";
    }
}