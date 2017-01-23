package data_persistent.mongodao;

import data_persistent.document.CompanyDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author NikoBelic
 * @create 23/01/2017 12:57
 */
public interface CompanyRepo extends MongoRepository<CompanyDoc,Integer>
{
    List<CompanyDoc> findByLocationLike(String location);

    @Query("{'companyName':'犀牛科技'}")
    CompanyDoc findWithQuery();
}
