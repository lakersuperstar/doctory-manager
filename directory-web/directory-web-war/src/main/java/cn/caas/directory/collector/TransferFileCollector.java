package cn.caas.directory.collector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.caas.directory.domain.TaskFileVO;
import cn.caas.directory.service.TransferFileService;

@Controller
@RequestMapping("/transferFile")
public class TransferFileCollector {

	// @Resource
	private TransferFileService transferFileService;

	@RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String addTransferTaskFile(HttpServletRequest request,
			HttpServletResponse response, TaskFileVO fileVO) {
		// long taskId = transferTaskService.addTransferTask(userId);
		// transferFileService.betchAddTransferFileService(taskId, userId,
		// fromFile, toFolder);
		System.out.println(fileVO.toString());
		
		return "ok";
	}
}
