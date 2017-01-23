package data_persistent.document;

/**
 * @author NikoBelic
 * @create 22/01/2017 18:00
 */
public class MemberDoc
{
    private Integer mid;
    private String name;
    private String age;
    private String job;

    public MemberDoc(Integer mid, String name, String age, String job) {
        this.mid = mid;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "MemberDoc{" +
                "mid='" + mid + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
