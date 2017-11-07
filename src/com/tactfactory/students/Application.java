package com.tactfactory.students;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 4) Nous gérrons maintenant des professeurs, qui ont :
 * - nom
 * - prenom
 * - date de naissance
 * - matière enseignée
 * Modifier l'UML puis le java.
 *
 * 5) Les étudiants suivent des cours enseignés par des professeurs.
 * - 1 cours = 1 professeur, une matière, un nombre de jours
 * Modifier l'UML puis le java.
 */
public class Application {
    public static void main(String[] args) {
        int studentNumber = 40;

        School imiee = new School();
        School iia   = new School();

        imiee.setName("IMIEE");
        imiee.setAddress("ICI");

        iia.setName("IIA");
        iia.setAddress("Laval");

        List<Student> students = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < studentNumber; ++ i) {
            Student s = new Student();

            int year    = random.nextInt(20) + 1990; // [1990-2009]
            int day     = random.nextInt(28) + 1;    // [   1-  28]
            String date = String.format("%04d-08-%02d", year, day);

            s.setBirthdate(LocalDate.parse(date));
            s.setComeYear(LocalDate.now().getYear());
            s.setGradient("POEI Capgemini OCT 2017");
            s.setFirstname("Baby" + i);
            s.setLastname("Prêt-Cosse");

            s.setSchool( (i % 2 == 0 ? imiee : iia) );
            /*
            if (i % 2 == 0) {
                s.setSchool(imiee);
            } else {
                s.setSchool(iia);
            }
            */

            students.add(s);
        }

        for (Student instance:students) {
            System.out.println(
                    instance.getLastname() + " " + instance.getFirstname()
                    + " (" + instance.getAge() + " ans) : "
                    + instance.getSchool().getName()
            );
        }
    }
}
