package audio.recorder;

import javax.persistence.*;

/**
 * Created by Sriya on 6/22/16.
 */
@Entity
@Table(name = "audio_details")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long recordId;
    @Column
    String userRecording;
    @Column
    String topicName;
    @Column
    int numberOfRecordings;
    @Column
    String reference;
    @Column
    String comments;
    @Column
    String source;

    //important to have default constructor
    public Model(){}
    public Model(String userRecording, String topicName, int numberOfRecordings,String reference,String comments,String source){
        this.userRecording=userRecording;
        this.topicName = topicName;
        this.numberOfRecordings=numberOfRecordings;
        this.reference = reference;
        this.comments = comments;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getUserRecording() {
        return userRecording;
    }

    public void setUserRecording(String userRecording) {
        this.userRecording = userRecording;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getNumberOfRecordings() {
        return numberOfRecordings;
    }

    public void setNumberOfRecordings(int numberOfRecordings) {
        this.numberOfRecordings = numberOfRecordings;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.getRecordId()).append(", ")
                .append(this.getUserRecording()).append(", ")
                .append(this.getTopicName()).append(", ")
                .append(this.getNumberOfRecordings()).append(", ")
                .append(this.getReference()).append(", ")
                .append(this.getComments()).append(", ")
                .append(this.getSource());
        return builder.toString();
    }


}
