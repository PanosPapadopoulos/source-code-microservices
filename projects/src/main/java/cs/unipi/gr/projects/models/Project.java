package cs.unipi.gr.projects.models;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "PROJECTS")
@Entity(name = "PROJECTS")
@Audited
public class Project implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROJECT_ID")
    private int projectId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "USR_ID")
    private int usrId;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "FILES_ID")
    private int filesid;

    @Column(name = "GIT")
    private String git;


    public Project() {
    }

    public Project(String name, String notes, String description, int usrId, String status, String type, int filesid, String git) {
        this.name = name;
        this.notes = notes;
        this.description = description;
        this.usrId = usrId;
        this.status = status;
        this.type = type;
        this.filesid = filesid;
        this.git = git;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFilesid() {
        return filesid;
    }

    public void setFilesid(int filesid) {
        this.filesid = filesid;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", description='" + description + '\'' +
                ", usrId=" + usrId +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", filesid=" + filesid +
                ", git='" + git + '\'' +
                '}';
    }
}