package br.edu.unifalmg.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Chore {


    private String description;

    private Boolean isCompleted;

    private LocalDate deadline;




    @Override
    public int hashCode () {

        Random random = new Random();
        return random.nextInt(1000);

    }


    @Override
    public boolean equals (Object object) {
        Chore o = (Chore) object;
        return !description.equals(o.getDescription()) || !deadline.equals(o.getDeadline());
    }

}
