package audio.recorder;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sriya on 6/17/16.
 */
@Repository
public interface AudioRepository extends JpaRepository<Model,Long>{
    //for finding a recording using its id
    List<Model> findByrecordId(long recordId);
//    List<AudioModel> findByaudioId(long audioId);

}
