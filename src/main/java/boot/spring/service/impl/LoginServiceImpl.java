package boot.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boot.spring.mapper.LoginMapper;
import boot.spring.po.Staff;
import boot.spring.service.LoginService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginmapper;
	
	public String getpwdbyname(String name) {
		Staff s=loginmapper.getpwdbyname(name);
		if(s!=null)
		return s.getPassword();
		else
		return null;
	}
	
	public Long getUidbyname(String name) {
		Staff s=loginmapper.getpwdbyname(name);
		if(s!=null)
			return (long) s.getStaff_id();
			else
			return null;
	}
	
	public String getnamebyid(long id) {
		Staff s=loginmapper.getnamebyid(id);
		if(s!=null)
			return s.getUsername();
			else
			return null;
	}

	@Override
	public Boolean insertUser(Staff staff) {
		return loginmapper.insertUser(staff);
	}
}