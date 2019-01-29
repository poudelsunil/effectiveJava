public class BuilderPattern {
    public static void main(String...args){
        Student student = new Student.Builder(123).name("Ram").address("Kathmandu").build();
        System.out.println(student);
    }
}


class Student{
    private final int roll;
    private final String name;
    private final String address;

    public static class Builder{
        private final int roll;

        private String name = "";
        private String address = "";

        public Builder(int roll) {
            this.roll = roll;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    private Student(Builder builder){
        roll = builder.roll;
        name = builder.name;
        address = builder.address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}