package com.airhacks.delta;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.security.Principal;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.airhacks.CustomPrincipal;

@Dependent
@RunWith(CdiTestRunner.class)
public class AliceUnitTest {

    @Produces
    public Principal customPrincipal() {

        return new CustomPrincipal("alice@example.com");

    }

    @Inject
    Principal principal;

    @Test
    public void injection() {
        assertThat(principal.getName(), is("alice@example.com"));
    }

}
