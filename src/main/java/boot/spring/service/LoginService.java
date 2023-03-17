package boot.spring.service;
import boot.spring.po.Staff;

public interface LoginService {

	String getpwdbyname(String name);

	Long getUidbyname(String name);

	String getnamebyid(long id);

    Boolean insertUser(Staff staff);
}