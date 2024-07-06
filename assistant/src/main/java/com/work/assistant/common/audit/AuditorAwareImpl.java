package com.work.assistant.common.audit;

import com.work.assistant.security.service.UserDetailsImpl;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authenticationToken = SecurityContextHolder.getContext().getAuthentication();
        if (authenticationToken == null || !authenticationToken.isAuthenticated() || authenticationToken.getPrincipal() == "anonymousUser") {
//            log.debug("Not found AuthenticationToken");
            return null;
        }

        UserDetailsImpl userDetail = (UserDetailsImpl) authenticationToken.getPrincipal();
//        log.debug("Found AuthenticationToken: {}", authenticationUserDto);
        return Optional.of(userDetail.getId());
    }
}