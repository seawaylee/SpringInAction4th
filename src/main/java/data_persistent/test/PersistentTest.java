package data_persistent.test;

import com.mongodb.Mongo;
import data_persistent.config.RootConfig;
import data_persistent.dao.UserDao;
import data_persistent.document.CompanyDoc;
import data_persistent.document.MemberDoc;
import data_persistent.mongodao.CompanyRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author NikoBelic
 * @create 22/01/2017 16:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class PersistentTest
{
    @Autowired
    private UserDao userDao;

    @Autowired
    MongoOperations mongo;

    @Autowired
    CompanyRepo companyRepo;

    // ***************** JDBCTemplate *******************/
    @Test
    public void addUser()
    {
        userDao.addUser();
    }
    @Test
    public void findUser()
    {
        System.out.println(userDao.findUserById(1));
    }


    // ***************** MongoDB *******************/

    @Test
    public void mongo_add()
    {
        CompanyDoc company = new CompanyDoc();
        company.setCid(1);
        company.setCompanyName("犀牛科技");
        company.setLocation("北京工业大学");
        company.setFinancing("天使轮");
        Collection<MemberDoc> members = new HashSet<>();
        for (int i = 0; i < 3; i++)
        {
            members.add(new MemberDoc(i+1,"员工",(18+i) + "","码农" + (char)(97 + i)));
        }
        company.setMembers(members);
        mongo.insert(company,"companys");
    }

    @Test
    public void mongo_findAll()
    {
        //List<CompanyDoc> cList = mongo.findAll(CompanyDoc.class,"companys");
        //List<CompanyDoc> cList = companyRepo.findAll();
        //List<CompanyDoc> cList = companyRepo.findByLocationLike("北京");
        CompanyDoc c = companyRepo.findWithQuery();
        System.out.println(c);
        //for (CompanyDoc companyDoc : cList)
        //{
        //    System.out.println(companyDoc);
        //}
    }

    @Test
    public void mongo_advance()
    {
        List<CompanyDoc> companyDocs = mongo.find(Query.query(Criteria.where("companyName").regex("^犀牛*")), CompanyDoc.class, "companys");
        System.out.println(companyDocs);
    }

}
