package serverconfig.directimport;

import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.handler.spring.config.BackstopperSpringWebMvcConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Validation;
import javax.validation.Validator;

import testonly.componenttest.spring.reusable.controller.SampleController;
import testonly.componenttest.spring.reusable.error.SampleProjectApiErrorsImpl;

/**
 * Spring config that uses {@link Import} to integrate Backstopper via direct import of
 * {@link BackstopperSpringWebMvcConfig}.
 *
 * @author Nic Munroe
 */
@Configuration
@Import({
    // Import core Backstopper+Spring support.
    BackstopperSpringWebMvcConfig.class,
    // Import the controller.
    SampleController.class
})
@EnableWebMvc
public class Spring5WebMvcDirectImportConfig {

    @Bean
    public ProjectApiErrors getProjectApiErrors() {
        return new SampleProjectApiErrorsImpl();
    }

    @Bean
    public Validator getJsr303Validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
