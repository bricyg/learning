package site.bitinit.salary.common.event;

/**
 * 领域事件发布器
 * @author john
 * @date 2021/10/23
 */
public interface DomainEventPublisher<T extends DomainEvent> {
    /**
     * 发布领域事件
     * @param domainEvent 领域事件
     */
    void publish(T domainEvent);
}
