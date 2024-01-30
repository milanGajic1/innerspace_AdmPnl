package innerspaceAdmPnl.api.data.model.common;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("locations")
    @Expose
    private List<Location> locations;
    @SerializedName("lastLogin")
    @Expose
    private String lastLogin;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;

    public User() {
    }

    public User(Integer id, String name, String email, String role, List<Location> locations, String lastLogin, String created, String changed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.locations = locations;
        this.lastLogin = lastLogin;
        this.created = created;
        this.changed = changed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
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