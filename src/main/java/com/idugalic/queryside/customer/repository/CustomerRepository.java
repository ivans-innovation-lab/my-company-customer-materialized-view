package com.idugalic.queryside.customer.repository;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * A JPA repository interface.
 *
 */
@NoRepositoryBean
public interface CustomerRepository extends ReadOnlyPagingAndSortingRepository {
}
