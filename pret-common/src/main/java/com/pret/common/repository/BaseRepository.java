package com.pret.common.repository;

import com.pret.common.VersionedAuditableIdEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @param <T>
 */
@Repository()
@NoRepositoryBean()
@Component()
public interface BaseRepository<T extends VersionedAuditableIdEntity>
        extends PagingAndSortingRepository<T, String>, JpaSpecificationExecutor<T> {
}
