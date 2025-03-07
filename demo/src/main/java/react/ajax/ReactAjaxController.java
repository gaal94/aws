package react.ajax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ReactAjaxController {
	@CrossOrigin(origins="*")
	@RequestMapping("/helloajax")
	public LoginDTO test() {
		return new LoginDTO("boot id", 1234);
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@GetMapping("/helloajaxparam")
	public LoginDTO test(String id, int pw) {
		return new LoginDTO(id, pw);
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@PostMapping("/helloajaxparam")
	public LoginDTO test(@RequestBody LoginDTO dto) {
		return dto;
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@GetMapping("/helloajaxarray")
	public int[] testarray(int[] ids) {
		return ids;
	}
	
	@CrossOrigin(origins="http://localhost:4000")
	@PostMapping("/helloajaxobjectarray")
	public PlayerDTO testplayer(@RequestBody Map<String, Object> parameters) throws Exception {
		String json = parameters.get("playerArray").toString();
		ObjectMapper mapper = new ObjectMapper();
		List<PlayerDTO> playerList = mapper.readValue(json, new TypeReference<ArrayList<PlayerDTO>>() {});
		for(PlayerDTO dto : playerList) {
			if(dto.player.equals("sone")) {					
				return new PlayerDTO(dto.player, dto.goal, "손흥민", "한국");
			}
		}
		return new PlayerDTO("알수없음", 0, "이름모름", "국적모름");
	}
}

class LoginDTO {
	String id;
	int pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public LoginDTO() {}
	public LoginDTO(String id, int pw) {
		this.id = id;
		this.pw = pw;
	}
}

class PlayerDTO {
	String player;
	int goal;
	String fullName;
	String nation;
	
	public PlayerDTO() {
		super();
	}
	public PlayerDTO(String player, int goal, String fullName, String nation) {
		super();
		this.player = player;
		this.goal = goal;
		this.fullName = fullName;
		this.nation = nation;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
}