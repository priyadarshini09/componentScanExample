package guru.springframework.blog;

import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB1;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = DemoBeanB1.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DemoBeanB2.class))
public class BlogPostsApplicationExcludeAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        try{
            context.register(BlogPostsApplicationExcludeAnnotation.class);
            context.refresh();
            System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
            System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
        }finally {
            context.close();
        }
    }
}
