public class BuilderPattern2 {

    public static void main(String... args) {

        Student himalayeStudent = new CollageStudent.Builder("Computer")
                .roll(123)
                .name("Ram")
                .build();

        Student manoharSchoolStudent = new SchoolStudent.Builder()
                .level(5)
                .roll(567)
                .name("Hari").build();

        System.out.println(himalayeStudent);
        System.out.println(manoharSchoolStudent);

    }

}


abstract class Student {
    private final int roll;
    private final String name;

    static abstract class Builder<T extends Builder<T>> {
        private int roll;
        private String name;

        public Builder<T> name(String name) {
            this.name = name;
            return self();
        }

        public Builder<T> roll(int roll) {
            this.roll = roll;
            return self();
        }

        public abstract Student build();

        public abstract T self();
    }

    Student(Builder<?> builder) {
        this.roll = builder.roll;
        this.name = builder.name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                '}';
    }
}

class CollageStudent extends Student {
    private final String faculty;

    static class Builder extends Student.Builder<Builder> {
        private final String faculty;

        public Builder(String faculty) {
            this.faculty = faculty;
        }

        public CollageStudent build() {
            return new CollageStudent(this);
        }

        public Builder self() {
            return this;
        }
    }

    private CollageStudent(Builder builder) {
        super(builder);
        this.faculty = builder.faculty;
    }

    @Override
    public String toString() {
        return super.toString()+" : CollageStudent{" +
                "faculty='" + faculty + '\'' +
                '}';
    }
}

class SchoolStudent extends Student {
    private final int level;

    static class Builder extends Student.Builder<Builder> {
        private int level;

        public Builder level(int level) {
            this.level = level;
            return this;
        }

        public Student build() {
            return new SchoolStudent(this);
        }

        public Builder self() {
            return this;
        }
    }

    private SchoolStudent(Builder builder) {
        super(builder);
        this.level = builder.level;
    }

    @Override
    public String toString() {
        return super.toString()+" : SchoolStudent{" +
                "level=" + level +
                '}';
    }
}