package blog.main.dao;

import blog.main.entity.Company;

public interface CompanyDAO {

	public Company getCompanyInfo();
	
	public void saveCompanyInfo(Company company);
}
