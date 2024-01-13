package innerspaceAdmPnl.api.data.model.moduleversion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ApplicationVersion implements Serializable {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("application")
    @Expose
    private Application application;

    public ApplicationVersion() {
    }

    public ApplicationVersion(String version, Integer id, String file, String created, String changed, Application application) {
        super();
        this.version = version;
        this.id = id;
        this.file = file;
        this.created = created;
        this.changed = changed;
        this.application = application;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}
