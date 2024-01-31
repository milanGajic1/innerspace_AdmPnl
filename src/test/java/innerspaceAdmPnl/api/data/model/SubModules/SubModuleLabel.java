package innerspaceAdmPnl.api.data.model.SubModules;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubModuleLabel implements Serializable {

    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("startButtonText")
    @Expose
    private String startButtonText;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("subModules")
    @Expose
    private List<SubModule> subModules;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;

    public SubModuleLabel() {
    }

    public SubModuleLabel(String identifier, String name, String startButtonText, Integer id, List<SubModule> subModules, String created, String changed) {
        this.identifier = identifier;
        this.name = name;
        this.startButtonText = startButtonText;
        this.id = id;
        this.subModules = subModules;
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

    public String getStartButtonText() {
        return startButtonText;
    }

    public void setStartButtonText(String startButtonText) {
        this.startButtonText = startButtonText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SubModule> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<SubModule> subModules) {
        this.subModules = subModules;
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
