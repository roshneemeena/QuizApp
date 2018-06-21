package fr.epita.quiz.services;

import fr.epita.quiz.dao.AdminDAO;
import fr.epita.quiz.dao.StudentDAO;
import fr.epita.quiz.model.Admin;

public class AdminServiceImpl implements AdminService {
private AdminDAO adminDao;
	
	
	public void setAdminDao(AdminDAO adminDAO) {
		this.adminDao = adminDAO ;
	}

	@Override
	public Admin loginStudent(Admin admin) {
		return adminDao.loginAdmin(admin);
	}

}
