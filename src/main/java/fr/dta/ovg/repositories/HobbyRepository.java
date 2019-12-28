/* Hobby Repository class.
 * @author Colin Cerveaux @C-ambium
 * Shared attributes between entity.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.dta.ovg.entities.Hobby;

/** Hobby Repository extends Jpa Repository. */
@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {


    /** Exist by hobby label Function.
     * @param hobby : Hobby entity.
     * @return true if the hobby already exist in the repository.*/
    @Query("SELECT COUNT(h) > 0" + " FROM Hobby h" + " WHERE LOWER(h.label) = LOWER(:#{#s.label})"
            + " AND (:#{#s.id} = NULL OR h.id != :#{#s.id})")
      boolean existsByLabel(@Param("s") Hobby hobby);
}
