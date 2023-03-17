package boot.spring.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	private byte staff_id;
	private String first_name;
	private String last_name;
	private short address_id;
	private String email;
	private String username;
	private String password;
	private String last_update;
}