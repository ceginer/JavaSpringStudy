package Patient_management;

public class Patient {
    private String pid; // 환자 id
    private String name; // 환자 이름
    private String age; // 환자 나이
    private String status; // 환자 상태

    public Patient(String pid, String name, String age, String status) {
        this.pid = pid;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }

}
