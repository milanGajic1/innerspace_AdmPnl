package innerspaceAdmPnl.api.data.model.moduleversion;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Application implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("folder")
    @Expose
    private String folder;
    @SerializedName("applicationVersions")
    @Expose
    private List<String> applicationVersions;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;

    public Application() {
    }

    public Application(String name, Integer id, String folder, List<String> applicationVersions, String created, String changed) {
        super();
        this.name = name;
        this.id = id;
        this.folder = folder;
        this.applicationVersions = applicationVersions;
        this.created = created;
        this.changed = changed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public List<String> getApplicationVersions() {
        return applicationVersions;
    }

    public void setApplicationVersions(List<String> applicationVersions) {
        this.applicationVersions = applicationVersions;
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

}
