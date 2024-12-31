package com.bornfire.config;

import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

import com.bornfire.entities.UserProfile;
import com.bornfire.entities.UserProfileRep;

@Component
public class CustomSessionDestroyedListener implements ApplicationListener<SessionDestroyedEvent> {

    private final UserProfileRep userProfileRep;

    public CustomSessionDestroyedListener(UserProfileRep userProfileRep) {
        this.userProfileRep = userProfileRep;
    }

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        for (SecurityContext context : event.getSecurityContexts()) {
            Authentication authentication = context.getAuthentication();

            if (authentication != null) {
                String username = authentication.getName();
                System.out.println(username+" session out");
                Optional<UserProfile> up = userProfileRep.findById(username);
               

                if (up.isPresent()) {
                    UserProfile user = up.get();
                    user.setLogin_flg("N");
                    userProfileRep.save(user);
                }
            }
        }
    }
}
