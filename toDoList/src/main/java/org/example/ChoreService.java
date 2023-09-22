package org.example;

import org.example.exception.DuplicatedChoreException;
import org.example.exception.InvalidDeadlineException;
import org.example.exception.InvalidDescriptionException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ChoreService {

    private final List<Chore> chores;

    public ChoreService () {

        this.chores = new ArrayList<>();
    }


    public Chore addChore (String description, LocalDate deadline)  {

        if (description == null || description.isEmpty()) { // nullPointerException

            throw new InvalidDescriptionException("A descrição não pode ser vazia!");

        }

        if (deadline == null || deadline.isBefore(LocalDate.now())) {

            throw new InvalidDeadlineException("Data inválida");

        }

        boolean choreExists = chores.stream().anyMatch(chore -> chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline));

        if (choreExists) {

            throw new DuplicatedChoreException("Tarefa duplicada.");

        }

//        for(Chore chore: chores) {
//
//            if (chore.getDescription().equals(description) && chore.getDeadline().equals(deadline)) {
//
//                throw new DuplicatedChoreException("Tarefa duplicada.");
//
//            }
//        }

       Chore newChore = new Chore(description, deadline);

        chores.add(newChore);
        return newChore;

    }
}
