package cn.caas.directory.collector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.caas.directory.domain.FileDirectoryVO;
import cn.caas.directory.domain.UserFolderVO;

@Controller
@RequestMapping({ "/user" })
public class UserFolderCollector {

	@RequestMapping(value = "/getUserName", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getUserName(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,
			UserFolderVO userFolderVO) {
		System.out.println(userFolderVO.getUserName());
		return "ok" + userFolderVO.getUserName();
	}

	@RequestMapping(value = "/addUserFolder", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getFileName(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,
			FileDirectoryVO fileDirectoryVO) {

		return "ok";
	}

}
