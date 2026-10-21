package org.example.designpatternslab;

import org.example.designpatternslab.difexamples.ClientComponent;
import org.example.designpatternslab.difexamples.SingletonComponent;
import org.example.designpatternslab.difexamples.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DesignPatternsLabApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(DesignPatternsLabApplication.class, args);

        TransientComponent transientBean =
                context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        SingletonComponent singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c1 =
                context.getBean(ClientComponent.class);
        c1.operation();

        ClientComponent c2 =
                context.getBean(ClientComponent.class);
        c2.operation();
    }
}