package site.bitinit.salary.controller;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.bitinit.salary.ApplicationContextEventPublisher;
import site.bitinit.salary.common.event.DomainEvent;
import site.bitinit.salary.common.event.DomainEventPublisher;

import javax.annotation.Resource;

/**
 * @author john
 * @date 2021/10/24
 */
@RestController
public class TestController {
    @Resource
    private ApplicationContextEventPublisher eventPublisher;

    @GetMapping("/t")
    public void test() {
        System.out.println(Thread.currentThread().getName());
        eventPublisher.publish(new OwnEvent(new User("john", 11)));

        System.out.println("finished!!!\n");
    }

    private static class User{
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "OwnEvent{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static class OwnEvent extends ApplicationEvent {

        public OwnEvent(User user) {
            super(user);
        }
    }

    @Component
    public static class OwnEventListener implements ApplicationListener<OwnEvent> {

        @Override
        public void onApplicationEvent(OwnEvent event) {
            System.out.println(event.getSource());
            System.out.println(Thread.currentThread().getName());
        }
    }

    @Component
    public static class OwnEventListener1 implements ApplicationListener<OwnEvent> {
        @Override
        public void onApplicationEvent(OwnEvent event) {
            System.out.println(event.getSource());
            System.out.println(Thread.currentThread().getName() + "  111111");

        }
    }
}
