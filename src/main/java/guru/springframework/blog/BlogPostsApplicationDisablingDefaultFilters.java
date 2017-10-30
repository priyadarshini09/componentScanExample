package guru.springframework.blog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "guru.springframework.blog.componentscan.example.demopackageA", useDefaultFilters = false)
public class BlogPostsApplicationDisablingDefaultFilters {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        try{
            context.register(BlogPostsApplicationDisablingDefaultFilters.class);
            context.refresh();
            System.out.println("Contains A  " + context.containsBean("demoBeanA"));
        }finally {
            context.close();
        }
    }
}
