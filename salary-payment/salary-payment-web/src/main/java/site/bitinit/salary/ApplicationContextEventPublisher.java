package site.bitinit.salary;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import site.bitinit.salary.common.event.DomainEvent;
import site.bitinit.salary.common.event.DomainEventPublisher;

/**
 * @author john
 * @date 2021/10/24
 */
@Component
public class ApplicationContextEventPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish(ApplicationEvent domainEvent) {
        this.applicationContext.publishEvent(domainEvent);
    }
}
