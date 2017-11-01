package guru.springframework.blog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter
        (type = FilterType.REGEX, pattern = ".*[AB12]"))
public class BlogPostsApplicationFilterTypeRegex {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        try{
            context.register(BlogPostsApplicationFilterTypeRegex.class);
            context.refresh();
            System.out.println("Contains A  " + context.containsBean("demoBeanA"));
            System.out.println("Contains B1  " + context.containsBean("demoBeanB1"));
            System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
        }finally {
            context.close();
        }
    }
}
