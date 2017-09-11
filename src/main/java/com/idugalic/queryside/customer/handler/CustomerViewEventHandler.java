package com.idugalic.queryside.customer.handler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.SequenceNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.idugalic.common.blog.event.BlogPostCreatedEvent;
import com.idugalic.queryside.customer.domain.Customer;
import com.idugalic.queryside.customer.repository.CustomerRepository;

/**
 * Event handlers
 *
 */
@ProcessingGroup("default")
@Component
public class CustomerViewEventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerViewEventHandler.class);

    @Autowired
    private CustomerRepository myAggregateRepository;

    @EventHandler
    public void handle(BlogPostCreatedEvent event, @SequenceNumber Long version) {
        LOG.info("CustomerCreatedEvent: [{}] ", event.getId());
        myAggregateRepository.save(new Customer(event, version));
    }
}
