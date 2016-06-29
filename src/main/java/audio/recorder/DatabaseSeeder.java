package audio.recorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sriya on 6/17/16.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner{
    private AudioRepository audioRepository;
    private AudioRepository aRepository;
    private List<Model> recordings;
//    private List<AudioModel> audioRecordings;
    @Autowired
    public DatabaseSeeder(AudioRepository audioRepository){
        this.audioRepository = audioRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
        recordings=new ArrayList<>();
//        audioRecordings=new ArrayList<>();
        Model aRecord=new Model("/media/bts.mp3" ,"Introduction",5,"pageno 22","Refer wiki","Sumith");
        Model bRecord=new Model("/media/intro.mp3", "Kinetics",3,"pageno 35","NCERT","Rajith");
        Model cRecord=new Model("/media/dope.mp3","Organic Chemistry",4,"pageno 44","NCERT","Ramki");
        Model dRecord=new Model("/media/intro.mp3", "Inorganic Chemistry",2,"pageno 55","NCERT","Suji");
        recordings.add(aRecord);
        recordings.add(bRecord);
        recordings.add(cRecord);
        recordings.add(dRecord);
        audioRepository.save(recordings);

//        AudioModel playlist1=new AudioModel("/media/bts.mp3" ,"Science","3:08");
//        AudioModel playlist2=new AudioModel("/media/intro.mp3" ,"Social","4:00");
//        AudioModel playlist3=new AudioModel("/media/dope.mp3" ,"English","2:05");
//        audioRecordings.add(playlist1);
//        audioRecordings.add(playlist2);
//        audioRecordings.add(playlist3);
//        aRepository.save(audioRecordings);




    }


}
