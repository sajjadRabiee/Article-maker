package Service.Process;

import Service.entities.Role;

public class StaticRoles {
    Role writerRole = new Role();
    Role adminRole = new Role();

    public Role getWriterRole() {
        return writerRole;
    }

    public void setWriterRole() {
        writerRole.setTitle("Writer");
    }

    public Role getAdminRole() {
        return adminRole;
    }

    public void setAdminRole() {
        writerRole.setTitle("Admin");

    }
}
