package Design.CampusConnect.repo;

import java.util.List;
import Design.CampusConnect.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PostRepo extends JpaRepository<Post, Integer> {


    // PostedIn is the groupId the Post is posted in
    @Query("select t from Post t where t.postedIn =:groupId")
    List<Post> findByPostedIn(@Param("groupId") int groupId);

}
