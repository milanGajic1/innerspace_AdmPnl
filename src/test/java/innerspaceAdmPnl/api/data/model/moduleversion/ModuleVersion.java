package innerspaceAdmPnl.api.data.model.moduleversion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModuleVersion implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("applicationVersion")
    @Expose
    private ApplicationVersion applicationVersion;
    @SerializedName("module")
    @Expose
    private Module module;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("beta")
    @Expose
    private Boolean beta;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;

    public ModuleVersion() {
    }

    public ModuleVersion(Integer id, String version, ApplicationVersion applicationVersion, Module module, Integer status, Boolean beta, String created, String changed) {
        super();
        this.id = id;
        this.version = version;
        this.applicationVersion = applicationVersion;
        this.module = module;
        this.status = status;
        this.beta = beta;
        this.created = created;
        this.changed = changed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ApplicationVersion getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(ApplicationVersion applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getBeta() {
        return beta;
    }

    public void setBeta(Boolean beta) {
        this.beta = beta;
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
