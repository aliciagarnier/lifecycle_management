package org.example;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


public class Chore {

    private String description;

    private Boolean isCompleted;

    LocalDate deadline;


    public Chore (String description, LocalDate deadline)
    {

        this.description = description;
        this.deadline = deadline;
        this.isCompleted = Boolean.FALSE;


    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }
}
