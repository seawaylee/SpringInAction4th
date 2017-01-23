package data_persistent.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author NikoBelic
 * @create 22/01/2017 17:38
 */
@Document(collection = "companys")
public class CompanyDoc
{
    @Id
    private Integer cid;
    private String companyName;
    private String location;
    private String financing;
    Collection<MemberDoc> members = new HashSet<>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFinancing() {
        return financing;
    }

    public void setFinancing(String financing) {
        this.financing = financing;
    }

    public Collection<MemberDoc> getMembers() {
        return members;
    }

    public void setMembers(Collection<MemberDoc> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "CompanyDoc{" +
                "cid=" + cid +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", financing='" + financing + '\'' +
                ", members=" + members +
                '}';
    }
}
