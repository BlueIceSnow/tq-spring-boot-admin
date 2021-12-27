package com.tianqi.admin.config;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import de.codecentric.boot.admin.server.notify.LoggingNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 提醒
 * @author yuantianqi
 */
@Component
public class CustomNotifier extends AbstractEventNotifier {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingNotifier.class);

  public CustomNotifier(InstanceRepository repository) {
    super(repository);
  }

  @Override
  protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

    return Mono.fromRunnable(() -> {
      if (event instanceof InstanceStatusChangedEvent) {
        LOGGER.info("Instance {} ({}) is {}", instance.getRegistration().getName(), event.getInstance(),
            ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
      }
      else {
        LOGGER.info("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(),
            event.getType());
      }
    });
  }

}