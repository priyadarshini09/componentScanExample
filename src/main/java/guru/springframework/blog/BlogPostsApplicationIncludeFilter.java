package guru.springframework.blog;

import guru.springframework.blog.componentscan.example.demopackageB.Custom;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        try{
            context.register(BlogPostsApplicationIncludeFilter.class);
            context.refresh();
            System.out.println("Contains A  " + context.containsBean("demoBeanA"));
            System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
            System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
        }finally {
            context.close();
        }
    }
}
