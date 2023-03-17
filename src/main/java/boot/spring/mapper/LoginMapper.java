package boot.spring.mapper;

import boot.spring.po.Staff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

	Staff getpwdbyname(String name);

	Staff getnamebyid(long id);

    Boolean insertUser(Staff staff);
}