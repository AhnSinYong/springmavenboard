package spring.maven.board.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ahnsy on 2017-10-05.
 */
@Slf4j
public class CustomJdbcDaoImpl extends JdbcDaoImpl{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetails> users = loadUsersByUsername(username);

        if (users.size() == 0) {
            log.debug("Query returned no results for user '" + username + "'");
            UsernameNotFoundException ue = new UsernameNotFoundException((messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found")));
            throw ue;
        }

        CustomUserDetails user = (CustomUserDetails) users.get(0);
        Set<GrantedAuthority> authoritySet = new HashSet<>();

        if (getEnableAuthorities()) {
            authoritySet.addAll(loadUserAuthorities(user.getUsername()));
        }

        if (getEnableGroups()) {
            authoritySet.addAll(loadGroupAuthorities(user.getUsername()));
        }

        List<GrantedAuthority> authorities = new ArrayList<>(authoritySet);


        return super.loadUserByUsername(username);
    }

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return super.loadUsersByUsername(username);
    }
}
