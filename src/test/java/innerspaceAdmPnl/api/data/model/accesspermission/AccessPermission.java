package innerspaceAdmPnl.api.data.model.accesspermission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import innerspaceAdmPnl.api.data.model.common.Role;

import java.io.Serializable;

public class AccessPermission implements Serializable {

    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("read")
    @Expose
    private Boolean read;
    @SerializedName("write")
    @Expose
    private Boolean write;
    @SerializedName("create")
    @Expose
    private Boolean create;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("role")
    @Expose
    private Role role;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("accessType")
    @Expose
    private Integer accessType;

    public AccessPermission() {
    }

    public AccessPermission(String section, Boolean read, Boolean write, Boolean create, Integer id, Role role, String created, String changed, Integer accessType) {
        this.section = section;
        this.read = read;
        this.write = write;
        this.create = create;
        this.id = id;
        this.role = role;
        this.created = created;
        this.changed = changed;
        this.accessType = accessType;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Boolean getWrite() {
        return write;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

    public Boolean getCreate() {
        return create;
    }

    public void setCreate(Boolean create) {
        this.create = create;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

}