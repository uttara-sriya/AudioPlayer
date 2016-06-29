package audio.recorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import audio.recorder.Model;
/**
 * Created by Sriya on 6/22/16.
 */
@RestController
@RequestMapping(value="/audio")
public class Controller {
    private AudioRepository audioRepository;
    @Autowired
    public Controller(AudioRepository audioRepository){
        this.audioRepository = audioRepository;
    }

    //Getting the data of all recordings
    @RequestMapping(value="/all" ,method= RequestMethod.GET, produces = "application/json")
    public List<Model> getAll(){
        return audioRepository.findAll();
    }

    //Getting a recording through recordId
    @RequestMapping(value = "/getRecording/{recordId}",method=RequestMethod.GET, produces = "application/json")
    public List<Model> findByrecordId(@PathVariable long recordId)
    {
       return  audioRepository.findByrecordId(recordId);
    }

    //Updating a record
    @RequestMapping(value="/update",method = RequestMethod.POST,produces = "application/json")
    public List<Model> create(@RequestBody Model recordModel){
        audioRepository.save(recordModel);
        return audioRepository.findAll();
    }

    //For deleting
    @RequestMapping(value="delete/{recordId}",method=RequestMethod.POST)
    public List<Model> remove(@PathVariable long recordId){
        audioRepository.delete(recordId);
        return audioRepository.findAll();
    }
}
