package Service.Process;

import Repositories.EntityDAO.RoleDAO;
import Service.entities.Role;

public final class StaticRoles {
    private static RoleDAO roleDAO = new RoleDAO();
    private static Role writerRole = new Role();
    private static Role adminRole = new Role();

    public static Role getWriterRole() {
        if (!(roleDAO.selectByName("Writer").isPresent())) {
            writerRole.setTitle("Writer");
            roleDAO.add(writerRole);
        }
        return roleDAO.selectByName("Writer").get();

    }

    public static Role getAdminRole() {
        if (!(roleDAO.selectByName("Admin").isPresent())) {
            adminRole.setTitle("Admin");
            roleDAO.add(adminRole);
        }
        return roleDAO.selectByName("Admin").get();

    }
}
