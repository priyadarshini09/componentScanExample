package guru.springframework.blog;

import guru.springframework.blog.componentscan.example.demopackageA.DemoBeanA;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB1;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB2;
import guru.springframework.blog.componentscan.example.demopackageC.DemoBeanC;
import guru.springframework.blog.componentscan.example.demopackageD.DemoBeanD;
import guru.springframework.blog.componentscan.example.demopackageE.DemoBeanE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"guru.springframework.blog.componentscan.example.demopackageA",
        "guru.springframework.blog.componentscan.example.demopackageD",
        "guru.springframework.blog.componentscan.example.demopackageE"}, basePackageClasses = DemoBeanB1.class)
public class BlogPostsApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        try{
            context.register(BlogPostsApplication.class);
            context.refresh();
            System.out.println("Spring ComponentScan Example "
                    +context.getBean(BlogPostsApplication.class));
            System.out.println("DemoBeanA " + context.getBean(DemoBeanA.class));
            System.out.println("DemoBeanB1 " + context.getBean(DemoBeanB1.class));
            System.out.println("Contains B2  " + context.containsBean("demoBeanB2"));
            System.out.println("Contains C   " + context.containsBean("demoBeanC"));
            System.out.println("DemoBeanD " + context.getBean(DemoBeanD.class));
            System.out.println("DemoBeanE " + context.getBean(DemoBeanE.class));

        }finally {
            context.close();
        }
    }
}
