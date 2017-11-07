import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String firstname;
    private String lastname;
    private LocalDate birthdate;

    public String getFirstname()
    { return this.firstname; }
    public void setFirstname(String name)
    { this.firstname = name; }

    public String getLastname()
    { return this.lastname; }
    public void setLastname(String name)
    { this.lastname = name; }

    public LocalDate getBirthdate()
    { return birthdate; }
    public void setBirthdate(LocalDate birthdate)
    { this.birthdate = birthdate; }

    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - this.birthdate.getYear();

        /* First possibility.
        if (now.getMonthValue() >= this.birthdate.getMonthValue()) {
            if (now.getMonthValue() == this.birthdate.getMonthValue()) {
                if (now.getDayOfMonth() >= this.birthdate.getDayOfMonth()) {
                    age ++;
                }
            } else {
                age ++;
            }
        }
        */

        /* Second possibility.
        if (
            (now.getMonthValue() > this.birthdate.getMonthValue())
            || // OU
            (now.getMonthValue() == this.birthdate.getMonthValue()
                && // ET
                now.getDayOfMonth() >= this.birthdate.getDayOfMonth()
            )
        ) {
            age ++;
        }
        */

        /* Third possibility.
        if (now.getDayOfYear() >= this.birthdate.getDayOfYear()) {
            age ++;
        }
        */

        // Fourth possibility.
        age = Period.between(now, this.birthdate).getYears();

        return age;
    }
}
