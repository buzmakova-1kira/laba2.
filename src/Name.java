public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    // Конструктор по умолчанию
    public Name() {
        this.lastName = "";
        this.firstName = "";
        this.middleName = "";
    }

    // Конструктор со всеми параметрами
    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Конструктор только с фамилией и именем
    public Name(String lastName, String firstName) {
        this(lastName, firstName, "");
    }
    // Конструктор только с именем и отчеством
    public Name(String firstName, String middleName, boolean dummy) {
        this("", firstName, middleName);
    }

    // Конструктор только с именем
    public Name(String firstName) {
        this("", firstName, "");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        // Добавляем только непустые значения
        if (lastName != null && !lastName.isEmpty()) {
            result.append(lastName);
        }

        if (firstName != null && !firstName.isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(firstName);
        }

        if (middleName != null && !middleName.isEmpty()) {
            if (result.length() > 0) result.append(" ");
            result.append(middleName);
        }

        return result.toString();
    }
}