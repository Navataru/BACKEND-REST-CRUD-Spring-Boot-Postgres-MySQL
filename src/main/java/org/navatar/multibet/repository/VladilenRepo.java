package org.navatar.multibet.repository;

import org.navatar.multibet.domain.Vladilen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VladilenRepo extends JpaRepository<Vladilen, Long> {
}
