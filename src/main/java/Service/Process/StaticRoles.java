package Service.Process;

import Service.entities.Role;

public final class StaticRoles {
    private static Role writerRole = new Role();
    private static Role adminRole = new Role();

    public static Role getWriterRole() {
        return writerRole;
    }

    public static void setWriterRole() {
        writerRole.setTitle("Writer");
    }

    public static Role getAdminRole() {
        return adminRole;
    }

    public static void setAdminRole() {
        writerRole.setTitle("Admin");

    }
}
