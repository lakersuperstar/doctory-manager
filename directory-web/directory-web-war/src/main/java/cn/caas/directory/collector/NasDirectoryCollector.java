package cn.caas.directory.collector;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.caas.directory.domain.FileDirectoryVO;
import cn.caas.directory.domain.NasFileVO;
import cn.caas.directory.service.NasDirectoryService;
import cn.caas.directory.util.JsonSerializeUtil;

@Controller
@RequestMapping({ "/directory" })
public class NasDirectoryCollector {

	private static Logger LOGGER = LoggerFactory
			.getLogger(NasDirectoryCollector.class);

	@Resource
	NasDirectoryService nasDirectoryService;

	@RequestMapping(value = "/isDirectory", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String isDirectory(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,
			@RequestParam("fullName") String fullName) {

		System.out.println(fullName);
		return fullName;
	}

	@RequestMapping(value = "/getFile", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String getFileName(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, NasFileVO nasFileVO) {
		try {
			LOGGER.info("接收参数" + nasFileVO.toString());
			String resultJson = null;
			if (nasFileVO == null) {
				resultJson = JsonSerializeUtil
						.serializeObject2Json(nasDirectoryService
								.getChildFilePathVO(null, null));
			} else {
				resultJson = JsonSerializeUtil
						.serializeObject2Json(nasDirectoryService
								.getChildFilePathVO(nasFileVO.getFullName(),
										nasFileVO.getId()));
			}
			LOGGER.info("返回值为：" + nasFileVO.toString());
			return resultJson;
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping(value = "/addFile", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String submitFileName(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,
			FileDirectoryVO fileDirectoryVO) {
		LOGGER.info(fileDirectoryVO.toString());
		return "error";
	}

}
