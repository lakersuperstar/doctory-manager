package cn.caas.directory.collector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.caas.directory.service.TransferTaskService;

@Controller
@RequestMapping({ "/transferTask" })
public class TransferTaskCollector {

//	@Resource
	private TransferTaskService transferTaskService;

	@RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String addTransferTask(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("userId") long userId) {
//		long taskId = transferTaskService.addTransferTask(userId);
//		return taskId + "";
		return "1";
	}

	@RequestMapping(value = "/init", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String initTransferTask(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("taskId") long taskId) {
		boolean flag = transferTaskService.updateTransferTaskInit(taskId);
		if (flag) {
			return "ok";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/query", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String queryTransferTask() {

		return "ok";
	}

}
