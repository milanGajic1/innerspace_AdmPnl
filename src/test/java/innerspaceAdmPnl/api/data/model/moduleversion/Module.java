package innerspaceAdmPnl.api.data.model.moduleversion;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module implements Serializable {

    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("moduleVersions")
    @Expose
    private List<String> moduleVersions;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;

    public Module() {
    }

    public Module(String identifier, String name, Integer id, List<String> moduleVersions, String created, String changed) {
        super();
        this.identifier = identifier;
        this.name = name;
        this.id = id;
        this.moduleVersions = moduleVersions;
        this.created = created;
        this.changed = changed;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public List<String> getModuleVersions() {
        return moduleVersions;
    }

    public void setModuleVersions(List<String> moduleVersions) {
        this.moduleVersions = moduleVersions;
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