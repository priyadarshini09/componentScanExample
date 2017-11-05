package guru.springframework.blog;

import guru.springframework.blog.componentscan.example.demopackageB.Custom;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"guru.springframework.blog.componentscan.example.demopackageA",
        "guru.springframework.blog.componentscan.example.demopackageB"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Custom.class),
        useDefaultFilters = false)
public class BlogPostsApplicationIncludeFilter {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.
                run(BlogPostsApplicationIncludeFilter.class,args);
            System.out.println("Contains A  " + context.containsBean("demoBeanA"));
            System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
            System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
    }
}
