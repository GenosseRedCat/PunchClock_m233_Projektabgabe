package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;


/***
 * This Interface was not created, but modified by Jason Banyer
 *
 *
 * Description of this class:
 * It extends the pre-existing JPA Repository and allows us to use "Entry" and "Long".
 *
 */
public interface EntryRepository extends JpaRepository<Entry, Long> {
}
