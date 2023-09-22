package service;

import org.example.ChoreService;
import org.example.exception.DuplicatedChoreException;
import org.example.exception.InvalidDeadlineException;
import org.example.exception.InvalidDescriptionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChoreServiceTest {

// data inválida, data antiga, tarefa duplicada (descrição e deadline iguais)


@Test

    void addChoreWhenDescriptionIsInvalidThrowAnException () {

    ChoreService service = new ChoreService();


    assertAll(

            () -> assertThrows(InvalidDescriptionException.class, () -> service.addChore(null, null)),

            () -> assertThrows(InvalidDescriptionException.class, () -> service.addChore("", null)),

            () -> Assertions.assertThrows(InvalidDescriptionException.class, () -> service.addChore(null, LocalDate.now().plusDays(1))),

            () -> Assertions.assertThrows(InvalidDescriptionException.class, () -> service.addChore(null, LocalDate.now().minusDays(1)))

            // independe do dealine
    );


}


    @Test
    @DisplayName( "When the deadline is invalid > throw an exception")

    void addChoreWhenTheDeadlineisInvalidThrowAnException() {

        ChoreService service = new ChoreService();

        assertAll(

                () -> assertThrows(InvalidDeadlineException.class, () -> service.addChore("Description", null)),

                () -> assertThrows(InvalidDeadlineException.class, () -> service.addChore("Description", LocalDate.now().minusDays(1))),

                () -> Assertions.assertThrows(InvalidDeadlineException.class, () -> service.addChore(null, LocalDate.now()))

                // independe do dealine
        );

    }



        @Test
        @DisplayName("#add chore > When the chore already exists > throw an exception ")

    void addChoreWhenTheChoreAlreadyExistsThrowAnException () {

            ChoreService service = new ChoreService();

            service.addChore("Description", LocalDate.now());

            assertThrows(DuplicatedChoreException.class, () -> service.addChore("Description", LocalDate.now()));

        }










    }






