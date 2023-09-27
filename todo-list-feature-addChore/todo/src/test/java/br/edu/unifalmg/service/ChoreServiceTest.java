package br.edu.unifalmg.service;

import br.edu.unifalmg.domain.Chore;
import br.edu.unifalmg.exception.DuplicatedChoreException;
import br.edu.unifalmg.exception.InvalidDeadlineException;
import br.edu.unifalmg.exception.InvalidDescriptionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ChoreServiceTest {

    @Test
    void addChoreWhenTheDescriptionIsInvalidThrowAnException() {
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, null)),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", null)),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().plusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().plusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().minusDays(1))),
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().minusDays(1)))
        );
    }

    @Test
    @DisplayName("#addChore > When the deadline is invalid > Throw an exception")
    void addChoreWhenTheDeadlineIsInvalidThrowAnException() {
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertThrows(InvalidDeadlineException.class,
                        () -> service.addChore("Description", null)),
                () -> assertThrows(InvalidDeadlineException.class,
                        () -> service.addChore("Description", LocalDate.now().minusDays(1)))
        );
    }

    @Test
    @DisplayName("#addChore > When adding a chore > When the chore already exists > Throw an exception")
    void addChoreWhenAddingAChoreWhenTheChoreAlreadyExistsThrowAnException() {
        ChoreService service = new ChoreService();
        service.addChore("Description", LocalDate.now());
        assertThrows(DuplicatedChoreException.class,
                () -> service.addChore("Description", LocalDate.now()));
    }

    /*
     * TODO: Create The following test cases:
     * 1. When adding a single chore. Compare the results (description, deadline, and isCompleted)
     * 2. When adding more than one chore. Also compare the results.
     *
     */
      @Test
    @DisplayName("#addChore > When adding a single chore")

    void addChoreWhenAddingASingleChore() {
          ChoreService service = new ChoreService();
          Chore choreReturned = service.addChore("Lavar a louça", LocalDate.of(2023, 9, 28));
          assertEquals("Lavar a louça", choreReturned.getDescription());
          assertEquals(LocalDate.of(2023, 9, 28), choreReturned.getDeadline());
          assertEquals(false, choreReturned.getIsCompleted());
      }

      @Test
      @DisplayName("#addChore > When adding more than one chore")
      void addChoreWhenAddingMoreThanOneChore() {
          ChoreService service = new ChoreService();
          Chore choreReturned1 = service.addChore("Lavar a louça", LocalDate.of(2023, 9, 28));
          Chore choreReturned2 = service.addChore("Arrumar o quarto", LocalDate.of(2023,9,27));

          assertEquals("Lavar a louça", choreReturned1.getDescription());
          assertEquals(LocalDate.of(2023, 9, 28), choreReturned1.getDeadline());
          assertEquals(false, choreReturned1.getIsCompleted());

          assertEquals("Arrumar o quarto", choreReturned2.getDescription());
          assertEquals(LocalDate.of(2023, 9, 27), choreReturned2.getDeadline());
          assertEquals(false, choreReturned2.getIsCompleted());
      }

}
