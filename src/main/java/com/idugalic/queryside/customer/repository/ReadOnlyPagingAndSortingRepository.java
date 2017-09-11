package com.idugalic.queryside.customer.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.idugalic.queryside.customer.domain.Customer;

/**
 * A read only repository interface - save and delete operations will not be exported as a resource
 *
 */
@NoRepositoryBean
public interface ReadOnlyPagingAndSortingRepository extends PagingAndSortingRepository<Customer, String> {

    @Override
    @SuppressWarnings("unchecked")
    @RestResource(exported = false)
    Customer save(Customer entity);

    @Override
    @RestResource(exported = false)
    void delete(String aLong);

    @Override
    @RestResource(exported = false)
    void delete(Customer entity);
}
