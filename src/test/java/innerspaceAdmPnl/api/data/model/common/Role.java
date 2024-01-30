package innerspaceAdmPnl.api.data.model.common;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import innerspaceAdmPnl.api.data.model.accesspermission.AccessPermission;

public class Role implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("users")
    @Expose
    private List<User> users;
    @SerializedName("accessPermissions")
    @Expose
    private List<AccessPermission> accessPermissions;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("changed")
    @Expose
    private String changed;

    public Role() {
    }

    public Role(String name, Integer id, Customer customer, List<User> users, List<AccessPermission> accessPermissions, String created, String changed) {
        this.name = name;
        this.id = id;
        this.customer = customer;
        this.users = users;
        this.accessPermissions = accessPermissions;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<AccessPermission> getAccessPermissions() {
        return accessPermissions;
    }

    public void setAccessPermissions(List<AccessPermission> accessPermissions) {
        this.accessPermissions = accessPermissions;
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